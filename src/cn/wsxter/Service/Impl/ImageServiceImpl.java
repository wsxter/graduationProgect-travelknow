package cn.wsxter.Service.Impl;

import cn.wsxter.dao.ImageDao;
import cn.wsxter.dao.Impl.ImageDaoImpl;
import cn.wsxter.domain.Image;
import cn.wsxter.Service.ImageService;

public class ImageServiceImpl implements ImageService {
    ImageDao imageDao = new ImageDaoImpl();
    @Override
    public void instrImage(Image image) {
        imageDao.inserImage(image);
    }
}
