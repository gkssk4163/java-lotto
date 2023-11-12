package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_경우() {
        assertThatThrownBy(() -> {
            new Operator("!");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 더하기인_경우() {
        Operator op = new Operator("+");
        assertThat(op.isAdd()).isTrue();
    }

    @Test
    void 빼기인_경우() {
        Operator op = new Operator("-");
        assertThat(op.isSubtract()).isTrue();
    }

    @Test
    void 곱하기인_경우() {
        Operator op = new Operator("*");
        assertThat(op.isMultiply()).isTrue();
    }

    @Test
    void 나누기인_경우() {
        Operator op = new Operator("/");
        assertThat(op.isDivide()).isTrue();
    }

}