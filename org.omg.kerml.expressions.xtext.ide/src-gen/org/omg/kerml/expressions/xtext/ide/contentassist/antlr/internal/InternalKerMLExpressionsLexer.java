package org.omg.kerml.expressions.xtext.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalKerMLExpressionsLexer extends Lexer {
    public static final int T__50=50;
    public static final int RULE_SL_NOTE=12;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int RULE_DOCUMENTATION_COMMENT=10;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=6;
    public static final int RULE_DECIMAL_VALUE=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_ML_NOTE=11;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_REGULAR_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=13;
    public static final int RULE_UNRESTRICTED_NAME=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_STRING_VALUE=8;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_EXP_VALUE=4;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators

    public InternalKerMLExpressionsLexer() {;} 
    public InternalKerMLExpressionsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalKerMLExpressionsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalKerMLExpressions.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:11:7: ( '?' )
            // InternalKerMLExpressions.g:11:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:12:7: ( '??' )
            // InternalKerMLExpressions.g:12:9: '??'
            {
            match("??"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:13:7: ( '||' )
            // InternalKerMLExpressions.g:13:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:14:7: ( '&&' )
            // InternalKerMLExpressions.g:14:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:15:7: ( '|' )
            // InternalKerMLExpressions.g:15:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:16:7: ( '^' )
            // InternalKerMLExpressions.g:16:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:17:7: ( '&' )
            // InternalKerMLExpressions.g:17:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:18:7: ( '**' )
            // InternalKerMLExpressions.g:18:9: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:19:7: ( '==' )
            // InternalKerMLExpressions.g:19:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:20:7: ( '!=' )
            // InternalKerMLExpressions.g:20:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:21:7: ( 'instanceof' )
            // InternalKerMLExpressions.g:21:9: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:22:7: ( 'hastype' )
            // InternalKerMLExpressions.g:22:9: 'hastype'
            {
            match("hastype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:23:7: ( 'istype' )
            // InternalKerMLExpressions.g:23:9: 'istype'
            {
            match("istype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:24:7: ( '@' )
            // InternalKerMLExpressions.g:24:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:25:7: ( '<' )
            // InternalKerMLExpressions.g:25:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:26:7: ( '>' )
            // InternalKerMLExpressions.g:26:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:27:7: ( '<=' )
            // InternalKerMLExpressions.g:27:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:28:7: ( '>=' )
            // InternalKerMLExpressions.g:28:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:29:7: ( '+' )
            // InternalKerMLExpressions.g:29:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:30:7: ( '-' )
            // InternalKerMLExpressions.g:30:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:31:7: ( '*' )
            // InternalKerMLExpressions.g:31:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:32:7: ( '/' )
            // InternalKerMLExpressions.g:32:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:33:7: ( '%' )
            // InternalKerMLExpressions.g:33:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:34:7: ( '!' )
            // InternalKerMLExpressions.g:34:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:35:7: ( '~' )
            // InternalKerMLExpressions.g:35:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:36:7: ( ':' )
            // InternalKerMLExpressions.g:36:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:37:7: ( 'true' )
            // InternalKerMLExpressions.g:37:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:38:7: ( 'false' )
            // InternalKerMLExpressions.g:38:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:39:7: ( 'public' )
            // InternalKerMLExpressions.g:39:9: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:40:7: ( 'private' )
            // InternalKerMLExpressions.g:40:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:41:7: ( 'protected' )
            // InternalKerMLExpressions.g:41:9: 'protected'
            {
            match("protected"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:42:7: ( 'packaged' )
            // InternalKerMLExpressions.g:42:9: 'packaged'
            {
            match("packaged"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:43:7: ( ']' )
            // InternalKerMLExpressions.g:43:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:44:7: ( '.' )
            // InternalKerMLExpressions.g:44:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:45:7: ( '(' )
            // InternalKerMLExpressions.g:45:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:46:7: ( ')' )
            // InternalKerMLExpressions.g:46:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:47:7: ( '->' )
            // InternalKerMLExpressions.g:47:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:48:7: ( 'defined' )
            // InternalKerMLExpressions.g:48:9: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:49:7: ( 'by' )
            // InternalKerMLExpressions.g:49:9: 'by'
            {
            match("by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:50:7: ( '{' )
            // InternalKerMLExpressions.g:50:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:51:7: ( '}' )
            // InternalKerMLExpressions.g:51:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:52:7: ( '[' )
            // InternalKerMLExpressions.g:52:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:53:7: ( '..' )
            // InternalKerMLExpressions.g:53:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:54:7: ( ',' )
            // InternalKerMLExpressions.g:54:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:55:7: ( '=>' )
            // InternalKerMLExpressions.g:55:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:56:7: ( 'null' )
            // InternalKerMLExpressions.g:56:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:57:7: ( '::' )
            // InternalKerMLExpressions.g:57:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:58:7: ( 'doc' )
            // InternalKerMLExpressions.g:58:9: 'doc'
            {
            match("doc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:59:7: ( 'id' )
            // InternalKerMLExpressions.g:59:9: 'id'
            {
            match("id"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:60:7: ( '@[' )
            // InternalKerMLExpressions.g:60:9: '@['
            {
            match("@["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:61:7: ( 'all' )
            // InternalKerMLExpressions.g:61:9: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:62:7: ( 'allInstances' )
            // InternalKerMLExpressions.g:62:9: 'allInstances'
            {
            match("allInstances"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:63:7: ( 'ordered' )
            // InternalKerMLExpressions.g:63:9: 'ordered'
            {
            match("ordered"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:64:7: ( 'nonunique' )
            // InternalKerMLExpressions.g:64:9: 'nonunique'
            {
            match("nonunique"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "RULE_DECIMAL_VALUE"
    public final void mRULE_DECIMAL_VALUE() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9520:20: ( '0' .. '9' ( '0' .. '9' )* )
            // InternalKerMLExpressions.g:9520:22: '0' .. '9' ( '0' .. '9' )*
            {
            matchRange('0','9'); 
            // InternalKerMLExpressions.g:9520:31: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9520:32: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL_VALUE"

    // $ANTLR start "RULE_EXP_VALUE"
    public final void mRULE_EXP_VALUE() throws RecognitionException {
        try {
            int _type = RULE_EXP_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9522:16: ( RULE_DECIMAL_VALUE ( 'e' | 'E' ) ( '+' | '-' )? RULE_DECIMAL_VALUE )
            // InternalKerMLExpressions.g:9522:18: RULE_DECIMAL_VALUE ( 'e' | 'E' ) ( '+' | '-' )? RULE_DECIMAL_VALUE
            {
            mRULE_DECIMAL_VALUE(); 
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalKerMLExpressions.g:9522:47: ( '+' | '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='+'||LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalKerMLExpressions.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            mRULE_DECIMAL_VALUE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXP_VALUE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9524:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalKerMLExpressions.g:9524:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalKerMLExpressions.g:9524:35: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalKerMLExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_UNRESTRICTED_NAME"
    public final void mRULE_UNRESTRICTED_NAME() throws RecognitionException {
        try {
            int _type = RULE_UNRESTRICTED_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9526:24: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // InternalKerMLExpressions.g:9526:26: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // InternalKerMLExpressions.g:9526:31: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9526:32: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // InternalKerMLExpressions.g:9526:73: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNRESTRICTED_NAME"

    // $ANTLR start "RULE_STRING_VALUE"
    public final void mRULE_STRING_VALUE() throws RecognitionException {
        try {
            int _type = RULE_STRING_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9528:19: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalKerMLExpressions.g:9528:21: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalKerMLExpressions.g:9528:25: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9528:26: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // InternalKerMLExpressions.g:9528:67: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING_VALUE"

    // $ANTLR start "RULE_REGULAR_COMMENT"
    public final void mRULE_REGULAR_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_REGULAR_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9530:22: ( '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/' )
            // InternalKerMLExpressions.g:9530:24: '/*' ~ ( '*' ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalKerMLExpressions.g:9530:36: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9530:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REGULAR_COMMENT"

    // $ANTLR start "RULE_DOCUMENTATION_COMMENT"
    public final void mRULE_DOCUMENTATION_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_DOCUMENTATION_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9532:28: ( '/**' ( options {greedy=false; } : . )* '*/' )
            // InternalKerMLExpressions.g:9532:30: '/**' ( options {greedy=false; } : . )* '*/'
            {
            match("/**"); 

            // InternalKerMLExpressions.g:9532:36: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9532:64: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOCUMENTATION_COMMENT"

    // $ANTLR start "RULE_ML_NOTE"
    public final void mRULE_ML_NOTE() throws RecognitionException {
        try {
            int _type = RULE_ML_NOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9534:14: ( '//*' ( options {greedy=false; } : . )* '*/' )
            // InternalKerMLExpressions.g:9534:16: '//*' ( options {greedy=false; } : . )* '*/'
            {
            match("//*"); 

            // InternalKerMLExpressions.g:9534:22: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalKerMLExpressions.g:9534:50: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_NOTE"

    // $ANTLR start "RULE_SL_NOTE"
    public final void mRULE_SL_NOTE() throws RecognitionException {
        try {
            int _type = RULE_SL_NOTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9536:14: ( '//' (~ ( ( '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )? ( ( '\\r' )? '\\n' )? )
            // InternalKerMLExpressions.g:9536:16: '//' (~ ( ( '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )? ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalKerMLExpressions.g:9536:21: (~ ( ( '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalKerMLExpressions.g:9536:22: ~ ( ( '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )*
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalKerMLExpressions.g:9536:37: (~ ( ( '\\n' | '\\r' ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalKerMLExpressions.g:9536:37: ~ ( ( '\\n' | '\\r' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalKerMLExpressions.g:9536:55: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalKerMLExpressions.g:9536:56: ( '\\r' )? '\\n'
                    {
                    // InternalKerMLExpressions.g:9536:56: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalKerMLExpressions.g:9536:56: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_NOTE"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalKerMLExpressions.g:9538:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalKerMLExpressions.g:9538:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalKerMLExpressions.g:9538:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalKerMLExpressions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // InternalKerMLExpressions.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | RULE_DECIMAL_VALUE | RULE_EXP_VALUE | RULE_ID | RULE_UNRESTRICTED_NAME | RULE_STRING_VALUE | RULE_REGULAR_COMMENT | RULE_DOCUMENTATION_COMMENT | RULE_ML_NOTE | RULE_SL_NOTE | RULE_WS )
        int alt14=64;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalKerMLExpressions.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalKerMLExpressions.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalKerMLExpressions.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalKerMLExpressions.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalKerMLExpressions.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalKerMLExpressions.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalKerMLExpressions.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalKerMLExpressions.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalKerMLExpressions.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalKerMLExpressions.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalKerMLExpressions.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalKerMLExpressions.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalKerMLExpressions.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalKerMLExpressions.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalKerMLExpressions.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalKerMLExpressions.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalKerMLExpressions.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalKerMLExpressions.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalKerMLExpressions.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalKerMLExpressions.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalKerMLExpressions.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalKerMLExpressions.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalKerMLExpressions.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalKerMLExpressions.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalKerMLExpressions.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // InternalKerMLExpressions.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // InternalKerMLExpressions.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // InternalKerMLExpressions.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // InternalKerMLExpressions.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // InternalKerMLExpressions.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // InternalKerMLExpressions.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // InternalKerMLExpressions.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // InternalKerMLExpressions.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // InternalKerMLExpressions.g:1:208: T__47
                {
                mT__47(); 

                }
                break;
            case 35 :
                // InternalKerMLExpressions.g:1:214: T__48
                {
                mT__48(); 

                }
                break;
            case 36 :
                // InternalKerMLExpressions.g:1:220: T__49
                {
                mT__49(); 

                }
                break;
            case 37 :
                // InternalKerMLExpressions.g:1:226: T__50
                {
                mT__50(); 

                }
                break;
            case 38 :
                // InternalKerMLExpressions.g:1:232: T__51
                {
                mT__51(); 

                }
                break;
            case 39 :
                // InternalKerMLExpressions.g:1:238: T__52
                {
                mT__52(); 

                }
                break;
            case 40 :
                // InternalKerMLExpressions.g:1:244: T__53
                {
                mT__53(); 

                }
                break;
            case 41 :
                // InternalKerMLExpressions.g:1:250: T__54
                {
                mT__54(); 

                }
                break;
            case 42 :
                // InternalKerMLExpressions.g:1:256: T__55
                {
                mT__55(); 

                }
                break;
            case 43 :
                // InternalKerMLExpressions.g:1:262: T__56
                {
                mT__56(); 

                }
                break;
            case 44 :
                // InternalKerMLExpressions.g:1:268: T__57
                {
                mT__57(); 

                }
                break;
            case 45 :
                // InternalKerMLExpressions.g:1:274: T__58
                {
                mT__58(); 

                }
                break;
            case 46 :
                // InternalKerMLExpressions.g:1:280: T__59
                {
                mT__59(); 

                }
                break;
            case 47 :
                // InternalKerMLExpressions.g:1:286: T__60
                {
                mT__60(); 

                }
                break;
            case 48 :
                // InternalKerMLExpressions.g:1:292: T__61
                {
                mT__61(); 

                }
                break;
            case 49 :
                // InternalKerMLExpressions.g:1:298: T__62
                {
                mT__62(); 

                }
                break;
            case 50 :
                // InternalKerMLExpressions.g:1:304: T__63
                {
                mT__63(); 

                }
                break;
            case 51 :
                // InternalKerMLExpressions.g:1:310: T__64
                {
                mT__64(); 

                }
                break;
            case 52 :
                // InternalKerMLExpressions.g:1:316: T__65
                {
                mT__65(); 

                }
                break;
            case 53 :
                // InternalKerMLExpressions.g:1:322: T__66
                {
                mT__66(); 

                }
                break;
            case 54 :
                // InternalKerMLExpressions.g:1:328: T__67
                {
                mT__67(); 

                }
                break;
            case 55 :
                // InternalKerMLExpressions.g:1:334: RULE_DECIMAL_VALUE
                {
                mRULE_DECIMAL_VALUE(); 

                }
                break;
            case 56 :
                // InternalKerMLExpressions.g:1:353: RULE_EXP_VALUE
                {
                mRULE_EXP_VALUE(); 

                }
                break;
            case 57 :
                // InternalKerMLExpressions.g:1:368: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 58 :
                // InternalKerMLExpressions.g:1:376: RULE_UNRESTRICTED_NAME
                {
                mRULE_UNRESTRICTED_NAME(); 

                }
                break;
            case 59 :
                // InternalKerMLExpressions.g:1:399: RULE_STRING_VALUE
                {
                mRULE_STRING_VALUE(); 

                }
                break;
            case 60 :
                // InternalKerMLExpressions.g:1:417: RULE_REGULAR_COMMENT
                {
                mRULE_REGULAR_COMMENT(); 

                }
                break;
            case 61 :
                // InternalKerMLExpressions.g:1:438: RULE_DOCUMENTATION_COMMENT
                {
                mRULE_DOCUMENTATION_COMMENT(); 

                }
                break;
            case 62 :
                // InternalKerMLExpressions.g:1:465: RULE_ML_NOTE
                {
                mRULE_ML_NOTE(); 

                }
                break;
            case 63 :
                // InternalKerMLExpressions.g:1:478: RULE_SL_NOTE
                {
                mRULE_SL_NOTE(); 

                }
                break;
            case 64 :
                // InternalKerMLExpressions.g:1:491: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\51\1\53\1\55\1\uffff\1\57\1\uffff\1\63\2\44\1\71\1\73\1\75\1\uffff\1\77\1\102\2\uffff\1\104\3\44\1\uffff\1\113\2\uffff\2\44\4\uffff\3\44\1\124\20\uffff\2\44\1\130\1\44\11\uffff\1\135\3\uffff\5\44\2\uffff\2\44\1\146\4\44\1\124\2\uffff\2\44\1\uffff\1\44\2\uffff\1\135\1\uffff\7\44\1\171\1\uffff\2\44\1\175\4\44\1\135\1\uffff\2\135\1\u0084\6\44\1\uffff\1\u008b\2\44\1\uffff\4\44\1\u0083\2\uffff\1\u0092\5\44\1\uffff\4\44\1\u009c\1\44\1\uffff\1\u009e\10\44\1\uffff\1\u00a7\1\uffff\1\u00a8\2\44\1\u00ab\2\44\1\u00ae\1\44\2\uffff\1\44\1\u00b1\1\uffff\2\44\1\uffff\1\44\1\u00b5\1\uffff\1\u00b6\1\44\1\u00b8\2\uffff\1\44\1\uffff\1\44\1\u00bb\1\uffff";
    static final String DFA14_eofS =
        "\u00bc\uffff";
    static final String DFA14_minS =
        "\1\11\1\77\1\174\1\46\1\uffff\1\52\2\75\1\144\1\141\1\133\2\75\1\uffff\1\76\1\52\2\uffff\1\72\1\162\2\141\1\uffff\1\56\2\uffff\1\145\1\171\4\uffff\1\157\1\154\1\162\1\60\20\uffff\1\163\1\164\1\60\1\163\10\uffff\1\0\1\52\3\uffff\1\165\1\154\1\142\1\151\1\143\2\uffff\1\146\1\143\1\60\1\154\1\156\1\154\1\144\1\60\2\uffff\1\164\1\171\1\uffff\1\164\2\uffff\1\0\1\uffff\1\145\1\163\1\154\1\166\1\164\1\153\1\151\1\60\1\uffff\1\154\1\165\1\60\1\145\1\141\1\160\1\171\4\0\1\60\1\145\1\151\1\141\1\145\1\141\1\156\1\uffff\1\60\2\156\1\uffff\1\162\1\156\1\145\1\160\1\0\2\uffff\1\60\1\143\1\164\1\143\1\147\1\145\1\uffff\1\151\1\163\1\145\1\143\1\60\1\145\1\uffff\1\60\1\145\1\164\1\145\1\144\1\161\1\164\1\144\1\145\1\uffff\1\60\1\uffff\1\60\1\145\1\144\1\60\1\165\1\141\1\60\1\157\2\uffff\1\144\1\60\1\uffff\1\145\1\156\1\uffff\1\146\1\60\1\uffff\1\60\1\143\1\60\2\uffff\1\145\1\uffff\1\163\1\60\1\uffff";
    static final String DFA14_maxS =
        "\1\176\1\77\1\174\1\46\1\uffff\1\52\1\76\1\75\1\163\1\141\1\133\2\75\1\uffff\1\76\1\57\2\uffff\1\72\1\162\1\141\1\165\1\uffff\1\56\2\uffff\1\157\1\171\4\uffff\1\165\1\154\1\162\1\145\20\uffff\1\163\1\164\1\172\1\163\10\uffff\1\uffff\1\52\3\uffff\1\165\1\154\1\142\1\157\1\143\2\uffff\1\146\1\143\1\172\1\154\1\156\1\154\1\144\1\145\2\uffff\1\164\1\171\1\uffff\1\164\2\uffff\1\uffff\1\uffff\1\145\1\163\1\154\1\166\1\164\1\153\1\151\1\172\1\uffff\1\154\1\165\1\172\1\145\1\141\1\160\1\171\4\uffff\1\172\1\145\1\151\1\141\1\145\1\141\1\156\1\uffff\1\172\2\156\1\uffff\1\162\1\156\1\145\1\160\1\uffff\2\uffff\1\172\1\143\1\164\1\143\1\147\1\145\1\uffff\1\151\1\163\1\145\1\143\1\172\1\145\1\uffff\1\172\1\145\1\164\1\145\1\144\1\161\1\164\1\144\1\145\1\uffff\1\172\1\uffff\1\172\1\145\1\144\1\172\1\165\1\141\1\172\1\157\2\uffff\1\144\1\172\1\uffff\1\145\1\156\1\uffff\1\146\1\172\1\uffff\1\172\1\143\1\172\2\uffff\1\145\1\uffff\1\163\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\4\uffff\1\6\10\uffff\1\23\2\uffff\1\27\1\31\4\uffff\1\41\1\uffff\1\43\1\44\2\uffff\1\50\1\51\1\52\1\54\4\uffff\1\71\1\72\1\73\1\100\1\2\1\1\1\3\1\5\1\4\1\7\1\10\1\25\1\11\1\55\1\12\1\30\4\uffff\1\62\1\16\1\21\1\17\1\22\1\20\1\45\1\24\2\uffff\1\26\1\57\1\32\5\uffff\1\53\1\42\10\uffff\1\67\1\70\2\uffff\1\61\1\uffff\1\74\1\75\1\uffff\1\77\10\uffff\1\47\22\uffff\1\60\3\uffff\1\63\5\uffff\1\76\1\33\6\uffff\1\56\6\uffff\1\34\11\uffff\1\15\1\uffff\1\35\10\uffff\1\14\1\36\2\uffff\1\46\2\uffff\1\65\2\uffff\1\40\3\uffff\1\37\1\66\1\uffff\1\13\2\uffff\1\64";
    static final String DFA14_specialS =
        "\100\uffff\1\0\33\uffff\1\2\21\uffff\1\3\1\4\1\6\1\1\20\uffff\1\5\71\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\47\2\uffff\1\47\22\uffff\1\47\1\7\1\46\2\uffff\1\20\1\3\1\45\1\30\1\31\1\5\1\15\1\37\1\16\1\27\1\17\12\43\1\22\1\uffff\1\13\1\6\1\14\1\1\1\12\32\44\1\36\1\uffff\1\26\1\4\1\44\1\uffff\1\41\1\33\1\44\1\32\1\44\1\24\1\44\1\11\1\10\4\44\1\40\1\42\1\25\3\44\1\23\6\44\1\34\1\2\1\35\1\21",
            "\1\50",
            "\1\52",
            "\1\54",
            "",
            "\1\56",
            "\1\60\1\61",
            "\1\62",
            "\1\66\11\uffff\1\64\4\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\72",
            "\1\74",
            "",
            "\1\76",
            "\1\100\4\uffff\1\101",
            "",
            "",
            "\1\103",
            "\1\105",
            "\1\106",
            "\1\111\20\uffff\1\110\2\uffff\1\107",
            "",
            "\1\112",
            "",
            "",
            "\1\114\11\uffff\1\115",
            "\1\116",
            "",
            "",
            "",
            "",
            "\1\120\5\uffff\1\117",
            "\1\121",
            "\1\122",
            "\12\123\13\uffff\1\125\37\uffff\1\125",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\126",
            "\1\127",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\131",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\52\132\1\133\uffd5\132",
            "\1\134",
            "",
            "",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141\5\uffff\1\142",
            "\1\143",
            "",
            "",
            "\1\144",
            "\1\145",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\12\123\13\uffff\1\125\37\uffff\1\125",
            "",
            "",
            "\1\153",
            "\1\154",
            "",
            "\1\155",
            "",
            "",
            "\12\161\1\160\2\161\1\157\34\161\1\156\uffd5\161",
            "",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\172",
            "\1\173",
            "\12\44\7\uffff\10\44\1\174\21\44\4\uffff\1\44\1\uffff\32\44",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\12\161\1\160\2\161\1\157\34\161\1\156\4\161\1\u0082\uffd0\161",
            "\12\u0083\1\160\ufff5\u0083",
            "\0\u0083",
            "\12\161\1\160\2\161\1\157\34\161\1\156\uffd5\161",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\12\161\1\160\2\161\1\157\34\161\1\156\uffd5\161",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u009d",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00a9",
            "\1\u00aa",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00ac",
            "\1\u00ad",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00af",
            "",
            "",
            "\1\u00b0",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b7",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\u00b9",
            "",
            "\1\u00ba",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | RULE_DECIMAL_VALUE | RULE_EXP_VALUE | RULE_ID | RULE_UNRESTRICTED_NAME | RULE_STRING_VALUE | RULE_REGULAR_COMMENT | RULE_DOCUMENTATION_COMMENT | RULE_ML_NOTE | RULE_SL_NOTE | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_64 = input.LA(1);

                        s = -1;
                        if ( ((LA14_64>='\u0000' && LA14_64<=')')||(LA14_64>='+' && LA14_64<='\uFFFF')) ) {s = 90;}

                        else if ( (LA14_64=='*') ) {s = 91;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_113 = input.LA(1);

                        s = -1;
                        if ( (LA14_113=='\r') ) {s = 111;}

                        else if ( (LA14_113=='\n') ) {s = 112;}

                        else if ( (LA14_113=='*') ) {s = 110;}

                        else if ( ((LA14_113>='\u0000' && LA14_113<='\t')||(LA14_113>='\u000B' && LA14_113<='\f')||(LA14_113>='\u000E' && LA14_113<=')')||(LA14_113>='+' && LA14_113<='\uFFFF')) ) {s = 113;}

                        else s = 93;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_92 = input.LA(1);

                        s = -1;
                        if ( (LA14_92=='*') ) {s = 110;}

                        else if ( (LA14_92=='\r') ) {s = 111;}

                        else if ( (LA14_92=='\n') ) {s = 112;}

                        else if ( ((LA14_92>='\u0000' && LA14_92<='\t')||(LA14_92>='\u000B' && LA14_92<='\f')||(LA14_92>='\u000E' && LA14_92<=')')||(LA14_92>='+' && LA14_92<='\uFFFF')) ) {s = 113;}

                        else s = 93;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_110 = input.LA(1);

                        s = -1;
                        if ( (LA14_110=='/') ) {s = 130;}

                        else if ( (LA14_110=='\r') ) {s = 111;}

                        else if ( (LA14_110=='\n') ) {s = 112;}

                        else if ( (LA14_110=='*') ) {s = 110;}

                        else if ( ((LA14_110>='\u0000' && LA14_110<='\t')||(LA14_110>='\u000B' && LA14_110<='\f')||(LA14_110>='\u000E' && LA14_110<=')')||(LA14_110>='+' && LA14_110<='.')||(LA14_110>='0' && LA14_110<='\uFFFF')) ) {s = 113;}

                        else s = 93;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_111 = input.LA(1);

                        s = -1;
                        if ( ((LA14_111>='\u0000' && LA14_111<='\t')||(LA14_111>='\u000B' && LA14_111<='\uFFFF')) ) {s = 131;}

                        else if ( (LA14_111=='\n') ) {s = 112;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_130 = input.LA(1);

                        s = -1;
                        if ( (LA14_130=='\r') ) {s = 111;}

                        else if ( (LA14_130=='\n') ) {s = 112;}

                        else if ( (LA14_130=='*') ) {s = 110;}

                        else if ( ((LA14_130>='\u0000' && LA14_130<='\t')||(LA14_130>='\u000B' && LA14_130<='\f')||(LA14_130>='\u000E' && LA14_130<=')')||(LA14_130>='+' && LA14_130<='\uFFFF')) ) {s = 113;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA14_112 = input.LA(1);

                        s = -1;
                        if ( ((LA14_112>='\u0000' && LA14_112<='\uFFFF')) ) {s = 131;}

                        else s = 93;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}