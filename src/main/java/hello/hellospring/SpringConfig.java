package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//Configuration으로 설정하면 좋은 점은 코드 수정 됐을 때 bean을 사용하는 부분을 수정하기 용이하다
@Configuration
public class SpringConfig {

    //private EntityManager em;
    //private DataSource dataSource;
    /*@Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    
    //여기다 등록 안할거면 Component Scan 써도 무방하다
   /* @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/


    /*@Bean
    public MemberRepository memberRepository() {
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTempleteMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/

}
