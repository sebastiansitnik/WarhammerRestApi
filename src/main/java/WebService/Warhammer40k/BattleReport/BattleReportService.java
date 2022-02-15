package WebService.Warhammer40k.BattleReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BattleReportService {

    private final BattleReportRepository repository;

    @Autowired
    public BattleReportService(BattleReportRepository battleReportRepository) {
        this.repository = battleReportRepository;
    }

    public BattleReport create (BattleReport battleReport){

        return repository.save(battleReport);

    }

    public BattleReport readById(String id){

        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public BattleReport edit (BattleReport battleReport){

        if (repository.existsById(String.valueOf(battleReport.getId()))){
            return repository.save(battleReport);
        } else {
            throw new NoSuchElementException();
        }
    }

    public BattleReport deleteById(String id){

        BattleReport battleReportToDelete = repository.findById(id).orElseThrow(NoSuchElementException::new);

        repository.deleteById(id);

        return battleReportToDelete;
    }

    public List<BattleReport> readAll(){
        return repository.findAll();
    }
}
