package com.github.roar109.launcher.job;

import com.github.roar109.launcher.event.EventBusHolder;
import com.github.roar109.launcher.event.dto.DecreaseEvent;
import com.github.roar109.launcher.event.dto.IncreaseEvent;
import com.github.roar109.launcher.provider.ExchangeProvider;
import com.github.roar109.launcher.rest.dto.TickerResponse;
import com.github.roar109.launcher.types.ParameterNames;
import com.github.roar109.launcher.types.TicketTypes;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.awt.*;
import java.math.BigDecimal;


public class CurrencyChangeTicketJob implements Job {

    private final String DECREASE_SUCCESS_MESSAGE = "*** Trade %s its below specific percentage %s, current exchange value: %f";
    private final String DECREASE_FAIL_MESSAGE = "Trade %s still above percentage %s, base price: %f; current exchange value: %f";
    private final String INCREASE_SUCCESS_MESSAGE = "*** Trade %s its above specific percentage %s, current exchange value: %f";
    private final String INCREASE_FAIL_MESSAGE = "Trade %s still below increase percentage %s, base price: %f; current exchange value: %f";

    private final Logger LOG = Logger.getLogger(CurrencyChangeTicketJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final String tradPair = jobExecutionContext.getMergedJobDataMap().getString(ParameterNames.TRADING_PAIR_CURRENCIES.getName());
        final String exchangeAlias = jobExecutionContext.getMergedJobDataMap().getString(ParameterNames.EXCHANGE_ALIAS.getName());

        try {
            //Broker
            final TickerResponse tickerResponse = ExchangeProvider.instance().getAndExecuteExchange(exchangeAlias, tradPair);

            //TODO Evaluate what is best or what should be here bid/ask/last
            double lastd = tickerResponse.getPrice();
            double percentage = jobExecutionContext.getMergedJobDataMap().getDouble(ParameterNames.TOLERANCE_PERCENTAGE.getName());
            double basePrice = jobExecutionContext.getMergedJobDataMap().getDouble(ParameterNames.BASELINE_CURRENCY_VALUE.getName());

            final BigDecimal calculatedNewPrice = BigDecimal.valueOf(basePrice).multiply(BigDecimal.valueOf(1 + percentage));

            TicketTypes type = (TicketTypes) jobExecutionContext.getMergedJobDataMap().get(ParameterNames.TICKER_TYPE.getName());
            switch (type) {
                case DECRESES:
                    if (BigDecimal.valueOf(lastd).compareTo(calculatedNewPrice) < 0) {
                        LOG.info(String.format(DECREASE_SUCCESS_MESSAGE, tradPair.toUpperCase(), percentage, lastd));
                        Toolkit.getDefaultToolkit().beep();
                        EventBusHolder.instance().getEventBus().post(new DecreaseEvent(tradPair, lastd));
                    } else {
                        LOG.debug(String.format(DECREASE_FAIL_MESSAGE, tradPair.toUpperCase(), percentage, basePrice, lastd));
                    }
                    break;
                case INCREASES:
                    if (BigDecimal.valueOf(lastd).compareTo(calculatedNewPrice) > 0) {
                        LOG.info(String.format(INCREASE_SUCCESS_MESSAGE, tradPair.toUpperCase(), percentage, lastd));
                        Toolkit.getDefaultToolkit().beep();
                        EventBusHolder.instance().getEventBus().post(new IncreaseEvent(tradPair.toUpperCase(), lastd));
                    } else {
                        LOG.debug(String.format(INCREASE_FAIL_MESSAGE, tradPair.toUpperCase(), percentage, basePrice, lastd));
                    }
                    break;
            }

        } catch (Exception e) {
            LOG.error(String.format("Failure calling exchange %s with trade pair %s", tradPair.toUpperCase(), exchangeAlias.toUpperCase()));
            LOG.error(e.getMessage(), e);
        }
    }
}
