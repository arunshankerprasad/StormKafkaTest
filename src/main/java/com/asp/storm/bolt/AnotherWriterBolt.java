package com.asp.storm.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class AnotherWriterBolt extends BaseRichBolt {

    /**
     * Auto-generated serial version UID.
     */
    private static final long serialVersionUID = -2397922417422057005L;
    private OutputCollector collector;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }

    @Override
    public void execute(Tuple input) {
        System.out.println(input.toString());
        collector.fail(input);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
        this.collector = collector;
    }
}