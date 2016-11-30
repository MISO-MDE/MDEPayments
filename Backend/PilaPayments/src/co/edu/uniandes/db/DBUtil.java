package co.edu.uniandes.db;
import java.sql.*;
import java.util.Properties;
public class DBUtil {
/**
  Plantilla para hacer la insersion de datos
**/

	 public static void main (String[] args) { 
        try {
            String url = "jdbc:postgresql://localhost:5432/pila?useUnicode=true&characterEncoding=UTF-8";
            Connection conn; //= DriverManager.getConnection(url,"postgres","root");

            Properties props = new Properties();
            props.setProperty("user","postgres");
            props.setProperty("password","root");
            conn = DriverManager.getConnection(url, props);

            Statement st = conn.createStatement();
            st.executeUpdate("insert into userpayments (user_id, email, password, userid, username, rol) values (1, 'pagos@deuna.com', null, 'M00UYKY5EReZlnhzsHeEWG0Mhpn1', 'PagosAdmin', 'Intermediary')");
            st.executeUpdate("insert into userintermediary values (1)");

            //Estos son los datos de los parametros
            //ActividadEconomica
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(1,'8022','Establecimientos de educación media')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(2,'8513','Empresas dedicadas a practicas de odontologia')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(3,'0117','Empresas dedicadas a la producción especializada de frutas, nueces, plantas bebestibles, y especias. Incluye el tostado y beneficio del cacao')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(4,'1541','Empresa dedicada a la elaboracion de productos de molineria, de almidones,productos derivados del almidon y alimentos preparados para animales. Incluye el tostado de semillas y granos')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(5,'1592','Empresa dedicada a la elaboracion de bebidas fermentadas no destiladas')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(6,'1743','Empresa dedicada a la fabricación de cuerdas, cordeles, cables, bramantes y redes')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(7,'2101', 'Empresa dedicada a la fabricación de papel, carton, y productos de papel y carton')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(8,'2322', 'Empresa dedicada a la fabricación de productos derivados del petroleo, fuera de refineria como asfalto')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(9,'1431', 'Extraccion de esmeraldas')");
            st.executeUpdate("insert into ActividadEconomica (id, codigo, descripcion) values(10,'2321','Fabricacion de productos de la refinación del petroleo, elaborados en refineria')");

            //TipoPension
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(1,'01','Vejez')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(2,'02','Sobrevivencia vitalicia riesgo comun')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(3,'03','Sobrevivencia temporal riesgo comun')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(4,'04','Sobrevivencia temporal riesgo comun, Conyugue o compañera(o) menor de 30 años sin hijos')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(5,'05','Sobrevivencia vitalicia por riesgo laboral')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(6,'06','Sobrevivencia temporal por riesgo laboral')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(7,'07','Sobrevivencia temporal por riesgo laboral, Conyugue o compañera(o) menor de 30 años sin hijos')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(8,'08','Invalidez riesgo común')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(9,'09','Invalidez resgo laboral')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(10,'10','Jubilacion')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(11,'11','Jubilacion para compartir')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(12,'12','Sanción')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(13,'13','Convencional')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(14,'14','Convencional para compartir')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(15,'15','Gracia')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(16,'16','Por convenio internacional')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(17,'17','Sentencia Judicial')");
             st.executeUpdate("insert into TipoPension (id, codigo, descripcion) values(18,'18','Conciliaciones')");


            //TipoPensionado
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(1,'01','Pensionado de régimen de prima media. Tope máximo de pensión 25 smlmv')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(2,'02','Pensionado de régimen de prima media. Sin tope máximo de pensión')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(3,'03','Pensionado de régimen de ahorro individual. No aplica tope máximo de pensión')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(4,'04','Pensionado de riesgos laborales. Tope máximo de 25 smlmv')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(5,'05','Pensionado por el empleador. Con tope maximo de pension de 25 smlmv')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(6,'06','Pensionado por el empleador sin tope máximo de pensión')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(7,'07','Pensionado de entidades de los regimenes especial y de excepción, con tope máximo de pensión de 25 smlmv')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(8,'08','Pensionado de entidades de los regimenes especial y de excepción, sin tope máximo de pensión')");
            st.executeUpdate("insert into TipoPensionado (id, codigo, descripcion) values(9,'09','Beneficiario UPC adicional')");


            //TipoPagador
            st.executeUpdate("insert into TipoPagador (id, codigo, descripcion) values(1,'01','Empleador')");
            st.executeUpdate("insert into TipoPagador (id, codigo, descripcion) values(2,'02','Administración de pensiones')");
            st.executeUpdate("insert into TipoPagador (id, codigo, descripcion) values(3,'03','Pagador de pensiones')");
            st.executeUpdate("insert into TipoPagador (id, codigo, descripcion) values(4,'04','Pensiones de entidades de los regimenes especial y de excepción')");


            st.executeUpdate("commit");


            //Este archivo se debe autogenerar con el modelo   de las validaciones
            //validacionpensionadopagador
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(1,1,1)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(2,1,2)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(3,1,3)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(4,2,2)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(5,2,3)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(6,3,2)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(7,4,3)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(8,5,1)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(9,6,1)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(10,7,4)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(11,8,4)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(12,9,1)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(13,9,2)");
            st.executeUpdate("insert into validacionpensionadopagador (id, pensionado_id, pagador_id) values(14,9,3)");

            //validacionpensionpagador,
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(1,1,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(2,1,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(3,2,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(4,2,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(5,2,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(6,2,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(7,3,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(8,3,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(9,3,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(10,3,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(11,4,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(12,4,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(13,4,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(14,4,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(15,5,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(16,6,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(17,7,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(18,8,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(19,8,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(20,8,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(21,8,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(22,9,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(23,10,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(24,10,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(25,10,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(26,11,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(27,11,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(28,12,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(29,13,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(30,13,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(31,14,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(32,14,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(33,15,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(34,16,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(35,17,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(36,17,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(37,17,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(38,17,4)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(39,18,1)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(40,18,2)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(41,18,3)");
            st.executeUpdate("insert into validacionpensionpagador (id, pension_id, pagador_id) values(42,18,4)");

            //validacionpensionpensionado
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(1,1,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(2,1,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(3,1,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(4,2,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(5,2,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(6,2,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(7,2,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(8,2,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(9,2,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(10,2,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(11,3,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(12,3,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(13,3,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(14,3,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(15,3,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(16,3,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(17,3,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(18,4,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(19,4,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(20,4,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(21,4,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(22,4,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(23,4,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(24,4,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(25,4,8)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(26,5,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(27,5,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(28,5,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(29,6,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(30,6,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(31,6,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(32,7,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(33,7,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(34,7,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(35,8,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(36,8,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(37,8,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(38,8,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(39,8,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(40,8,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(41,8,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(42,8,8)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(43,9,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(44,10,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(45,10,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(46,10,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(47,10,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(48,11,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(49,11,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(50,11,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(51,11,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(52,11,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(53,11,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(54,11,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(55,11,8)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(56,12,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(57,12,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(58,13,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(59,13,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(60,14,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(61,14,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(62,14,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(63,14,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(64,15,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(65,15,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(66,16,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(67,17,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(68,17,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(69,17,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(70,17,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(71,17,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(72,17,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(73,17,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(74,17,8)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(75,18,1)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(76,18,2)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(77,18,3)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(78,18,4)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(79,18,5)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(80,18,6)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(81,18,7)");
            st.executeUpdate("insert into validacionpensionpensionado (id, pension_id, pensionado_id) values(82,18,8)");

	        System.out.println("Insersion finalizada");
	        st.executeUpdate("commit");

	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	            System.err.println(e.getCause()); 
	        } 
	  
	    }

}

