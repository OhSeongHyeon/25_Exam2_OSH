import entity.Motivation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Motivation> motivations = new ArrayList<Motivation>();
    public static int seq = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== 명언 앱 실행 ==");

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = br.readLine().trim();
            String[] tokens = cmd.split("\\?|=");

            if (cmd.equals("exit")) {
                break;
            }

            if ("목록".startsWith(cmd)) {
                System.out.println("번호 / 작가 / 명언");
                StringBuilder sb = new StringBuilder();
                int e = motivations.size();

                for (int i = e - 1; i >= 0; i--) {
                    Motivation m = motivations.get(i);
                    sb.append(String.format("%s / %s / %s\n", m.getId(), m.getAuthor(), m.getContent()));
                }

                System.out.println(sb.toString() + "==============================");
            } else if ("등록".startsWith(cmd)) {
                System.out.print("명언 : ");
                String content = br.readLine();
                System.out.print("작가 : ");
                String author = br.readLine();
                Motivation motivation = new Motivation(
                        seq,
                        LocalDateTime.now(),
                        content,
                        author
                );
                motivations.add(motivation);
                System.out.println(seq++ + "번 명언이 등록되었습니다.");
            } else if ("수정".startsWith(cmd) || (tokens.length >= 3 && "수정".equals(tokens[0]))) {
                String param = tokens[2];
                int targetId = Integer.parseInt(param);
                boolean isFound = false;

                for (Motivation m : motivations) {
                    if (targetId == m.getId()) {
                        System.out.println("명언(기존) :" + m.getContent());
                        System.out.println("작가(기존) :" + m.getAuthor());

                        System.out.print("명언 : ");
                        String newContent = br.readLine();
                        m.setContent(newContent);

                        System.out.print("작가 : ");
                        String newAuthor = br.readLine();
                        m.setAuthor(newAuthor);

                        System.out.println(m.getId() + "번 명언이 수정되었습니다.");

                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }

            } else if ("상세보기".startsWith(cmd) || (tokens.length >= 3 && "상세보기".equals(tokens[0]))) {
                String param = tokens[2];
                int targetId = Integer.parseInt(param);
                boolean isFound = false;

                for (Motivation m : motivations) {
                    if (targetId == m.getId()) {
                        System.out.println("번호 : " + m.getId());
                        System.out.println("날짜 : " + AppUtil.dateTimeParser(m.getRegDate()));
                        System.out.println("작가 : " + m.getAuthor());
                        System.out.println("내용 : " + m.getContent());

                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }

            } else if ("삭제".startsWith(cmd) || (tokens.length >= 3 && "삭제".equals(tokens[0]))) {
                String param = tokens[2];
                int targetId = Integer.parseInt(param);
                boolean isFound = false;

                for (Motivation m : motivations) {
                    if (targetId == m.getId()) {
                        motivations.remove(m);
                        System.out.println(m.getId() + "번 명언이 삭제되었습니다.");
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.println(targetId + "번 명언은 존재하지 않습니다.");
                }
            } else {
                System.out.println("알 수 없는 명령어.");
                System.out.println("명령어 확인 부탁함.");
            }
        }

    }
}
