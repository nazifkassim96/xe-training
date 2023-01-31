package com.magicWandInfo.magicWandAPI.Controller;

import com.magicWandInfo.magicWandAPI.Entity.MagicWand;
import com.magicWandInfo.magicWandAPI.Exception.MagicWandException;
import com.magicWandInfo.magicWandAPI.Repository.MagicWandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8072/"})
@RestController
@RequestMapping("/api")
@Component
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
    public void addMagicWand(@RequestBody MagicWand magicWand) throws MagicWandException {
        magicWandRepository.save(magicWand);
    }

    @DeleteMapping("/delete/{magicWand_id}")
    public void deleteMagicWand(@PathVariable(value="magicWand_id") Long magicWand_id) throws MagicWandException{
//        magicWandRepository.deleteById(magicWand_id);

        if(magicWandRepository.existsById(magicWand_id)){
            magicWandRepository.deleteById(magicWand_id);
        }else{
            throw new MagicWandException(MagicWandException.INVALID_ID);
        }
    }

    @PutMapping("/update")
    public void updateMagicWand(@RequestBody MagicWand magicWand) throws MagicWandException{
//        magicWandRepository.save(magicWand);

        if(magicWandRepository.existsById(magicWand.getMagicWand_id())){
            magicWandRepository.save(magicWand);
        }else{
            throw new MagicWandException(MagicWandException.INVALID_ID);
        }
    }


}
