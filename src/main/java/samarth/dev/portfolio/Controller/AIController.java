package samarth.dev.portfolio.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import samarth.dev.portfolio.Service.AIService;





record PromptRequest(String prompt) {
}

record PromptResponse(String response) {
}

@RestController
@CrossOrigin("*")
@RequestMapping("/ai")
public class AIController {

  private final AIService aiService;

  public AIController(AIService aiService) {
    this.aiService = aiService;
  }

  @PostMapping("/portfolio")
  public ResponseEntity<PromptResponse> askAI(@RequestBody PromptRequest req) {
    return ResponseEntity.ok(new PromptResponse(aiService.askAI(req.prompt())));
  }
}
