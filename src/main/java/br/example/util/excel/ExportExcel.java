package br.example.util.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import br.example.domain.Product;

/**
 * 
 * @author Pablo
 *
 */
public class ExportExcel {
	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Produtos");

		sheet.setDefaultColumnWidth(15);
		sheet.setDefaultRowHeight((short) 400);

		// Carregando os produtos
		List<Product> products = getProducts();

		int rownum = 0;
		int cellnum = 0;
		Cell cell;
		Row row;

		// Configurando estilos de células (Cores, alinhamento, formatação, etc..)
		HSSFDataFormat numberFormat = workbook.createDataFormat();

		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		CellStyle textStyle = workbook.createCellStyle();
		textStyle.setAlignment(HorizontalAlignment.CENTER);
		textStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		CellStyle numberStyle = workbook.createCellStyle();
		numberStyle.setDataFormat(numberFormat.getFormat("#,##0.00"));
		numberStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		// Configurando Header
		row = sheet.createRow(rownum++);
		cell = row.createCell(cellnum++);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("Code");

		cell = row.createCell(cellnum++);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("Name");

		cell = row.createCell(cellnum++);
		cell.setCellStyle(headerStyle);
		cell.setCellValue("Price");

		// Adicionando os dados dos produtos na planilha
		for (Product product : products) {
			row = sheet.createRow(rownum++);
			cellnum = 0;

			cell = row.createCell(cellnum++);
			cell.setCellStyle(textStyle);
			cell.setCellValue(product.getId());

			cell = row.createCell(cellnum++);
			cell.setCellStyle(textStyle);
			cell.setCellValue(product.getName());

			cell = row.createCell(cellnum++);
			cell.setCellStyle(numberStyle);
			cell.setCellValue(product.getPrice());
		}

		try {

			// Escrevendo o arquivo em disco
			FileOutputStream out = new FileOutputStream(new File("C:\\JAVA_FILES\\EXCEL\\exemplo.xls"));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("Success!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Simulando uma listagem de produtos
	private static List<Product> getProducts() {
		List<Product> products = new ArrayList<>();

		products.add(new Product(1L, "Produto 1", 200.5d));
		products.add(new Product(2l, "Produto 2", 1050.5d));
		products.add(new Product(3l, "Produto 3", 50d));
		products.add(new Product(4l, "Produto 4", 200d));
		products.add(new Product(5l, "Produto 5", 450d));
		products.add(new Product(6l, "Produto 6", 150.5d));
		products.add(new Product(7l, "Produto 7", 300.99d));
		products.add(new Product(8l, "Produto 8", 1000d));
		products.add(new Product(9l, "Produto 9", 350d));
		products.add(new Product(10l, "Produto 10", 200d));

		return products;
	}
}
