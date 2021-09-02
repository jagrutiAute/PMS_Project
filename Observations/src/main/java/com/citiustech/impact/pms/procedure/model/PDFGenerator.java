package com.citiustech.impact.pms.procedure.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {
	private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

	public static ByteArrayInputStream medicationPDFReport(List<PatientProcedure> medications) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();

			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph para = new Paragraph("Patient Procedure", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(4);
			float[] columnWidths = new float[] { 10f, 20f, 10f, 10f };
			table.setWidths(columnWidths);
			// Add PDF Table Header ->
//			Stream.of("Appl_No", "Active_Ingredient", "Date", "Drug_Name", "Form", "Phy_Id", "Pat_Id", "Reference_Drug",
//					"Reference Standard", "Strength").forEach(headerTitle -> {
			Stream.of("procedure_code", "procedure_desc", "patient id", "isProcedureDpricated").forEach(headerTitle -> {
				PdfPCell header = new PdfPCell();
				Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(2);
				header.setPhrase(new Phrase(headerTitle, headFont));
				table.addCell(header);
			});

			for (PatientProcedure med : medications) {
				PdfPCell idCell = new PdfPCell(new Phrase(med.getProcedureCode()));
				idCell.setPaddingLeft(4);
				idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(idCell);

				PdfPCell actIngCell = new PdfPCell(new Phrase(med.getProcedureDesc()));
				actIngCell.setPaddingLeft(4);
				actIngCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				actIngCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(actIngCell);

				PdfPCell drugNameCell = new PdfPCell(new Phrase(String.valueOf(med.getPid())));
				drugNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				drugNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				drugNameCell.setPaddingRight(4);
				table.addCell(drugNameCell);

				PdfPCell formCell = new PdfPCell(new Phrase(med.getIsProcedureDpricated()));
				formCell.setPaddingLeft(4);
				formCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				formCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(formCell);

				/*
				 * PdfPCell phyIdCell = new PdfPCell(new Phrase(med.getPhyid()));
				 * phyIdCell.setPaddingLeft(4);
				 * phyIdCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * phyIdCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				 * table.addCell(phyIdCell);
				 */
			}
			document.add(table);

			document.close();
		} catch (DocumentException e) {
			logger.error(e.toString());
		}

		return new ByteArrayInputStream(out.toByteArray());
	}
}
