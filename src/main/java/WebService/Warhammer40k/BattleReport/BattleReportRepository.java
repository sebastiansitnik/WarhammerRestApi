package WebService.Warhammer40k.BattleReport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleReportRepository extends JpaRepository <BattleReport, String> {


}
