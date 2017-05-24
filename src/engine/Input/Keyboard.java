package engine.Input;

import java.util.ArrayList;
import java.util.HashMap;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.*;

public class Keyboard {
	public static HashMap<Integer,Boolean> keys = new HashMap<Integer,Boolean>();
	public enum Keys {
		ZERO(GLFW_KEY_0),ONE(GLFW_KEY_1),TWO(GLFW_KEY_2),THREE(GLFW_KEY_3),FOUR(GLFW_KEY_4),FIVE(GLFW_KEY_5),SIX(GLFW_KEY_6),SEVEN(GLFW_KEY_7),EIGHT(GLFW_KEY_8),NINE(GLFW_KEY_9),UNKNOWN(GLFW_KEY_UNKNOWN),
		SPACE(GLFW_KEY_SPACE),
		APOSTROPHE(GLFW_KEY_APOSTROPHE),
		COMMA(GLFW_KEY_COMMA),
		MINUS(GLFW_KEY_MINUS),
		PERIOD(GLFW_KEY_PERIOD),
		SLASH(GLFW_KEY_SLASH),
		SEMICOLON(GLFW_KEY_SEMICOLON),
		EQUAL(GLFW_KEY_EQUAL),
		A(GLFW_KEY_A),
		B(GLFW_KEY_B),
		C(GLFW_KEY_C),
		D(GLFW_KEY_D),
		E(GLFW_KEY_E),
		F(GLFW_KEY_F),
		G(GLFW_KEY_G),
		H(GLFW_KEY_H),
		I(GLFW_KEY_I),
		J(GLFW_KEY_J),
		K(GLFW_KEY_K),
		L(GLFW_KEY_L),
		M(GLFW_KEY_M),
		N(GLFW_KEY_N),
		O(GLFW_KEY_O),
		P(GLFW_KEY_P),
		Q(GLFW_KEY_Q),
		R(GLFW_KEY_R),
		S(GLFW_KEY_S),
		T(GLFW_KEY_T),
		U(GLFW_KEY_U),
		V(GLFW_KEY_V),
		W(GLFW_KEY_W),
		X(GLFW_KEY_X),
		Y(GLFW_KEY_Y),
		Z(GLFW_KEY_Z),
		LEFT_BRACKET(GLFW_KEY_LEFT_BRACKET),
		BACKSLASH(GLFW_KEY_BACKSLASH),
		RIGHT_BRACKET(GLFW_KEY_RIGHT_BRACKET),
		GRAVE_ACCENT(GLFW_KEY_GRAVE_ACCENT),
		WORLD1(GLFW_KEY_WORLD_1),
		WORLD2(GLFW_KEY_WORLD_2),
		ESCAPE(GLFW_KEY_ESCAPE),
		ENTER(GLFW_KEY_ENTER),
		TAB(GLFW_KEY_TAB),
		BACKSPACE(GLFW_KEY_BACKSPACE),
		INSERT(GLFW_KEY_INSERT),
		DELETE(GLFW_KEY_DELETE),
		RIGHT(GLFW_KEY_RIGHT),
		LEFT(GLFW_KEY_LEFT),
		DOWN(GLFW_KEY_DOWN),
		UP(GLFW_KEY_UP),
		PAGE_UP(GLFW_KEY_PAGE_UP),
		PAGE_DOWN(GLFW_KEY_PAGE_DOWN),
		HOME(GLFW_KEY_HOME),
		END(GLFW_KEY_END),
		CAPS_LOCK(GLFW_KEY_CAPS_LOCK),
		SCROLL_LOCK(GLFW_KEY_SCROLL_LOCK),
		NUM_LOCK(GLFW_KEY_NUM_LOCK),
		PRINT_SCREEN(GLFW_KEY_PRINT_SCREEN),
		PAUSE(GLFW_KEY_PAUSE),
		F1(GLFW_KEY_F1),
		F2(GLFW_KEY_F2),
		F3(GLFW_KEY_F3),
		F4(GLFW_KEY_F4),
		F5(GLFW_KEY_F5),
		F6(GLFW_KEY_F6),
		F7(GLFW_KEY_F7),
		F8(GLFW_KEY_F8),
		F9(GLFW_KEY_F9),
		F10(GLFW_KEY_F10),
		F11(GLFW_KEY_F11),
		F12(GLFW_KEY_F12),
		F13(GLFW_KEY_F13),
		F14(GLFW_KEY_F14),
		F15(GLFW_KEY_F15),
		F16(GLFW_KEY_F16),
		F17(GLFW_KEY_F17),
		F18(GLFW_KEY_F18),
		F19(GLFW_KEY_F19),
		F20(GLFW_KEY_F20),
		F21(GLFW_KEY_F21),
		F22(GLFW_KEY_F22),
		F23(GLFW_KEY_F23),
		F24(GLFW_KEY_F24),
		F25(GLFW_KEY_F25),
		KP_0(GLFW_KEY_KP_0),
		KP_1(GLFW_KEY_KP_1),
		KP_2(GLFW_KEY_KP_2),
		KP_3(GLFW_KEY_KP_3),
		KP_4(GLFW_KEY_KP_4),
		KP_5(GLFW_KEY_KP_5),
		KP_6(GLFW_KEY_KP_6),
		KP_7(GLFW_KEY_KP_7),
		KP_8(GLFW_KEY_KP_8),
		KP_9(GLFW_KEY_KP_9),
		KP_DECIMAL(GLFW_KEY_KP_DECIMAL),
		KP_DIVIDE(GLFW_KEY_KP_DIVIDE),
		KP_MULTIPLY(GLFW_KEY_KP_MULTIPLY),
		KP_SUBTRACT(GLFW_KEY_KP_SUBTRACT),
		KP_ADD(GLFW_KEY_KP_ADD),
		KP_ENTER(GLFW_KEY_KP_ENTER),
		KP_EQUAL(GLFW_KEY_KP_EQUAL),
		LEFT_SHIFT(GLFW_KEY_LEFT_SHIFT),
		LEFT_CONTROL(GLFW_KEY_LEFT_CONTROL),
		LEFT_ALT(GLFW_KEY_LEFT_ALT),
		LEFT_SUPER(GLFW_KEY_LEFT_SUPER),
		RIGHT_SHIFT(GLFW_KEY_RIGHT_SHIFT),
		RIGHT_CONTROL(GLFW_KEY_RIGHT_CONTROL),
		RIGHT_ALT(GLFW_KEY_RIGHT_ALT),
		RIGHT_SUPER(GLFW_KEY_RIGHT_SUPER),
		MENU(GLFW_KEY_MENU);
		public final int lable;
		private Keys(int value) {
			lable  = value;
		}
		private static HashMap<Character,Keys> keys = new HashMap<Character,Keys>();
		static {
			keys.put('a', A);
			keys.put('b', B);
			keys.put('c', C);
			keys.put('d', D);
			keys.put('e', E);
			keys.put('f', F);
			keys.put('g', G);
			keys.put('h', H);
			keys.put('i', I);
			keys.put('j', J);
			keys.put('k', K);
			keys.put('l', L);
			keys.put('m', M);
			keys.put('n', N);
			keys.put('o', O);
			keys.put('p', P);
			keys.put('q', Q);
			keys.put('r', R);
			keys.put('s', S);
			keys.put('t', T);
			keys.put('u', U);
			keys.put('v', V);
			keys.put('w', W);
			keys.put('x', X);
			keys.put('y', Y);
			keys.put('z', Z);

			keys.put('0', ZERO);
			keys.put('1', ONE);
			keys.put('2', TWO);
			keys.put('3', THREE);
			keys.put('4', FOUR);
			keys.put('5', FIVE);
			keys.put('6', SIX);
			keys.put('7', SEVEN);
			keys.put('8', EIGHT);
			keys.put('9', NINE);
			
			keys.put(' ', SPACE);
			keys.put('\'', APOSTROPHE);
			keys.put(',', COMMA);
			keys.put('.', PERIOD);
			keys.put('-', MINUS);
			keys.put(';', SEMICOLON);
			keys.put('=', EQUAL);
			keys.put('[', LEFT_BRACKET);
			keys.put(']', RIGHT_BRACKET);
			keys.put('`', GRAVE_ACCENT);
			keys.put('	', TAB);
		}
		public static Keys get(char i) {
			return keys.get(i);
		}
	}
	public long windowID = -1;
	private static ArrayList<Long> initializedWindows = new ArrayList<Long>();
	private static ArrayList<Keyboard> keyboards = new ArrayList<Keyboard>();
	private static boolean alt, control, shift, cmd;
	public boolean getAlt() {return alt;};
	public boolean getControl() {return control;};
	public boolean getShift() {return shift;};
	public boolean getSuper() {return cmd;};
	public Keyboard() {
		keyboards.add(this);
	}

