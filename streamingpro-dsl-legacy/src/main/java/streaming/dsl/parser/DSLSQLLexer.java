// Generated from /Users/dxy_why/Documents/workspace/streamingpro/streamingpro-dsl/src/main/resources/DSLSQL.g4 by ANTLR 4.7

package streaming.dsl.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DSLSQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		STRING=39, IDENTIFIER=40, BACKQUOTED_IDENTIFIER=41, SIMPLE_COMMENT=42, 
		BRACKETED_EMPTY_COMMENT=43, BRACKETED_COMMENT=44, WS=45, UNRECOGNIZED=46;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "STRING", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", 
		"DIGIT", "LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'load'", "'LOAD'", "'.'", "'options'", "'as'", "'save'", "'SAVE'", 
		"'partitionBy'", "'select'", "'SELECT'", "';'", "'insert'", "'INSERT'", 
		"'create'", "'CREATE'", "'drop'", "'DROP'", "'refresh'", "'REFRESH'", 
		"'set'", "'SET'", "'='", "'connect'", "'CONNECT'", "'where'", "'train'", 
		"'TRAIN'", "'register'", "'REGISTER'", "'unRegister'", "'UNREGISTER'", 
		"'define'", "'DEFINE'", "'overwrite'", "'append'", "'errorIfExists'", 
		"'ignore'", "'and'", null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "STRING", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", 
		"BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DSLSQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DSLSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\60\u01be\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!"+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u0167\n(\f(\16(\u016a\13(\3(\3(\3"+
		"(\3(\3(\7(\u0171\n(\f(\16(\u0174\13(\3(\5(\u0177\n(\3)\3)\3)\6)\u017c"+
		"\n)\r)\16)\u017d\3*\3*\3*\3*\7*\u0184\n*\f*\16*\u0187\13*\3*\3*\3+\3+"+
		"\3,\3,\3-\3-\3-\3-\7-\u0193\n-\f-\16-\u0196\13-\3-\5-\u0199\n-\3-\5-\u019c"+
		"\n-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\7/\u01ac\n/\f/\16/\u01af"+
		"\13/\3/\3/\3/\3/\3/\3\60\6\60\u01b7\n\60\r\60\16\60\u01b8\3\60\3\60\3"+
		"\61\3\61\3\u01ad\2\62\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W\2Y,[-]._/a\60\3\2\n"+
		"\4\2))^^\4\2$$^^\3\2bb\3\2\62;\4\2C\\c|\4\2\f\f\17\17\3\2--\5\2\13\f\17"+
		"\17\"\"\2\u01ca\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3"+
		"c\3\2\2\2\5h\3\2\2\2\7m\3\2\2\2\to\3\2\2\2\13w\3\2\2\2\rz\3\2\2\2\17\177"+
		"\3\2\2\2\21\u0084\3\2\2\2\23\u0090\3\2\2\2\25\u0097\3\2\2\2\27\u009e\3"+
		"\2\2\2\31\u00a0\3\2\2\2\33\u00a7\3\2\2\2\35\u00ae\3\2\2\2\37\u00b5\3\2"+
		"\2\2!\u00bc\3\2\2\2#\u00c1\3\2\2\2%\u00c6\3\2\2\2\'\u00ce\3\2\2\2)\u00d6"+
		"\3\2\2\2+\u00da\3\2\2\2-\u00de\3\2\2\2/\u00e0\3\2\2\2\61\u00e8\3\2\2\2"+
		"\63\u00f0\3\2\2\2\65\u00f6\3\2\2\2\67\u00fc\3\2\2\29\u0102\3\2\2\2;\u010b"+
		"\3\2\2\2=\u0114\3\2\2\2?\u011f\3\2\2\2A\u012a\3\2\2\2C\u0131\3\2\2\2E"+
		"\u0138\3\2\2\2G\u0142\3\2\2\2I\u0149\3\2\2\2K\u0157\3\2\2\2M\u015e\3\2"+
		"\2\2O\u0176\3\2\2\2Q\u017b\3\2\2\2S\u017f\3\2\2\2U\u018a\3\2\2\2W\u018c"+
		"\3\2\2\2Y\u018e\3\2\2\2[\u019f\3\2\2\2]\u01a6\3\2\2\2_\u01b6\3\2\2\2a"+
		"\u01bc\3\2\2\2cd\7n\2\2de\7q\2\2ef\7c\2\2fg\7f\2\2g\4\3\2\2\2hi\7N\2\2"+
		"ij\7Q\2\2jk\7C\2\2kl\7F\2\2l\6\3\2\2\2mn\7\60\2\2n\b\3\2\2\2op\7q\2\2"+
		"pq\7r\2\2qr\7v\2\2rs\7k\2\2st\7q\2\2tu\7p\2\2uv\7u\2\2v\n\3\2\2\2wx\7"+
		"c\2\2xy\7u\2\2y\f\3\2\2\2z{\7u\2\2{|\7c\2\2|}\7x\2\2}~\7g\2\2~\16\3\2"+
		"\2\2\177\u0080\7U\2\2\u0080\u0081\7C\2\2\u0081\u0082\7X\2\2\u0082\u0083"+
		"\7G\2\2\u0083\20\3\2\2\2\u0084\u0085\7r\2\2\u0085\u0086\7c\2\2\u0086\u0087"+
		"\7t\2\2\u0087\u0088\7v\2\2\u0088\u0089\7k\2\2\u0089\u008a\7v\2\2\u008a"+
		"\u008b\7k\2\2\u008b\u008c\7q\2\2\u008c\u008d\7p\2\2\u008d\u008e\7D\2\2"+
		"\u008e\u008f\7{\2\2\u008f\22\3\2\2\2\u0090\u0091\7u\2\2\u0091\u0092\7"+
		"g\2\2\u0092\u0093\7n\2\2\u0093\u0094\7g\2\2\u0094\u0095\7e\2\2\u0095\u0096"+
		"\7v\2\2\u0096\24\3\2\2\2\u0097\u0098\7U\2\2\u0098\u0099\7G\2\2\u0099\u009a"+
		"\7N\2\2\u009a\u009b\7G\2\2\u009b\u009c\7E\2\2\u009c\u009d\7V\2\2\u009d"+
		"\26\3\2\2\2\u009e\u009f\7=\2\2\u009f\30\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7t\2\2"+
		"\u00a5\u00a6\7v\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7K\2\2\u00a8\u00a9\7"+
		"P\2\2\u00a9\u00aa\7U\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7T\2\2\u00ac\u00ad"+
		"\7V\2\2\u00ad\34\3\2\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7g\2\2\u00b4"+
		"\36\3\2\2\2\u00b5\u00b6\7E\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8\7G\2\2\u00b8"+
		"\u00b9\7C\2\2\u00b9\u00ba\7V\2\2\u00ba\u00bb\7G\2\2\u00bb \3\2\2\2\u00bc"+
		"\u00bd\7f\2\2\u00bd\u00be\7t\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7r\2\2"+
		"\u00c0\"\3\2\2\2\u00c1\u00c2\7F\2\2\u00c2\u00c3\7T\2\2\u00c3\u00c4\7Q"+
		"\2\2\u00c4\u00c5\7R\2\2\u00c5$\3\2\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8"+
		"\7g\2\2\u00c8\u00c9\7h\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00cc\7u\2\2\u00cc\u00cd\7j\2\2\u00cd&\3\2\2\2\u00ce\u00cf\7T\2\2\u00cf"+
		"\u00d0\7G\2\2\u00d0\u00d1\7H\2\2\u00d1\u00d2\7T\2\2\u00d2\u00d3\7G\2\2"+
		"\u00d3\u00d4\7U\2\2\u00d4\u00d5\7J\2\2\u00d5(\3\2\2\2\u00d6\u00d7\7u\2"+
		"\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7v\2\2\u00d9*\3\2\2\2\u00da\u00db\7"+
		"U\2\2\u00db\u00dc\7G\2\2\u00dc\u00dd\7V\2\2\u00dd,\3\2\2\2\u00de\u00df"+
		"\7?\2\2\u00df.\3\2\2\2\u00e0\u00e1\7e\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3"+
		"\7p\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7e\2\2\u00e6"+
		"\u00e7\7v\2\2\u00e7\60\3\2\2\2\u00e8\u00e9\7E\2\2\u00e9\u00ea\7Q\2\2\u00ea"+
		"\u00eb\7P\2\2\u00eb\u00ec\7P\2\2\u00ec\u00ed\7G\2\2\u00ed\u00ee\7E\2\2"+
		"\u00ee\u00ef\7V\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7y\2\2\u00f1\u00f2\7"+
		"j\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7g\2\2\u00f5\64"+
		"\3\2\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7c\2\2\u00f9"+
		"\u00fa\7k\2\2\u00fa\u00fb\7p\2\2\u00fb\66\3\2\2\2\u00fc\u00fd\7V\2\2\u00fd"+
		"\u00fe\7T\2\2\u00fe\u00ff\7C\2\2\u00ff\u0100\7K\2\2\u0100\u0101\7P\2\2"+
		"\u01018\3\2\2\2\u0102\u0103\7t\2\2\u0103\u0104\7g\2\2\u0104\u0105\7i\2"+
		"\2\u0105\u0106\7k\2\2\u0106\u0107\7u\2\2\u0107\u0108\7v\2\2\u0108\u0109"+
		"\7g\2\2\u0109\u010a\7t\2\2\u010a:\3\2\2\2\u010b\u010c\7T\2\2\u010c\u010d"+
		"\7G\2\2\u010d\u010e\7I\2\2\u010e\u010f\7K\2\2\u010f\u0110\7U\2\2\u0110"+
		"\u0111\7V\2\2\u0111\u0112\7G\2\2\u0112\u0113\7T\2\2\u0113<\3\2\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u0116\7p\2\2\u0116\u0117\7T\2\2\u0117\u0118\7g\2\2"+
		"\u0118\u0119\7i\2\2\u0119\u011a\7k\2\2\u011a\u011b\7u\2\2\u011b\u011c"+
		"\7v\2\2\u011c\u011d\7g\2\2\u011d\u011e\7t\2\2\u011e>\3\2\2\2\u011f\u0120"+
		"\7W\2\2\u0120\u0121\7P\2\2\u0121\u0122\7T\2\2\u0122\u0123\7G\2\2\u0123"+
		"\u0124\7I\2\2\u0124\u0125\7K\2\2\u0125\u0126\7U\2\2\u0126\u0127\7V\2\2"+
		"\u0127\u0128\7G\2\2\u0128\u0129\7T\2\2\u0129@\3\2\2\2\u012a\u012b\7f\2"+
		"\2\u012b\u012c\7g\2\2\u012c\u012d\7h\2\2\u012d\u012e\7k\2\2\u012e\u012f"+
		"\7p\2\2\u012f\u0130\7g\2\2\u0130B\3\2\2\2\u0131\u0132\7F\2\2\u0132\u0133"+
		"\7G\2\2\u0133\u0134\7H\2\2\u0134\u0135\7K\2\2\u0135\u0136\7P\2\2\u0136"+
		"\u0137\7G\2\2\u0137D\3\2\2\2\u0138\u0139\7q\2\2\u0139\u013a\7x\2\2\u013a"+
		"\u013b\7g\2\2\u013b\u013c\7t\2\2\u013c\u013d\7y\2\2\u013d\u013e\7t\2\2"+
		"\u013e\u013f\7k\2\2\u013f\u0140\7v\2\2\u0140\u0141\7g\2\2\u0141F\3\2\2"+
		"\2\u0142\u0143\7c\2\2\u0143\u0144\7r\2\2\u0144\u0145\7r\2\2\u0145\u0146"+
		"\7g\2\2\u0146\u0147\7p\2\2\u0147\u0148\7f\2\2\u0148H\3\2\2\2\u0149\u014a"+
		"\7g\2\2\u014a\u014b\7t\2\2\u014b\u014c\7t\2\2\u014c\u014d\7q\2\2\u014d"+
		"\u014e\7t\2\2\u014e\u014f\7K\2\2\u014f\u0150\7h\2\2\u0150\u0151\7G\2\2"+
		"\u0151\u0152\7z\2\2\u0152\u0153\7k\2\2\u0153\u0154\7u\2\2\u0154\u0155"+
		"\7v\2\2\u0155\u0156\7u\2\2\u0156J\3\2\2\2\u0157\u0158\7k\2\2\u0158\u0159"+
		"\7i\2\2\u0159\u015a\7p\2\2\u015a\u015b\7q\2\2\u015b\u015c\7t\2\2\u015c"+
		"\u015d\7g\2\2\u015dL\3\2\2\2\u015e\u015f\7c\2\2\u015f\u0160\7p\2\2\u0160"+
		"\u0161\7f\2\2\u0161N\3\2\2\2\u0162\u0168\7)\2\2\u0163\u0167\n\2\2\2\u0164"+
		"\u0165\7^\2\2\u0165\u0167\13\2\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2"+
		"\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016b\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u0177\7)\2\2\u016c\u0172\7$\2"+
		"\2\u016d\u0171\n\3\2\2\u016e\u016f\7^\2\2\u016f\u0171\13\2\2\2\u0170\u016d"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0177\7$"+
		"\2\2\u0176\u0162\3\2\2\2\u0176\u016c\3\2\2\2\u0177P\3\2\2\2\u0178\u017c"+
		"\5W,\2\u0179\u017c\5U+\2\u017a\u017c\7a\2\2\u017b\u0178\3\2\2\2\u017b"+
		"\u0179\3\2\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017b\3\2"+
		"\2\2\u017d\u017e\3\2\2\2\u017eR\3\2\2\2\u017f\u0185\7b\2\2\u0180\u0184"+
		"\n\4\2\2\u0181\u0182\7b\2\2\u0182\u0184\7b\2\2\u0183\u0180\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7b\2\2\u0189"+
		"T\3\2\2\2\u018a\u018b\t\5\2\2\u018bV\3\2\2\2\u018c\u018d\t\6\2\2\u018d"+
		"X\3\2\2\2\u018e\u018f\7/\2\2\u018f\u0190\7/\2\2\u0190\u0194\3\2\2\2\u0191"+
		"\u0193\n\7\2\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197"+
		"\u0199\7\17\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3"+
		"\2\2\2\u019a\u019c\7\f\2\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019e\b-\2\2\u019eZ\3\2\2\2\u019f\u01a0\7\61\2\2"+
		"\u01a0\u01a1\7,\2\2\u01a1\u01a2\7,\2\2\u01a2\u01a3\7\61\2\2\u01a3\u01a4"+
		"\3\2\2\2\u01a4\u01a5\b.\2\2\u01a5\\\3\2\2\2\u01a6\u01a7\7\61\2\2\u01a7"+
		"\u01a8\7,\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ad\n\b\2\2\u01aa\u01ac\13\2"+
		"\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7,"+
		"\2\2\u01b1\u01b2\7\61\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\b/\2\2\u01b4"+
		"^\3\2\2\2\u01b5\u01b7\t\t\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2"+
		"\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bb"+
		"\b\60\2\2\u01bb`\3\2\2\2\u01bc\u01bd\13\2\2\2\u01bdb\3\2\2\2\21\2\u0166"+
		"\u0168\u0170\u0172\u0176\u017b\u017d\u0183\u0185\u0194\u0198\u019b\u01ad"+
		"\u01b8\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}