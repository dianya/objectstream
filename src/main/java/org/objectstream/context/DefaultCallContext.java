/**
 * Copyright 2013 Emeka Mosanya, all rights reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.objectstream.context;

import org.objectstream.instrumentation.MethodHandler;
import org.objectstream.value.Value;

import java.util.Stack;

public abstract class DefaultCallContext implements CallContext {
    private final Stack<MethodHandler> methodHandlerStack = new Stack<>();
    private Value lastValue;
    private final Stack<Value> valueStack = new Stack<>();

    @Override
    public void reset() {
        methodHandlerStack.clear();
        valueStack.clear();
        lastValue = null;
    }

    @Override
    public void setLastValue(Value lastValue) {
        this.lastValue = lastValue;
    }

    @Override
    public Value getLastValue() {
        return lastValue;
    }

    @Override
    public Stack<MethodHandler> getMethodHandlerStack() {
        return methodHandlerStack;
    }

    @Override
    public Stack<Value> getValueStack() {
        return valueStack;
    }
}
