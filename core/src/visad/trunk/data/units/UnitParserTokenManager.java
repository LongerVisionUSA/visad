/*
VisAD system for interactive analysis and visualization of numerical
data.  Copyright (C) 1996 - 2001 Bill Hibbard, Curtis Rueden, Tom
Rink, Dave Glowacki, Steve Emmerson, Tom Whittaker, Don Murray, and
Tommy Jasmin.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public
License as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Library General Public License for more details.

You should have received a copy of the GNU Library General Public
License along with this library; if not, write to the Free
Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
MA 02111-1307, USA
*/

/* Generated By:JavaCC: Do not edit this line. UnitParserTokenManager.java */
package visad.data.units;

public class UnitParserTokenManager implements UnitParserConstants
{
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 25);
      case 41:
         return jjStopAtPos(0, 26);
      case 42:
         return jjStopAtPos(0, 24);
      case 46:
         return jjStartNfaWithStates_0(0, 23, 1);
      case 94:
         return jjStopAtPos(0, 27);
      default :
         return jjMoveNfa_0(21, 0);
   }
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 67;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 21:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 4)
                        kind = 4;
                     jjCheckNAddStates(0, 9);
                  }
                  else if ((0x100002600L & l) != 0L)
                  {
                     if (kind > 8)
                        kind = 8;
                     jjCheckNAddStates(10, 17);
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(18, 24);
                  else if (curChar == 37)
                  {
                     if (kind > 14)
                        kind = 14;
                  }
                  else if (curChar == 47)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjCheckNAdd(17);
                  }
                  else if (curChar == 46)
                     jjCheckNAdd(1);
                  if ((0x3000000000000L & l) != 0L)
                     jjCheckNAdd(26);
                  else if (curChar == 50)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 0:
                  if (curChar == 46)
                     jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 3:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(4);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(4);
                  break;
               case 6:
                  if ((0x100002600L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 16:
                  if (curChar != 47)
                     break;
                  kind = 12;
                  jjCheckNAdd(17);
                  break;
               case 17:
                  if ((0x100002600L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(17);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjAddStates(25, 26);
                  break;
               case 25:
                  if ((0x3000000000000L & l) != 0L)
                     jjCheckNAdd(26);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(27);
                  break;
               case 27:
                  if (curChar == 58)
                     jjCheckNAddTwoStates(28, 29);
                  break;
               case 28:
                  if ((0x3f000000000000L & l) != 0L)
                     jjCheckNAdd(29);
                  break;
               case 29:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjstateSet[jjnewStateCnt++] = 30;
                  break;
               case 30:
                  if (curChar == 58)
                     jjCheckNAddStates(27, 29);
                  break;
               case 31:
                  if ((0x3f000000000000L & l) != 0L)
                     jjCheckNAdd(32);
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(33);
                  break;
               case 33:
                  if (curChar != 46)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(34);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(34);
                  break;
               case 35:
                  if (curChar == 54)
                     jjstateSet[jjnewStateCnt++] = 36;
                  break;
               case 36:
                  if (curChar != 48)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(33);
                  break;
               case 37:
                  if (curChar == 50)
                     jjstateSet[jjnewStateCnt++] = 38;
                  break;
               case 38:
                  if ((0xf000000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  jjCheckNAdd(27);
                  break;
               case 39:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddStates(18, 24);
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 4)
                     kind = 4;
                  jjCheckNAdd(40);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(41, 0);
                  break;
               case 42:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(42, 43);
                  break;
               case 43:
                  if (curChar == 46)
                     jjCheckNAddTwoStates(44, 2);
                  break;
               case 44:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(44, 2);
                  break;
               case 45:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(45, 46);
                  break;
               case 47:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(48);
                  break;
               case 48:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(48);
                  break;
               case 49:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 4)
                     kind = 4;
                  jjCheckNAddStates(0, 9);
                  break;
               case 50:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(50, 51);
                  break;
               case 51:
                  if (curChar == 45)
                     jjCheckNAddStates(30, 32);
                  break;
               case 52:
                  if (curChar == 48)
                     jjCheckNAdd(53);
                  break;
               case 53:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAdd(54);
                  break;
               case 54:
                  if (curChar == 45)
                     jjCheckNAddStates(33, 36);
                  break;
               case 55:
                  if (curChar == 48)
                     jjCheckNAdd(56);
                  break;
               case 56:
                  if ((0x3fe000000000000L & l) != 0L && kind > 18)
                     kind = 18;
                  break;
               case 57:
                  if ((0x6000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 58:
                  if ((0x3ff000000000000L & l) != 0L && kind > 18)
                     kind = 18;
                  break;
               case 59:
                  if (curChar == 51)
                     jjstateSet[jjnewStateCnt++] = 60;
                  break;
               case 60:
                  if ((0x3000000000000L & l) != 0L && kind > 18)
                     kind = 18;
                  break;
               case 61:
                  if (curChar == 49)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 62:
                  if ((0x7000000000000L & l) != 0L)
                     jjCheckNAdd(54);
                  break;
               case 63:
                  if ((0x100002600L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAddStates(10, 17);
                  break;
               case 64:
                  if ((0x100002600L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(64);
                  break;
               case 65:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddStates(37, 40);
                  break;
               case 66:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 21:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 14)
                        kind = 14;
                     jjCheckNAddTwoStates(22, 23);
                  }
                  else if (curChar == 64)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(6);
                  }
                  if ((0x1000000010000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  else if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 13;
                  else if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 2:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(44, 45);
                  break;
               case 5:
                  if (curChar != 64)
                     break;
                  kind = 11;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 8:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 9:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 10:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 11:
                  if ((0x2000000020L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(6);
                  break;
               case 12:
                  if ((0x4000000040L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 13:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 14:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 15:
                  if ((0x200000002000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(6);
                  break;
               case 18:
                  if ((0x1000000010000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 19:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 20:
                  if ((0x4000000040000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 22:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAddTwoStates(22, 23);
                  break;
               case 24:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  jjCheckNAddTwoStates(23, 24);
                  break;
               case 46:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(46, 47);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 67 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   40, 41, 0, 42, 43, 45, 46, 50, 51, 27, 64, 65, 5, 7, 12, 66, 
   16, 18, 40, 41, 42, 45, 25, 26, 37, 23, 24, 31, 32, 35, 52, 53, 
   61, 55, 56, 57, 59, 65, 5, 7, 12, 66, 16, 18, 3, 4, 47, 48, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, "\56", "\52", "\50", 
"\51", "\136", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
private ASCII_CharStream input_stream;
private final int[] jjrounds = new int[67];
private final int[] jjstateSet = new int[134];
protected char curChar;
public UnitParserTokenManager(ASCII_CharStream stream)
{
   if (ASCII_CharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public UnitParserTokenManager(ASCII_CharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(ASCII_CharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 67; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(ASCII_CharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

private final Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public final Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
         matchedToken = jjFillToken();
         return matchedToken;
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
