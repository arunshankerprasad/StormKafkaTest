package com.asp.storm.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.utils.Utils;

public class PrinterBolt extends BaseRichBolt {

    /**
     * Auto-generated serial version UID.
     */
    private static final long serialVersionUID = -79691469992447756L;

    private OutputCollector collector;

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream(Utils.DEFAULT_STREAM_ID, new Fields("string"));
    }

    @Override
    public void execute(Tuple input) {
        System.out.println(input.toString());
        collector.emit(Utils.DEFAULT_STREAM_ID, input, input.getValues());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {
        this.collector = collector;
    }
}
