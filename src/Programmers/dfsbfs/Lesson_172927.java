package Programmers.dfsbfs;

public class Lesson_172927 {

        // 곡괭이 수 picks, 광물의 순서 minerals
        // picks => dia, iron, stone 개수
        // minerals => diamond, iron, stone 으로 이루어짐
        // 피로도
        //       dia, iron, stone
        // dia : 1 1 1
        // iron : 5 1 1
        // stone : 25, 5, 1
        private static final int[][] ENERGIES = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        public int solution(int[] picks, String[] minerals) {
            return dfs(picks[0], picks[1], picks[2], minerals, 0);
        }


        private int dfs(int dia, int iron, int stone, String[] minerals, int index) {
            if((dia <= 0 && iron <= 0 && stone <=0) || index == minerals.length) {
                return 0;
            }

            int energies = 0;
            int end = Math.min(minerals.length, index+5);

            if(dia > 0) {
                energies = getUseEnergy(0, minerals, index, end) +
                        dfs(dia-1, iron, stone, minerals, end);
            }

            if(iron > 0) {
                int useEnergies = getUseEnergy(1, minerals, index, end) +
                        dfs(dia, iron-1, stone, minerals, end);
                energies = energies == 0? useEnergies : Math.min(useEnergies, energies);
            }

            if(stone > 0) {
                int useEnergies = getUseEnergy(2, minerals, index, end) +
                        dfs(dia, iron, stone-1, minerals, end);
                energies = energies == 0? useEnergies : Math.min(useEnergies, energies);
            }

            return energies;
        }

        private int getUseEnergy(int pick, String[] minerals, int start, int end) {
            int energy = 0;
            for(int i=start; i<end; i++) {
                int mineralIndex = getIndexFromMineralName(minerals[i]);
                energy += ENERGIES[pick][mineralIndex];
            }

            return energy;
        }

        private int getIndexFromMineralName(String name) {
            if(name.equals("diamond")) return 0;
            else if(name.equals("iron")) return 1;
            else if(name.equals("stone")) return 2;

            return 4;
        }

//[1, 3, 2]	["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	12
// [0, 1, 1]	["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	50
    public static void main(String[] args) {
        Lesson_172927 lesson = new Lesson_172927();
        int[] picks = {1, 3, 2};
//        int[] picks = {0, 1, 1};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
//        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        int result = lesson.solution(picks, minerals);
        System.out.println(result);
    }
}
