package ir.miri.shop.app.services.site;

import ir.miri.shop.app.entities.site.Content;
import ir.miri.shop.app.entities.site.Nav;
import ir.miri.shop.app.repositories.site.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    @Autowired
    private ContentRepository repository;

    public Content findByKey(String key) {
        return repository.findFirstByKey(key);
    }

    public Content getById(long id) {
        Optional<Content> data = repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public Content add(Content data) {
        return repository.save(data);
    }

    public Content update(Content data) throws Exception {
        Content oldData = getById(data.getId());
        if (oldData == null)
            throw new Exception("d");
        oldData.setValue(data.getValue());
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws Exception {
        Content oldData = getById(id);
        if (oldData == null)
            throw new Exception("sd");
        repository.deleteById(id);
        return true;
    }
    public List<Content> getAll(Integer pageSize, Integer pageNumber) {
        Pageable page= PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<Content> all = repository.findAll(page);
        return all.toList();
    }
    public long getAllCount() {
        return repository.count();
    }
}
