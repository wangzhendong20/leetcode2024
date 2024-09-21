package other;

import java.util.*;

public class code2 {

    //青书学堂是在线教育平台，有在线考试的功能，某一次在线考试后，
//数据库新增了有如下数据结构StudentQuestionScore的记录，表示某一学生作答了某一考题并获取了一定得分，
//(假定这次在线考试有100道题，100学生参与了该考试，则会有100*100条这样的数据)，假定每个学生都会交卷做完
//希望你根据这些已有数据，实现这样一个方法：返回所有学生平均分最低的前5道题目id。

    static class StudentQuestionScore {
        private int studentId;//学生id，可能范围 0 ~ 2^31-1
        private int questionId;//题目id，可能范围 0 ~ 2^31-1
        private double score;//学生得分，可能范围 0.0 ~ 10.0

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }


    /**
     * @param dataList StudentQuestionScore列表
     * @return 学生平均分最低的前5道题目id列表
     */
    public static List<Integer> solve(List<StudentQuestionScore> dataList) {
        HashMap<Integer, Double> scores = new HashMap<>();

        for (StudentQuestionScore data : dataList) {
            double score = data.getScore();
            int questionId = data.getQuestionId();
            scores.put(questionId, scores.getOrDefault(questionId, 0.0) + score);
        }

        HashMap<Integer, Double> avgScores = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : scores.entrySet()) {
            int questionId = entry.getKey();
            double score = entry.getValue();
            avgScores.put(questionId, score / 100);
        }
        PriorityQueue<Map.Entry<Integer,Double>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });

        for (Map.Entry<Integer, Double> entry : scores.entrySet()) {
            if (priorityQueue.size() < 5) {
                priorityQueue.add(entry);
            } else if (entry.getValue() < priorityQueue.peek().getValue()) {
                priorityQueue.poll();
                priorityQueue.add(entry);
            }
        }

//        List<Map.Entry<Integer, Double>> list = new ArrayList<>(avgScores.entrySet());
//        list.sort(Map.Entry.comparingByValue());


        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            res.add(list.get(i).getKey());
            res.add(priorityQueue.poll().getKey());
        }
        return res;

    }
}

