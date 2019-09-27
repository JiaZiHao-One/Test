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
	File file1 = new File("E:\\File\\小说.txt");//读取文件
	File file2 = new File("E:\\File\\白山茶.mp3");//读取电影
	InputStream in = new FileInputStream(file1);//转换字节流
	Reader read = new InputStreamReader(in,"UTF-8");//推荐使用转换流，可以设置编码
	ps.setCharacterStream(2, read,file1.length());
	InputStream is = new FileInputStream(file2);//转换字节流
	ps.setBinaryStream(3, is,file2.length());
	if(ps.executeUpdate()>0) {
		System.out.println("操作成功");
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
	System.out.println("操作失败");
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
    File file3 = new File("小说.txt");
    File file4 = new File("白山茶.mp3");
	Reader readr = rs.getCharacterStream("ftext");//读取小说字符流
	InputStream ins = rs.getBinaryStream("fmusic");//读取音乐字节流
	OutputStream os = new FileOutputStream(file4);//输出到file4
	Writer out  = new FileWriter(file3);//输出到file3
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
	System.out.println("操作成功");
	return true;
	}
	}catch(Exception e) {
		throw e;
	}finally {
		conn.close();
	}
	System.out.println("操作失败");
	return false;
}
public static void main(String args[]) throws Exception{
	FileDAO d = new FileDAO();
  //d.addFile();
	d.getFile();
}
//JDBC处理大文本数据Clob(Mysql:Text)及二进制Blob类型
//Clob:大文本数据  通过字符流 Writer Reader
//存:pstmt.setCharacterStream(2, read,file1.length());
//取:Reader reader=getCharacterStream(“数据库字段”);
//Blob:二进制数据   通过字节流 InputStream OutputStream
//存取与Clob基本一致:setBinaryStream(xxx) getetBinaryStream(xxx)
}
