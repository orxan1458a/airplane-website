package com.diplomisi.demo.service.Imp;

import com.diplomisi.demo.model.PartOfAirplane;
import com.diplomisi.demo.repository.PartRepository;
import com.diplomisi.demo.service.PartService;
import com.sun.xml.bind.v2.schemagen.episode.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class PartServiceImp implements PartService {
    @Autowired
    PartRepository partRepository;
    @Override
    public void save(String name, MultipartFile image, String brand, String color, BigDecimal price, String country, Date date, Double weight) {
        PartOfAirplane part=new PartOfAirplane();
        part.setPartName(name);
        try {
            part.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        }
        catch (IOException e){e.printStackTrace();}
        part.setBrand(brand);
        part.setColor(color);
        part.setPrice(price);
        part.setCountryOfProduction(country);
        part.setDateOfProduction(date);
        part.setWeight(weight);
        partRepository.save(part);
    }

    @Override
    public List<PartOfAirplane> list() {
        return partRepository.findAll();
    }
}
