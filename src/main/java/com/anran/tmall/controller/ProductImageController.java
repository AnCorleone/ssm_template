package com.anran.tmall.controller;

import com.anran.tmall.pojo.Product;
import com.anran.tmall.pojo.ProductImage;
import com.anran.tmall.service.ProductImageService;
import com.anran.tmall.service.ProductService;
import com.anran.tmall.util.ImageUtil;
import com.anran.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Anakin (Administrator)
 * @date 2018/8/18
 * @time 14:45
 * 描述    ${TODO}
 */
@Controller
@RequestMapping("")
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @Autowired
    ProductService productService;

    @RequestMapping("admin_productImage_add")
    public String add(ProductImage pi, HttpSession session, UploadedImageFile uploadedImageFile) {
        productImageService.add(pi);
        String fileName = pi.getId() + ".jpg";
        String imageFolder;
        String imageFolderSmall = null;
        String imageFolderMiddle = null;
        if (ProductImageService.type_single.equals(pi.getType())) {
            imageFolder = session.getServletContext().getRealPath("/img/productSingle");

            imageFolderSmall = session.getServletContext().getRealPath("/img/productSingle_small");
            imageFolderMiddle = session.getServletContext().getRealPath("/img/productSingle_middle");
        } else {
            imageFolder = session.getServletContext().getRealPath("/img/productDetail");
        }
        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();

        try {
            uploadedImageFile.getImage().transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);
            if (ProductImageService.type_single.equals(pi.getType())) {
                File f_small = new File(imageFolderSmall, fileName);
                File f_middle = new File(imageFolderMiddle, fileName);
                ImageUtil.resizeImage(f, 56, 56, f_small);
                ImageUtil.resizeImage(f, 217, 270, f_middle);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:admin_productImage_list?pid=" + pi.getPid();
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(int id,HttpSession session) {
        ProductImage pi = productImageService.get(id);
        //删除图片
        String fileName = pi.getPid()+".jpg" ;
        String imageFolder;
        String imageFolderSmall = null;
        String imageFolderMiddle = null;
        if (ProductImageService.type_single.equals(pi.getType())) {
            imageFolder = session.getServletContext().getRealPath("/img/productSingle");
            imageFolderSmall = session.getServletContext().getRealPath("/img/productSingle_small");
            imageFolderMiddle = session.getServletContext().getRealPath("/img/productSingle_middle");

            File imageFile = new File(imageFolder,fileName);
            File f_small = new File(imageFolderSmall,fileName);
            File f_middle = new File(imageFolderMiddle,fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();
        } else {
            imageFolder = session.getServletContext().getRealPath("/img/productDetail");
            File imageFile = new File(imageFolder,fileName);
            imageFile.delete();
        }

        productImageService.delete(id);
        return "redirect:admin_productImage_list?pid=" + pi.getPid();
    }

    @RequestMapping("admin_productImage_list")
    public String list(int pid, Model model) {
        Product product = productService.get(pid);
        List<ProductImage> pisDetail = productImageService.list(pid, ProductImageService.type_detail);
        List<ProductImage> pisSingle = productImageService.list(pid, ProductImageService.type_single);
        model.addAttribute("p", product);
        model.addAttribute("pisDetail", pisDetail);
        model.addAttribute("pisSingle", pisSingle);

        return "admin/listProductImage";
    }

}
