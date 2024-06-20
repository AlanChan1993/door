package com.twh.door.utils.wmsPh_utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.twh.door.utils.wmsPh_utils.pojo.LabelValue;
import org.springframework.util.ObjectUtils;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class ExcelUtil {
    public static String EXCEL_STATUS = "status";

    /**
     * @description 多线程导出动态头
     * @author hcb
     * @date 2023/1/6
     */
    public static void exportDate(OutputStream out, List<List<String>> head, LinkedBlockingQueue<List<List<String>>> data,
                                  String sheetName, Integer slipSheetCount, Map<String, Boolean> statusMap, ExcelTypeEnum excelType) {
        try (ExcelWriter excelWriter = EasyExcel.write(out).excelType(excelType).build()) {
            int sheetCount = 0;
            int totalCount = 0;
            WriteSheet writeSheet = EasyExcel.writerSheet(sheetCount, sheetName + sheetCount).head(head).build();
            while (statusMap.get(EXCEL_STATUS) || !data.isEmpty()) {
                List<List<String>> poll = data.poll();
                if (!ObjectUtils.isEmpty(poll)) {
                    if (excelType.equals(ExcelTypeEnum.XLSX)) {
                        int size = poll.size();
                        if (slipSheetCount - totalCount - size >= 0) {
                            excelWriter.write(poll, writeSheet);
                            totalCount += size;
                        } else {
                            int i = slipSheetCount - totalCount;
                            if (i > 0) {
                                List<List<String>> orig = poll.subList(0, i);
                                excelWriter.write(orig, writeSheet);
                                poll = poll.subList(i, size);
                            }
                            sheetCount++;
                            writeSheet = EasyExcel.writerSheet(sheetCount, sheetName + sheetCount).head(head).build();
                            totalCount = poll.size();
                            excelWriter.write(poll, writeSheet);
                        }
                    } else {
                        excelWriter.write(poll, writeSheet);
                    }

                }
            }
        }
    }

    public static List<List<String>> mapToList(List<LabelValue<String, String>> header, List<?> records) {
        List<List<String>> result = new ArrayList<>();
        records.forEach(v -> {
            Map<String, Object> map = JsonUtils.beanToJson(v);
            List<String> row = new ArrayList<>();
            header.forEach(h -> {
                String title = h.getVal();
                String rowItem = ObjectUtils.nullSafeToString(map.get(title));
                row.add(rowItem);
            });
            result.add(row);
        });
        return result;
    }

    /**
     * @description 动态header头
     * @author hcb
     * @date 2023/1/6
     */
    public static List<List<String>> getEasyExcelHeaders(List<LabelValue<String, String>> excelHeaders) {
        List<List<String>> list = new ArrayList<List<String>>();
        excelHeaders.forEach(v -> {
            List<String> head = new ArrayList<>();
            head.add(v.getLabel());
            list.add(head);
        });
        return list;
    }


}
