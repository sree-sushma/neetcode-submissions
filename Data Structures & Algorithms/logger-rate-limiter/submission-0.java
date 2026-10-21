class Logger {

    private HashMap<String,Integer> myDict;

    public Logger() {
        this.myDict = new HashMap<String,Integer>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!myDict.containsKey(message)) {
            myDict.put(message, timestamp);
            return true;
        }
        else {
            Integer oldTimeStamp = myDict.get(message);
            if(timestamp - oldTimeStamp >= 10) {
                myDict.put(message, timestamp);
                return true;
            }

        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
