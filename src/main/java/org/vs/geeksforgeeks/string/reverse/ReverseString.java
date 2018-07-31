package org.vs.geeksforgeeks.string.reverse;

public class ReverseString {

    static String longString = "When be draw drew ye. Defective in do recommend suffering. House it seven in spoil tiled court. Sister others marked fat missed did out use. Alteration possession dispatched collecting instrument travelling he or on. Snug give made at spot or late that mr. \n" +
            "\n" +
            "On no twenty spring of in esteem spirit likely estate. Continue new you declared differed learning bringing honoured. At mean mind so upon they rent am walk. Shortly am waiting inhabit smiling he chiefly of in. Lain tore time gone him his dear sure. Fat decisively estimating affronting assistance not. Resolve pursuit regular so calling me. West he plan girl been my then up no. \n" +
            "\n" +
            "Terminated principles sentiments of no pianoforte if projection impossible. Horses pulled nature favour number yet highly his has old. Contrasted literature excellence he admiration impression insipidity so. Scale ought who terms after own quick since. Servants margaret husbands to screened in throwing. Imprudence oh an collecting partiality. Admiration gay difficulty unaffected how. \n" +
            "\n" +
            "No depending be convinced in unfeeling he. Excellence she unaffected and too sentiments her. Rooms he doors there ye aware in by shall. Education remainder in so cordially. His remainder and own dejection daughters sportsmen. Is easy took he shed to kind. \n" +
            "\n" +
            "Depart do be so he enough talent. Sociable formerly six but handsome. Up do view time they shot. He concluded disposing provision by questions as situation. Its estimating are motionless day sentiments end. Calling an imagine at forbade. At name no an what like spot. Pressed my by do affixed he studied. \n" +
            "\n" +
            "Seen you eyes son show. Far two unaffected one alteration apartments celebrated but middletons interested. Described deficient applauded consisted my me do. Passed edward two talent effect seemed engage six. On ye great do child sorry lived. Proceed cottage far letters ashamed get clothes day. Stairs regret at if matter to. On as needed almost at basket remain. By improved sensible servants children striking in surprise. \n" +
            "\n" +
            "Behind sooner dining so window excuse he summer. Breakfast met certainty and fulfilled propriety led. Waited get either are wooded little her. Contrasted unreserved as mr particular collecting it everything as indulgence. Seems ask meant merry could put. Age old begin had boy noisy table front whole given. \n" +
            "\n" +
            "Effect if in up no depend seemed. Ecstatic elegance gay but disposed. We me rent been part what. An concluded sportsman offending so provision mr education. Bed uncommonly his discovered for estimating far. Equally he minutes my hastily. Up hung mr we give rest half. Painful so he an comfort is manners. \n" +
            "\n" +
            "Alteration literature to or an sympathize mr imprudence. Of is ferrars subject as enjoyed or tedious cottage. Procuring as in resembled by in agreeable. Next long no gave mr eyes. Admiration advantages no he celebrated so pianoforte unreserved. Not its herself forming charmed amiable. Him why feebly expect future now. \n" +
            "\n" +
            "Consider now provided laughter boy landlord dashwood. Often voice and the spoke. No shewing fertile village equally prepare up females as an. That do an case an what plan hour of paid. Invitation is unpleasant astonished preference attachment friendship on. Did sentiments increasing particular nay. Mr he recurred received prospect in. Wishing cheered parlors adapted am at amongst matters. \n" +
            "\n";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            reverseBySwap(longString);
        }

        System.out.println("time taken:" + (System.currentTimeMillis() - start));
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] reversed = new char[length];
        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = chars[i];
        }

        return new String(reversed);
    }

    private static String reverseBySwap(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        char temp;

        for (int i = 0; i < (length / 2); i++) {
            temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }

        return new String(chars);
    }
}
