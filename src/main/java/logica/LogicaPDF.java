package logica;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LogicaPDF {

    //imprime las asignaciones en el pdf
    public static void imprimirModulos(PdfPTable table, String idProfesor) throws SQLException {

        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONSEGUIR_ASIGNACIONES_POR_PROFESOR());
        st.setString(1, idProfesor);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            table.addCell(rs.getString(1));
            table.addCell(rs.getString(2));
            table.addCell(rs.getString(8));
            table.addCell(rs.getString(6));
            table.addCell(rs.getString(5) + " " + rs.getString(7));
            table.addCell(rs.getString(3));

        }
    }
    
    //consulta si existen asignaciones
    public static int consultarSiTiene(int idProfesor) throws SQLException {
        PreparedStatement st = logica.LogicaConexion.getConexion()
                .prepareStatement(sql.Sentencias.getCONTAR_ASIGNACIONES_PROFESOR());
        st.setString(1, String.valueOf(idProfesor));
        ResultSet rs = st.executeQuery();

        rs.next();
        return rs.getInt(1);
    }

    //imprime la cabecera
    public static void imprimirCabeceraTabla(PdfPTable table) {
        table.addCell("Código");
        table.addCell("Módulo");
        table.addCell("Ciclo");
        table.addCell("Nivel");
        table.addCell("Curso y turno");
        table.addCell("Horas reales");
    }

    public static void imprimirCabeceraDocumento(Document docu) throws BadElementException, IOException, DocumentException {
        Image img = Image.getInstance("src\\main\\resources\\pdf\\cabecera.png");
        img.scalePercent(70);
        img.setAlignment(Image.ALIGN_CENTER);
        Paragraph p = new Paragraph();
        p.setSpacingBefore(50);
        docu.add(p);
        docu.add(img);

        //img = Image.getInstance("src\\main\\resources\\pdf\\titulo.png");
        //img.setAlignment(Image.ALIGN_CENTER);
        //document.add(img);
        docu.add(new Chunk("\n"));
        docu.add(new Chunk("\n"));
    }

    public static void dialogoGuardarPdf() {
        
    }
    
}
