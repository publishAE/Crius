
// Generated from g_xml.g4 by ANTLR 4.7.2


#include "g_xmlLexer.h"


using namespace antlr4;


g_xmlLexer::g_xmlLexer(CharStream *input) : Lexer(input) {
  _interpreter = new atn::LexerATNSimulator(this, _atn, _decisionToDFA, _sharedContextCache);
}

g_xmlLexer::~g_xmlLexer() {
  delete _interpreter;
}

std::string g_xmlLexer::getGrammarFileName() const {
  return "g_xml.g4";
}

const std::vector<std::string>& g_xmlLexer::getRuleNames() const {
  return _ruleNames;
}

const std::vector<std::string>& g_xmlLexer::getChannelNames() const {
  return _channelNames;
}

const std::vector<std::string>& g_xmlLexer::getModeNames() const {
  return _modeNames;
}

const std::vector<std::string>& g_xmlLexer::getTokenNames() const {
  return _tokenNames;
}

dfa::Vocabulary& g_xmlLexer::getVocabulary() const {
  return _vocabulary;
}

const std::vector<uint16_t> g_xmlLexer::getSerializedATN() const {
  return _serializedATN;
}

const atn::ATN& g_xmlLexer::getATN() const {
  return _atn;
}




// Static vars and initialization.
std::vector<dfa::DFA> g_xmlLexer::_decisionToDFA;
atn::PredictionContextCache g_xmlLexer::_sharedContextCache;

// We own the ATN which in turn owns the ATN states.
atn::ATN g_xmlLexer::_atn;
std::vector<uint16_t> g_xmlLexer::_serializedATN;

std::vector<std::string> g_xmlLexer::_ruleNames = {
  u8"T__0", u8"T__1", u8"T__2", u8"T__3", u8"ASTART", u8"AEND", u8"BSTART", 
  u8"BEND", u8"CSTART", u8"CEND", u8"DSTART", u8"DEND", u8"ESTART", u8"EEND", 
  u8"CHAR", u8"QUOTE"
};

std::vector<std::string> g_xmlLexer::_channelNames = {
  "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
};

std::vector<std::string> g_xmlLexer::_modeNames = {
  u8"DEFAULT_MODE"
};

std::vector<std::string> g_xmlLexer::_literalNames = {
  "", u8"'>'", u8"'/>'", u8"'='", u8"' '", u8"'<a'", u8"'</a>'", u8"'<b'", 
  u8"'</b>'", u8"'<c'", u8"'</c>'", u8"'<d'", u8"'</d>'", u8"'<e'", u8"'</e>'", 
  "", u8"'\u0022'"
};

std::vector<std::string> g_xmlLexer::_symbolicNames = {
  "", "", "", "", "", u8"ASTART", u8"AEND", u8"BSTART", u8"BEND", u8"CSTART", 
  u8"CEND", u8"DSTART", u8"DEND", u8"ESTART", u8"EEND", u8"CHAR", u8"QUOTE"
};

dfa::Vocabulary g_xmlLexer::_vocabulary(_literalNames, _symbolicNames);

std::vector<std::string> g_xmlLexer::_tokenNames;

