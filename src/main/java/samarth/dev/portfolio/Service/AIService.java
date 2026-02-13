package samarth.dev.portfolio.Service;



import samarth.dev.portfolio.Config.PortfolioContext;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AIService {

  private final ChatClient chatClient;

  public AIService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder
        .defaultSystem(PortfolioContext.CONTEXT) //set manual rules for chat client
        .build();
  }

  public String askAI(String userQuestion) {
    if (!StringUtils.hasText(userQuestion)) {
      throw new IllegalArgumentException("prompt is required");
    }

    return chatClient.prompt()
        .user(userQuestion.trim())
        .call()
        .content();

    // Alternative approach if needed in future: we can direcly pass our prompt in prompt() gives same output
    // return chatClient.prompt(userQuestion.trim())
    //     .call()
    //     .content();
  }
}
