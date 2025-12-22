@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {
    @Autowired
    private TierUpgradeEngineService service;

    @PostMapping("/evaluate/{customerId}")
    public String evaluate(@PathVariable String customerId) {
        // service method call
        return "Evaluation Complete for " + customerId;
    }
}