package uploadfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FileDAO {
private Connection conn = null;
private PreparedStatement ps=null;
private ResultSet rs =null;
public Connection getConn() throws Exception{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/uploadfile?useUnicode=true&characterEncoding=UTF-8&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Hongkong", "root", "mysqladmin");
	}catch(Exception e) {
		throw e;
	}
	return conn;
}
public Boolean addFile() throws Exception{
	conn=this.getConn();
	String sql ="insert into fileUp(fid,ftext,fmusic)values(?,?,?)";
	try {
	ps=conn.prepareStatement(sql);
	ps.setInt(1,1);
	File file1 = new File("E:\\File\\С˵.txt");//��ȡ�ļ�
	File file2 = new File("E:\\File\\��ɽ��.mp3");//��ȡ��Ӱ
	InputStream in = new FileInputStream(file1);//ת���ֽ���
	Reader read = new InputStreamReader(in,"UTF-8");//�Ƽ�ʹ��ת�������������ñ���
	ps.setCharacterStream(2, read,file1.length());
	InputStream is = new FileInputStream(file2);//ת���ֽ���
	ps.setBinaryStream(3, is,file2.length());
	if(ps.executeUpdate()>0) {
		System.out.println("�����ɹ�");
		return true;
	}
	read.close();
	is.close();
	in.close();
	}catch(Exception e) {
		throw e;
	}finally {
		conn.close();
	}
	System.out.println("����ʧ��");
	    return false;
}
public Boolean getFile() throws Exception{
	conn=this.getConn();
	String sql = "select * from fileup where fid like ?";
	try {
	ps=conn.prepareStatement(sql);
	ps.setInt(1, 1);
	rs =ps.executeQuery();
	if(rs.next()) {
    File file3 = new File("С˵.txt");
    File file4 = new File("��ɽ��.mp3");
	Reader readr = rs.getCharacterStream("ftext");//��ȡС˵�ַ���
	InputStream ins = rs.getBinaryStream("fmusic");//��ȡ�����ֽ���
	OutputStream os = new FileOutputStream(file4);//�����file4
	Writer out  = new FileWriter(file3);//�����file3
	char ch[] = new char[1024];
	byte  bt[] = new byte[1024];
	int len =0;
	while((len=readr.read(ch))!=-1) {
		out.write(ch, 0, len);
	}
	while((len=ins.read(bt))!=-1) {
		os.write(bt,0,len);
	}
	readr.close();
	out.close();
	System.out.println("�����ɹ�");
	return true;
	}
	}catch(Exception e) {
		throw e;
	}finally {
		conn.close();
	}
	System.out.println("����ʧ��");
	return false;
}
public static void main(String args[]) throws Exception{
	FileDAO d = new FileDAO();
  //d.addFile();
	d.getFile();
}
//JDBC������ı�����Clob(Mysql:Text)��������Blob����
//Clob:���ı�����  ͨ���ַ��� Writer Reader
//��:pstmt.setCharacterStream(2, read,file1.length());
//ȡ:Reader reader=getCharacterStream(�����ݿ��ֶΡ�);
//Blob:����������   ͨ���ֽ��� InputStream OutputStream
//��ȡ��Clob����һ��:setBinaryStream(xxx) getetBinaryStream(xxx)
}
