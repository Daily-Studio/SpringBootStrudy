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

//    @Transactional(readOnly = true)
//    public List<Child> getAllChild(){
//        List<Child> children = childRepository.findAll();
//        return children;
//    }
//
//    @Transactional
//    public void saveParentForManyToOne() {
//        Parent parent1 = new Parent();
//        parent1.setName("부모님1");
//        Parent parent2 = new Parent();
//        parent2.setName("부모님2");
//
//        parentRepository.save(parent1);
//        parentRepository.save(parent2);
//    }
//
//    @Transactional
//    public void saveChildForManyToOne() {
//        Parent parent1 = parentRepository.getOne(1L);
//
//        Child child1 = new Child();
//        Child child2 = new Child();
//
//        child1.setName("자식1");
//        child1.setParent(parent1);
//
//        child2.setName("자식2");
//        child2.setParent(parent1);
//
//        childRepository.save(child1);
//        childRepository.save(child2);
//    }


    @Transactional(readOnly = true)
    public Parent getParent(Long id) {
        Parent parent = parentRepository.getOne(id);
        return parent;
    }

    @Transactional
    public void saveParentForOneToMany() {
        Parent parent3 = new Parent();
        parent3.setName("부모님3");

        Child child1 = new Child();
        Child child2 = new Child();

        child1.setName("자식3");
        child2.setName("자식4");


        parent3.getChildren().add(child1);
        parent3.getChildren().add(child2);

        parentRepository.save(parent3);
    }


}
