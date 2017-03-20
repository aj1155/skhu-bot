package me.gomko.api.service;

import com.twitter.penguin.korean.KoreanTokenJava;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import org.springframework.stereotype.Service;
import scala.collection.Seq;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Manki Kim on 2017-03-20.
 */
@Service
public class KoreanAnalysisService {

    public List<String> tokenizeKoreanNoun(String text){

        // Tokenize
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(text);
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
        // [한국어, 를, 처리, 하는, 예시, 입니, 다, ㅋㅋ, #한국어]
        System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
        List<KoreanTokenJava> list = TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens);
        return list.stream().filter(data -> data.toString().contains("Noun")).map(KoreanTokenJava::getText).collect(Collectors.toList());
        // [한국어(Noun: 0, 3), 를(Josa: 3, 1),  (Space: 4, 1), 처리(Noun: 5, 2), 하는(Verb: 7, 2),  (Space: 9, 1), 예시(Noun: 10, 2), 입니(Adjective: 12, 2), 다(Eomi: 14, 1), ㅋㅋ(KoreanParticle: 15, 2),  (Space: 17, 1), #한국어(Hashtag: 18, 4)]
    }

}
