package org.dailystudio.springbootstudy.service;

import lombok.RequiredArgsConstructor;
import org.dailystudio.springbootstudy.domain.Child;
import org.dailystudio.springbootstudy.domain.Parent;
import org.dailystudio.springbootstudy.repository.ChildRepository;
import org.dailystudio.springbootstudy.repository.ParentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public void saveParent(){
        Parent parent = new Parent();
        parent.setName("부모님");
        parentRepository.save(parent);
    }

    public void saveChild(){
        Child child1 = new Child();
        Child child2 = new Child();

        child1.setName("자식");
        child2.setName("자식");

        Parent parent = parentRepository.findAll().get(0);

        child1.setParent(parent);
        child2.setParent(parent);

        childRepository.save(child1);
        childRepository.save(child2);
    }

    public Parent getParent(){
        Parent parent = parentRepository.findAll().get(0);
        System.out.println("parent id = "+parent.getId());
        System.out.println("parent name = "+parent.getName());

        System.out.println("parent has "+parent.getChildren().size()+" children.");
        return parent;
    }

}
