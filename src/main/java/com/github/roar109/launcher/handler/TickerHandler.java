package com.github.roar109.launcher.handler;

import com.github.roar109.launcher.data.dto.Ticker;
import com.github.roar109.launcher.factory.TicketTriggerFactory;
import com.github.roar109.launcher.job.CurrencyChangeTicketJob;
import com.github.roar109.launcher.types.ParameterNames;
import com.github.roar109.launcher.types.TicketTypes;
import org.quartz.*;

public class TickerHandler {

    private Ticker[] tickers;
    private Scheduler scheduler;

    public TickerHandler(Ticker[] tickers, Scheduler scheduler) {
        this.tickers = tickers;
        this.scheduler = scheduler;
    }

    public void executeAndSchedule() throws Exception {
        for (Ticker ticker : tickers) {
            addJobTicker(ticker);
        }
    }

    private void addJobTicker(Ticker ticker) throws Exception {
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(ParameterNames.TICKER_TYPE.getName(), ticker.getIncrease_or_decrease() == 1 ?
                TicketTypes.INCREASES : TicketTypes.DECRESES);
        dataMap.put(ParameterNames.BASELINE_CURRENCY_VALUE.getName(), ticker.getBaseline_value());
        dataMap.put(ParameterNames.TRADING_PAIR_CURRENCIES.getName(), ticker.getPair());
        dataMap.put(ParameterNames.TOLERANCE_PERCENTAGE.getName(), ticker.getPorcentage());
        dataMap.put(ParameterNames.EXCHANGE_ALIAS.getName(), ticker.getExchange_alias());

        JobDetail job = JobBuilder.newJob(CurrencyChangeTicketJob.class)
                .withIdentity(ticker.getPair() + "-JobTicker", "tickers")
                .setJobData(dataMap)
                .build();

        //TODO Probably will need to be described in the ticker json
        Trigger trigger = TicketTriggerFactory.instance().build5MinTrigger();

        scheduler.scheduleJob(job, trigger);
    }
}
