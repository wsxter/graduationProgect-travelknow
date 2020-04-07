package cn.wsxter.dao.Impl;

import cn.wsxter.dao.ImageDao;
import cn.wsxter.domain.Image;
import cn.wsxter.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class ImageDaoImpl implements ImageDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void inserImage(Image image) {
        String sql = "insert into image (user_id,img_desc,photo,img_place) VALUES (?,?,?,?)";
        template.update(sql,image.getUser_id(),image.getImg_desc(),image.getPhoto(),image.getImg_place());
    }
}
