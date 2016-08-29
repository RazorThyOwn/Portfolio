public class EnigmaMachine
{
    private Rotor tIn, tMd, tOt;

    public EnigmaMachine()
    {
        Rotor ti = new Rotor("GNUAHOVBIPWCJQXDKRYELSZFMT");
        Rotor tm = new Rotor("EJOTYCHMRWAFKPUZDINSXBGLQV");
        Rotor to = new Rotor("BDFHJLNPRTVXZACEGIKMOQSUWY");
        tIn = ti;
        tMd = tm;
        tOt = to;
    }

    public String encodeLetter(String letter)
    {
        int index = tIn.getCharacterIndex(letter.toUpperCase());
        String outerLetter = tOt.getCharacterAt(index);
        index = tMd.getCharacterIndex(outerLetter);
        String returnLetter = tOt.getCharacterAt(index);
        tIn.rotate();
        return returnLetter;
    }

    public String decodeLetter(String letter)
    {
        int index = tOt.getCharacterIndex(letter);
        String middleLetter = tMd.getCharacterAt(index);
        index = tOt.getCharacterIndex(middleLetter);
        String returnLetter = tIn.getCharacterAt(index);
        tIn.rotate();
        return returnLetter;
    }

    public String encodeLetterGroup(String letterGroup)
    {
        String letter1 = letterGroup.substring(0,1);
        String letter2 = letterGroup.substring(1,2);
        String letter3 = letterGroup.substring(2,3);
        String letter4 = letterGroup.substring(3,4);
        String letter5 = letterGroup.substring(4,5);

        String invL1 = this.encodeLetter(letter1);
        String invL2 = this.encodeLetter(letter2);
        String invL3 = this.encodeLetter(letter3);
        String invL4 = this.encodeLetter(letter4);
        String invL5 = this.encodeLetter(letter5);

        return invL1+invL2+invL3+invL4+invL5;
    }

    public String decodeLetterGroup(String letterGroup)
    {
        String letter1 = letterGroup.substring(0,1);
        String letter2 = letterGroup.substring(1,2);
        String letter3 = letterGroup.substring(2,3);
        String letter4 = letterGroup.substring(3,4);
        String letter5 = letterGroup.substring(4,5);

        String invL1 = this.decodeLetter(letter1);
        String invL2 = this.decodeLetter(letter2);
        String invL3 = this.decodeLetter(letter3);
        String invL4 = this.decodeLetter(letter4);
        String invL5 = this.decodeLetter(letter5);

        return invL1+invL2+invL3+invL4+invL5;

    }

    public void setStartingvalues(String vals)
    {
        String p1 = vals.substring(0,1);
        String p2 = vals.substring(1,2);
        String p3 = vals.substring(2,3);

        tIn.setStartingLetter(p1);
        tMd.setStartingLetter(p2);
        tOt.setStartingLetter(p3);
    }
}