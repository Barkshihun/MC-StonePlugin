package io.github.barkshihun;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomCommand implements CommandExecutor {

  @Override
  public boolean onCommand(
    @NotNull CommandSender sender,
    @NotNull Command command,
    @NotNull String label,
    @NotNull String[] args
  ) {
    if (sender instanceof Player) {
      Player p = (Player) sender;
      String summary = "";
      if (args.length == 0) {
        p.sendMessage("§c암석을 입력해주세요");
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 2);
        return false;
      }
      switch (args[0]) {
        case "화강암":
          summary = "화강암\n석영과 장석류를 주성분으로 하는 암석";
          break;
        case "섬록암":
          summary = "섬록암:\n사장석과 고철질 광물로 된 조립완정질의 화성암";
          break;
        case "안산암":
          summary = "안산암:\n중성화산암을 총칭하는 말";
          break;
        case "응회암":
          summary = "응회암:\n화산방출물이 퇴적, 고결된 화산쇄설암";
          break;
        case "기반암":
          summary = "기반암:\n퇴적층 밑의 화성암이나 변성암 복합체";
          break;
        case "사암":
          summary =
            "사암:\n운반작용에 의해 입자들이 쌓여 만들어진 쇄설성 퇴적암";
          break;
        case "현무암":
          summary = "현무암:\n미세립의 화산암";
          break;
        default:
          summary = String.format("입력한 것: %s", args[0]);
          p.sendMessage(summary);
          p.sendMessage("§c유효한 암석을 입력해주세요");
          p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 2);
          return false;
      }
      String url = String.format(
        "https://terms.naver.com/search.naver?query=%s",
        args[0]
      );
      TextComponent summaryComponent = Component.text(summary);
      TextComponent searchComponent = Component
        .text("지식백과", NamedTextColor.AQUA)
        .decoration(TextDecoration.UNDERLINED, true)
        .hoverEvent(HoverEvent.showText(Component.text("이동")))
        .clickEvent(ClickEvent.openUrl(url));
      p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 2);
      p.sendMessage(summaryComponent);
      p.sendMessage(searchComponent);
    }
    return true;
  }
}