	public static void registerWindow(long window) {
		if (initializedWindows.indexOf(window) == -1) {
			initializedWindows.add(window);
			glfwSetKeyCallback(window, new GLFWKeyCallback() {
				@Override public void invoke(long window, int key, int scancode, int action, int mods) {
					shift = (mods & 1) == 1;
					control = (mods & 2) == 1;
					alt = (mods & 4) == 1;
					cmd = (mods & 8) == 1;
					keys.put(key, action == GLFW_PRESS);

					for (int i = 0; i < keyboards.size(); i++) {
						if (keyboards.get(i).windowID == window || keyboards.get(i).windowID == -1) {
							if (action == GLFW_PRESS) keyboards.get(i).pressed(key);
							if (action == GLFW_RELEASE) keyboards.get(i).released(key);
						}
					}
				}
			});

			glfwSetCharModsCallback(window, new GLFWCharModsCallback() {
				@Override public void invoke(long window, int key, int mods) {
					shift = (mods & 1) == 1;
					control = (mods & 2) == 1;
					alt = (mods & 4) == 1;
					cmd = (mods & 8) == 1;
					for (int i = 0; i < keyboards.size(); i++) {
						if (keyboards.get(i).windowID == window || keyboards.get(i).windowID == -1) {
							keyboards.get(i).typed((char)key);
						}
					}
				}
			});
		}
	}

	public void pressed(int key) {

	}
	public void released(int key) {

	}
	public void typed(char key) {

	}
	public boolean getKey(Keys key) {
		for (int i = 0; i < initializedWindows.size(); i++) {
			if (glfwGetKey(initializedWindows.get(i), key.lable) == 1) {
				return true;
			}
		}
		return false;
	}
	public String getKeyName(Keys key) {
		return glfwGetKeyName(key.lable, 0);
	}
}