package com.magicWandInfo.magicWandAPI.Controller;

import com.magicWandInfo.magicWandAPI.Entity.MagicWand;
import com.magicWandInfo.magicWandAPI.Repository.MagicWandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8072/"})
@RestController
@RequestMapping("/api")
public class MagicWandController {

    @Autowired
    private MagicWandRepository magicWandRepository;

    private MagicWand mw = new MagicWand();

    public MagicWandController(MagicWandRepository magicWandRepository){
        this.magicWandRepository = magicWandRepository;

    }
    @GetMapping("/magicWandList")

    public List<MagicWand> getMagicWandList(){
        return magicWandRepository.findAll();
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody MagicWand magicWand){
        MagicWand mw = new MagicWand();
        mw.setMagicWandName(magicWand.getMagicWandName());
        System.out.println("magicWand = " + mw.getMagicWandName() + " = "+magicWand.getMagicWandName());
        mw.setDescriptionWand(magicWand.getDescriptionWand());
        mw.setAgeLimit(magicWand.getAgeLimit());
        mw.setStockWand(magicWand.getStockWand());
        magicWandRepository.save(mw);
    }

    @DeleteMapping("delete/{orderId}")
    public void deleteOrder(@PathVariable(value="wizardID")long id){
        magicWandRepository.deleteById(id);
    }

    @PutMapping("update/{orderId}")
    public void updateOrder(@RequestBody MagicWand magicWand){
        magicWandRepository.save(magicWand);
    }


}
