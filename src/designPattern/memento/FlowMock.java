package designPattern.memento;

/**
 * @author Kevin
 * @description
 * @date 2017/2/23
 */
public class FlowMock {
    // 流程名称，不需要外部存储的状态数据
    private String flowName;
    // 中间结果，需要外部存储的状态数据
    private String tempState;
    // 中间结果，需要外部存储的状态数据
    private int tempResult;

    public FlowMock(String flowName) {
        this.flowName = flowName;
    }

    public void runPhaseOne() {
        this.tempResult = 3;
        this.tempState = "PhaseOne";
    }

    public void schema1() {
        this.tempState += ",Schema1";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 11;
    }

    public void schema2() {
        this.tempState += ",Schema2";
        System.out.println(this.tempState + " : now run " + tempResult);
        this.tempResult += 22;
    }

    public Memento createMemento(){
        return new MementoImpl(this.tempState,this.tempResult);
    }

    public void setMemento(Memento memento){
        MementoImpl mementoImpl = ((MementoImpl) memento);
        this.tempState = mementoImpl.getTempState();
        this.tempResult = mementoImpl.getTempResult();
    }

    private class MementoImpl implements Memento {
        // 中间结果
        private String tempState;
        // 中间结果
        private int tempResult;

        public MementoImpl(String tempState, int tempResult) {
            this.tempState = tempState;
            this.tempResult = tempResult;
        }

        public String getTempState() {
            return tempState;
        }

        public void setTempState(String tempState) {
            this.tempState = tempState;
        }

        public int getTempResult() {
            return tempResult;
        }

        public void setTempResult(int tempResult) {
            this.tempResult = tempResult;
        }
    }
}
