package com.imooc.passbook.passbook.service.impl;

import com.imooc.passbook.passbook.constant.Constants;
import com.imooc.passbook.passbook.log.LogGenerator;
import com.imooc.passbook.passbook.service.IHBasePassService;
import com.imooc.passbook.passbook.utils.RowKeyGenUtil;
import com.imooc.passbook.passbook.vo.PassTemplate;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.tomcat.util.bcel.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Pass HBase 服务</h1>
 * Created by hanbian
 */
@Service
public class HBasePassServiceImpl  implements IHBasePassService {
    private static Logger log = LoggerFactory.getLogger(LogGenerator.class);
    private  final HbaseTemplate  hbaseTemplate;

    public HBasePassServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    /**
     * <h2>将 PassTemplate 写入HBase</h2>
     *
     * @param passTemplate {@link PassTemplate}
     * @return true/false
     */
    @Override
    public boolean dropPassTemplateToHBase(PassTemplate passTemplate) {
        if(null == passTemplate){
            return false;
        }
        String rowKey = RowKeyGenUtil.genPassTemplateRowKey(passTemplate);
        try{
            if (hbaseTemplate.getConnection().getTable(TableName.valueOf(Constants.PassTemplateTable.TABLE_NAME)).exists(new Get(Bytes.toBytes(rowKey)))){
                log.warn("RowKey {} is already exist!",rowKey);
                return false;
            }
        }catch (Exception ex){
            log.error("DropPassTemplateToHBase Error: {}",ex.getMessage());
            return false;
        }

       Put put = new Put(Bytes.toBytes(rowKey));
        put.addColumn(
                Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.ID),
                Bytes.toBytes(passTemplate.getId())
        );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.TITLE),
                Bytes.toBytes(passTemplate.getTitle())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.SUMMARY),
                Bytes.toBytes(passTemplate.getSummary())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.DESC),
                Bytes.toBytes(passTemplate.getDesc())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.HAS_TOKEN),
                Bytes.toBytes(passTemplate.getHasToken())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMILY_B),
                Bytes.toBytes(Constants.PassTemplateTable.BACKGROUND),
                Bytes.toBytes(passTemplate.getBackground())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMLIY_C),
                Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                Bytes.toBytes(passTemplate.getLimit())
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMLIY_C),
                Bytes.toBytes(Constants.PassTemplateTable.START),
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getStart()))
                );
        put.addColumn(Bytes.toBytes(Constants.PassTemplateTable.FAMLIY_C),
                Bytes.toBytes(Constants.PassTemplateTable.END),
                Bytes.toBytes(DateFormatUtils.ISO_DATE_FORMAT.format(passTemplate.getEnd()))
                );
        hbaseTemplate.saveOrUpdate(Constants.PassTemplateTable.TABLE_NAME,put);
        return true;
    }
}
