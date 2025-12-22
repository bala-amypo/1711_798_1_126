@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {
    @Autowired
    private TierUpgradeRuleRepository repository;

    @PostMapping("/")
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @GetMapping("/")
    public List<TierUpgradeRule> getAll() {
        return repository.findAll();
    }
}