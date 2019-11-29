package com.example.demo.sample.export;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.chen.entity.OrdVehicle;
import com.example.demo.chen.service.IOrdVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * @author chendesheng
 * @create 2019/9/30 9:56
 */
@RestController
@RequestMapping(value = "/excel")
@Slf4j
public class ExcelController {


    private static final Integer MAX_SHEET=20;


    @Autowired
    IOrdVehicleService ordVehicleService;


    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet){

        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);


        cell = row.createCell(1);
        cell.setCellValue("dispatch_order_id");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("tId");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("VIN");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("plate_number");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("vehicle_model");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("vehicle_series");
        cell.setCellStyle(style);

        cell = row.createCell(7);
        cell.setCellValue("description");
        cell.setCellStyle(style);

        cell = row.createCell(8);
        cell.setCellValue("create_user");
        cell.setCellStyle(style);



        cell = row.createCell(9);
        cell.setCellValue("create_date");
        cell.setCellStyle(style);


    }

    @GetMapping(value = "/getOrdVehicles")
    public String getOrdVehicles(HttpServletResponse response) throws Exception{

        HSSFWorkbook workbook = new HSSFWorkbook();
        LocalDateTime start =LocalDateTime.now();
        log.info("start:{}",start);
        //设置日期格式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        for (int i=0;i<MAX_SHEET;i++){

            HSSFSheet sheet = workbook.createSheet("sheet"+i);
            createTitle(workbook,sheet);
            IPage<OrdVehicle> page = new Page<>(i,10000);
            IPage<OrdVehicle> ordVehicleList = ordVehicleService.page(page);
            //新增数据行，并且设置单元格数据
            int rowNum=1;
            for(OrdVehicle ordVehicle:ordVehicleList.getRecords()){
                HSSFRow row = sheet.createRow(rowNum);
                row.createCell(0).setCellValue(ordVehicle.getId());
                row.createCell(1).setCellValue(ordVehicle.getDispatchOrderId());
                row.createCell(2).setCellValue(ordVehicle.getTId());
                row.createCell(3).setCellValue(ordVehicle.getVin());
                row.createCell(4).setCellValue(ordVehicle.getPlateNumber());
                row.createCell(5).setCellValue(ordVehicle.getVehicleModel());
                row.createCell(6).setCellValue(ordVehicle.getVehicleSeries());
                row.createCell(7).setCellValue(ordVehicle.getDescription());
                row.createCell(8).setCellValue(ordVehicle.getCreateUser());
                row.createCell(9).setCellValue(ordVehicle.getCreateDate().toString());

                HSSFCell cell = row.createCell(10);
                cell.setCellStyle(style);
                rowNum++;
            }

        }

        String fileName = "导出excel例子6.xls";
        //生成excel文件
        buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);

        log.info("end:{}",LocalDateTime.now());


        return "download excel";
    }


    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }


    protected void buildExcelDocument(String filename,HSSFWorkbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }



}
