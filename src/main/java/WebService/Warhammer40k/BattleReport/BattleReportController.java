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

    @CrossOrigin
    @PostMapping("/add")
    public BattleReport add(@RequestBody BattleReport battleReport){
        return service.create(battleReport);
    }

    @CrossOrigin
    @PutMapping("/edit")
    public BattleReport edit(@RequestBody BattleReport battleReport){
        return service.edit(battleReport);
    }

    @CrossOrigin
    @DeleteMapping("/delete")
    public BattleReport delete(@RequestParam String id){
        return service.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/read")
    public BattleReport readById(@RequestParam String id){
        return service.readById(id);
    }

    @CrossOrigin
    @GetMapping("/readAll")
    public List<BattleReport> readAll(){
        return service.readAll();
    }

}
