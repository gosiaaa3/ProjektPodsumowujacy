package my.service;

import my.model.Link;
import my.model.User;
import my.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-03-15.
 */
@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> fetchLinks(){ //pobieranie skads
        List<Link> links= new ArrayList<Link>();

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

        Iterable <Link> iterable = linkRepository.findAll();
        iterable.forEach(links::add);

//        return links.stream().filter(e->principal !=null &&e.getId() !=4).collect(Collectors.toList()); a w argumencie Prin
        return links;
    }
}