g_xmlLexer::Initializer::Initializer() {
  // This code could be in a static initializer lambda, but VS doesn't allow access to private class members from there.
	for (size_t i = 0; i < _symbolicNames.size(); ++i) {
		std::string name = _vocabulary.getLiteralName(i);
		if (name.empty()) {
			name = _vocabulary.getSymbolicName(i);
		}

		if (name.empty()) {
			_tokenNames.push_back("<INVALID>");
		} else {
      _tokenNames.push_back(name);
    }
	}

  _serializedATN = {
    0x3, 0x608b, 0xa72a, 0x8133, 0xb9ed, 0x417c, 0x3be7, 0x7786, 0x5964, 
    0x2, 0x12, 0x58, 0x8, 0x1, 0x4, 0x2, 0x9, 0x2, 0x4, 0x3, 0x9, 0x3, 0x4, 
    0x4, 0x9, 0x4, 0x4, 0x5, 0x9, 0x5, 0x4, 0x6, 0x9, 0x6, 0x4, 0x7, 0x9, 
    0x7, 0x4, 0x8, 0x9, 0x8, 0x4, 0x9, 0x9, 0x9, 0x4, 0xa, 0x9, 0xa, 0x4, 
    0xb, 0x9, 0xb, 0x4, 0xc, 0x9, 0xc, 0x4, 0xd, 0x9, 0xd, 0x4, 0xe, 0x9, 
    0xe, 0x4, 0xf, 0x9, 0xf, 0x4, 0x10, 0x9, 0x10, 0x4, 0x11, 0x9, 0x11, 
    0x3, 0x2, 0x3, 0x2, 0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x4, 0x3, 0x4, 
    0x3, 0x5, 0x3, 0x5, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x7, 0x3, 0x7, 
    0x3, 0x7, 0x3, 0x7, 0x3, 0x7, 0x3, 0x8, 0x3, 0x8, 0x3, 0x8, 0x3, 0x9, 
    0x3, 0x9, 0x3, 0x9, 0x3, 0x9, 0x3, 0x9, 0x3, 0xa, 0x3, 0xa, 0x3, 0xa, 
    0x3, 0xb, 0x3, 0xb, 0x3, 0xb, 0x3, 0xb, 0x3, 0xb, 0x3, 0xc, 0x3, 0xc, 
    0x3, 0xc, 0x3, 0xd, 0x3, 0xd, 0x3, 0xd, 0x3, 0xd, 0x3, 0xd, 0x3, 0xe, 
    0x3, 0xe, 0x3, 0xe, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 
    0x3, 0x10, 0x3, 0x10, 0x3, 0x11, 0x3, 0x11, 0x2, 0x2, 0x12, 0x3, 0x3, 
    0x5, 0x4, 0x7, 0x5, 0x9, 0x6, 0xb, 0x7, 0xd, 0x8, 0xf, 0x9, 0x11, 0xa, 
    0x13, 0xb, 0x15, 0xc, 0x17, 0xd, 0x19, 0xe, 0x1b, 0xf, 0x1d, 0x10, 0x1f, 
    0x11, 0x21, 0x12, 0x3, 0x2, 0x3, 0x4, 0x2, 0x43, 0x5c, 0x63, 0x7c, 0x2, 
    0x57, 0x2, 0x3, 0x3, 0x2, 0x2, 0x2, 0x2, 0x5, 0x3, 0x2, 0x2, 0x2, 0x2, 
    0x7, 0x3, 0x2, 0x2, 0x2, 0x2, 0x9, 0x3, 0x2, 0x2, 0x2, 0x2, 0xb, 0x3, 
    0x2, 0x2, 0x2, 0x2, 0xd, 0x3, 0x2, 0x2, 0x2, 0x2, 0xf, 0x3, 0x2, 0x2, 
    0x2, 0x2, 0x11, 0x3, 0x2, 0x2, 0x2, 0x2, 0x13, 0x3, 0x2, 0x2, 0x2, 0x2, 
    0x15, 0x3, 0x2, 0x2, 0x2, 0x2, 0x17, 0x3, 0x2, 0x2, 0x2, 0x2, 0x19, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x1b, 0x3, 0x2, 0x2, 0x2, 0x2, 0x1d, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x1f, 0x3, 0x2, 0x2, 0x2, 0x2, 0x21, 0x3, 0x2, 0x2, 0x2, 
    0x3, 0x23, 0x3, 0x2, 0x2, 0x2, 0x5, 0x25, 0x3, 0x2, 0x2, 0x2, 0x7, 0x28, 
    0x3, 0x2, 0x2, 0x2, 0x9, 0x2a, 0x3, 0x2, 0x2, 0x2, 0xb, 0x2c, 0x3, 0x2, 
    0x2, 0x2, 0xd, 0x2f, 0x3, 0x2, 0x2, 0x2, 0xf, 0x34, 0x3, 0x2, 0x2, 0x2, 
    0x11, 0x37, 0x3, 0x2, 0x2, 0x2, 0x13, 0x3c, 0x3, 0x2, 0x2, 0x2, 0x15, 
    0x3f, 0x3, 0x2, 0x2, 0x2, 0x17, 0x44, 0x3, 0x2, 0x2, 0x2, 0x19, 0x47, 
    0x3, 0x2, 0x2, 0x2, 0x1b, 0x4c, 0x3, 0x2, 0x2, 0x2, 0x1d, 0x4f, 0x3, 
    0x2, 0x2, 0x2, 0x1f, 0x54, 0x3, 0x2, 0x2, 0x2, 0x21, 0x56, 0x3, 0x2, 
    0x2, 0x2, 0x23, 0x24, 0x7, 0x40, 0x2, 0x2, 0x24, 0x4, 0x3, 0x2, 0x2, 
    0x2, 0x25, 0x26, 0x7, 0x31, 0x2, 0x2, 0x26, 0x27, 0x7, 0x40, 0x2, 0x2, 
    0x27, 0x6, 0x3, 0x2, 0x2, 0x2, 0x28, 0x29, 0x7, 0x3f, 0x2, 0x2, 0x29, 
    0x8, 0x3, 0x2, 0x2, 0x2, 0x2a, 0x2b, 0x7, 0x22, 0x2, 0x2, 0x2b, 0xa, 
    0x3, 0x2, 0x2, 0x2, 0x2c, 0x2d, 0x7, 0x3e, 0x2, 0x2, 0x2d, 0x2e, 0x7, 
    0x63, 0x2, 0x2, 0x2e, 0xc, 0x3, 0x2, 0x2, 0x2, 0x2f, 0x30, 0x7, 0x3e, 
    0x2, 0x2, 0x30, 0x31, 0x7, 0x31, 0x2, 0x2, 0x31, 0x32, 0x7, 0x63, 0x2, 
    0x2, 0x32, 0x33, 0x7, 0x40, 0x2, 0x2, 0x33, 0xe, 0x3, 0x2, 0x2, 0x2, 
    0x34, 0x35, 0x7, 0x3e, 0x2, 0x2, 0x35, 0x36, 0x7, 0x64, 0x2, 0x2, 0x36, 
    0x10, 0x3, 0x2, 0x2, 0x2, 0x37, 0x38, 0x7, 0x3e, 0x2, 0x2, 0x38, 0x39, 
    0x7, 0x31, 0x2, 0x2, 0x39, 0x3a, 0x7, 0x64, 0x2, 0x2, 0x3a, 0x3b, 0x7, 
    0x40, 0x2, 0x2, 0x3b, 0x12, 0x3, 0x2, 0x2, 0x2, 0x3c, 0x3d, 0x7, 0x3e, 
    0x2, 0x2, 0x3d, 0x3e, 0x7, 0x65, 0x2, 0x2, 0x3e, 0x14, 0x3, 0x2, 0x2, 
    0x2, 0x3f, 0x40, 0x7, 0x3e, 0x2, 0x2, 0x40, 0x41, 0x7, 0x31, 0x2, 0x2, 
    0x41, 0x42, 0x7, 0x65, 0x2, 0x2, 0x42, 0x43, 0x7, 0x40, 0x2, 0x2, 0x43, 
    0x16, 0x3, 0x2, 0x2, 0x2, 0x44, 0x45, 0x7, 0x3e, 0x2, 0x2, 0x45, 0x46, 
    0x7, 0x66, 0x2, 0x2, 0x46, 0x18, 0x3, 0x2, 0x2, 0x2, 0x47, 0x48, 0x7, 
    0x3e, 0x2, 0x2, 0x48, 0x49, 0x7, 0x31, 0x2, 0x2, 0x49, 0x4a, 0x7, 0x66, 
    0x2, 0x2, 0x4a, 0x4b, 0x7, 0x40, 0x2, 0x2, 0x4b, 0x1a, 0x3, 0x2, 0x2, 
    0x2, 0x4c, 0x4d, 0x7, 0x3e, 0x2, 0x2, 0x4d, 0x4e, 0x7, 0x67, 0x2, 0x2, 
    0x4e, 0x1c, 0x3, 0x2, 0x2, 0x2, 0x4f, 0x50, 0x7, 0x3e, 0x2, 0x2, 0x50, 
    0x51, 0x7, 0x31, 0x2, 0x2, 0x51, 0x52, 0x7, 0x67, 0x2, 0x2, 0x52, 0x53, 
    0x7, 0x40, 0x2, 0x2, 0x53, 0x1e, 0x3, 0x2, 0x2, 0x2, 0x54, 0x55, 0x9, 
    0x2, 0x2, 0x2, 0x55, 0x20, 0x3, 0x2, 0x2, 0x2, 0x56, 0x57, 0x7, 0x24, 
    0x2, 0x2, 0x57, 0x22, 0x3, 0x2, 0x2, 0x2, 0x3, 0x2, 0x2, 
  };

  atn::ATNDeserializer deserializer;
  _atn = deserializer.deserialize(_serializedATN);

  size_t count = _atn.getNumberOfDecisions();
  _decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    _decisionToDFA.emplace_back(_atn.getDecisionState(i), i);
  }
}

g_xmlLexer::Initializer g_xmlLexer::_init;
