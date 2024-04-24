package com.fpt.confluence.plans.approval.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fpt.confluence.plans.approval.models.SimpleRestResponse;
import com.fpt.confluence.plans.approval.models.Content;

public class ContentDAO {
    
    private final String URL = "jdbc:mysql://13.214.187.228:3306/confludb";
    private final String USERNAME = "root";
    private final String PASSWORD = "PassWord@123";
    
    // Hàm get để lấy dữ liệu từ bảng content
    public Content getContentById(long contentId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Content content = null;
        
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // Chuẩn bị câu truy vấn SQL
            String sql = "SELECT * FROM CONTENT WHERE CONTENTID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, contentId);
            
            // Thực thi câu truy vấn
            rs = stmt.executeQuery();
            
            // Xử lý kết quả trả về
            if (rs.next()) {
                // Lấy các trường dữ liệu từ ResultSet và tạo đối tượng Content tương ứng
                content = new Content();
                content.setContentId(rs.getLong("CONTENTID"));
                content.setContentType(rs.getString("CONTENTTYPE"));
                content.setTitle(rs.getString("TITLE"));
                // Tiếp tục lấy các trường dữ liệu khác nếu cần thiết
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng ResultSet, PreparedStatement và Connection để giải phóng tài nguyên
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return content;
    }
}   