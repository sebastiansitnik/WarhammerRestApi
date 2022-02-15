package WebService.Warhammer40k.BattleReport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battle-report")
public class BattleReportController {

    private final BattleReportService service;

    @Autowired
    public BattleReportController(BattleReportService battleReportService) {
        this.service = battleReportService;
    }

    @PostMapping("/add")
    public BattleReport add(BattleReport battleReport){
        return service.create(battleReport);
    }

    @PutMapping("/edit")
    public BattleReport edit(BattleReport battleReport){
        return service.edit(battleReport);
    }

    @DeleteMapping("/delete")
    public BattleReport delete(String id){
        return service.deleteById(id);
    }

    @GetMapping("/read")
    public BattleReport readById(String id){
        return service.readById(id);
    }

    @GetMapping("/readAll")
    public List<BattleReport> readAll(){
        return service.readAll();
    }

}
