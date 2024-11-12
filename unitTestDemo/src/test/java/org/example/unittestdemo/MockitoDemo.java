package org.example.unittestdemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExampleService {

    int add(int a, int b) {
        return a+b;
    }

}
@RunWith(MockitoJUnitRunner.class)
public class MockitoDemo {

    // 测试 spy
    @Test
    public void test_spy() {

        ExampleService spyExampleService = spy(new ExampleService());

        // 默认会走真实方法
        assertEquals(3, spyExampleService.add(1, 2));

        // 打桩后，不会走了
        when(spyExampleService.add(1, 2)).thenReturn(10);
        assertEquals(10, spyExampleService.add(1, 2));

        // 但是参数比匹配的调用，依然走真实方法
        assertEquals(3, spyExampleService.add(2, 1));

    }

    // 测试 mock
    @Test
    public void test_mock() {

        ExampleService mockExampleService = mock(ExampleService.class);

        // 这里mock没有对对应的方法桩，返回默认值，add返回是int的默认值0
        assertEquals(0, mockExampleService.add(1, 2));

    }


    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }


}
