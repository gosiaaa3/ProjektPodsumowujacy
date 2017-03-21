package my.service;

import my.model.Image;
import my.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public Set<Image> fetchImages(){ //pobieranie skads
        //List<Image> images= new ArrayList<Image>();
        Set<Image> images = new HashSet<Image>();

//        Link link1 = new Link();
//        link1.setLink("/home");
//        link1.setName("About");
//        Link link2 = new Link();
//        link2.setLink("/home");
//        link2.setName("Service");
//        Link link3 = new Link();
//        link3.setLink("/home");
//        link3.setName("Contact");
//        links.add(link1);
//        links.add(link2);
//        links.add(link3);

        Iterable <Image> iterable = imageRepository.findAll();
        iterable.forEach(images::add);
        return images;
    }
}
