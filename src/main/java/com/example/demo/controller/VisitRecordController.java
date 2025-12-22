@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {
    @PostMapping("/")
    public String recordVisit() { return "Visit Recorded"; }
    
    @GetMapping("/")
    public List<Object> listAll() { return Collections.emptyList(); }
}