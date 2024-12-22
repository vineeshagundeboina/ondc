function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _classCallCheck(t, e) {
	if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
}

function _possibleConstructorReturn(t, e) {
	if (!t) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
	return !e || "object" != typeof e && "function" != typeof e ? t : e
}

function _inherits(t, e) {
	if ("function" != typeof e && null !== e) throw new TypeError("Super expression must either be null or a function, not " + typeof e);
	t.prototype = Object.create(e && e.prototype, {
		constructor: {
			value: t,
			enumerable: !1,
			writable: !0,
			configurable: !0
		}
	}), e && (Object.setPrototypeOf ? Object.setPrototypeOf(t, e) : t.__proto__ = e)
}

function alert_box(t, e) {
	var n = "danger" == t ? "fa-exclamation-triangle" : "fa-check";
	$(".modal-header").addClass("bg-" + t), $(".modal-body").addClass("text-" + t), $(".fa").addClass(n), $(".modal-data").html(e), $("#alert-box").modal("toggle")
}! function (t, e) {
	"object" == typeof module && "object" == typeof module.exports ? module.exports = t.document ? e(t, !0) : function (t) {
		if (!t.document) throw new Error("jQuery requires a window with a document");
		return e(t)
	} : e(t)
}("undefined" != typeof window ? window : this, function (t, e) {
	function n(t) {
		var e = !!t && "length" in t && t.length,
			n = ft.type(t);
		return "function" !== n && !ft.isWindow(t) && ("array" === n || 0 === e || "number" == typeof e && e > 0 && e - 1 in t)
	}

	function i(t, e, n) {
		if (ft.isFunction(e)) return ft.grep(t, function (t, i) {
			return !!e.call(t, i, t) !== n
		});
		if (e.nodeType) return ft.grep(t, function (t) {
			return t === e !== n
		});
		if ("string" == typeof e) {
			if (wt.test(e)) return ft.filter(e, t, n);
			e = ft.filter(e, t)
		}
		return ft.grep(t, function (t) {
			return ft.inArray(t, e) > -1 !== n
		})
	}

	function r(t, e) {
		do {
			t = t[e]
		} while (t && 1 !== t.nodeType);
		return t
	}

	function o(t) {
		var e = {};
		return ft.each(t.match(At) || [], function (t, n) {
			e[n] = !0
		}), e
	}

	function a() {
		it.addEventListener ? (it.removeEventListener("DOMContentLoaded", s), t.removeEventListener("load", s)) : (it.detachEvent("onreadystatechange", s), t.detachEvent("onload", s))
	}

	function s() {
		(it.addEventListener || "load" === t.event.type || "complete" === it.readyState) && (a(), ft.ready())
	}

	function l(t, e, n) {
		if (n === undefined && 1 === t.nodeType) {
			var i = "data-" + e.replace(Pt, "-$1").toLowerCase();
			if ("string" == typeof (n = t.getAttribute(i))) {
				try {
					n = "true" === n || "false" !== n && ("null" === n ? null : +n + "" === n ? +n : It.test(n) ? ft.parseJSON(n) : n)
				} catch (t) {}
				ft.data(t, e, n)
			} else n = undefined
		}
		return n
	}

	function u(t) {
		var e;
		for (e in t)
			if (("data" !== e || !ft.isEmptyObject(t[e])) && "toJSON" !== e) return !1;
		return !0
	}

	function c(t, e, n, i) {
		if (Nt(t)) {
			var r, o, a = ft.expando,
				s = t.nodeType,
				l = s ? ft.cache : t,
				u = s ? t[a] : t[a] && a;
			if (u && l[u] && (i || l[u].data) || n !== undefined || "string" != typeof e) return u || (u = s ? t[a] = nt.pop() || ft.guid++ : a), l[u] || (l[u] = s ? {} : {
				toJSON: ft.noop
			}), "object" != typeof e && "function" != typeof e || (i ? l[u] = ft.extend(l[u], e) : l[u].data = ft.extend(l[u].data, e)), o = l[u], i || (o.data || (o.data = {}), o = o.data), n !== undefined && (o[ft.camelCase(e)] = n), "string" == typeof e ? null == (r = o[e]) && (r = o[ft.camelCase(e)]) : r = o, r
		}
	}

	function p(t, e, n) {
		if (Nt(t)) {
			var i, r, o = t.nodeType,
				a = o ? ft.cache : t,
				s = o ? t[ft.expando] : ft.expando;
			if (a[s]) {
				if (e && (i = n ? a[s] : a[s].data)) {
					ft.isArray(e) ? e = e.concat(ft.map(e, ft.camelCase)) : e in i ? e = [e] : (e = ft.camelCase(e), e = e in i ? [e] : e.split(" ")), r = e.length;
					for (; r--;) delete i[e[r]];
					if (n ? !u(i) : !ft.isEmptyObject(i)) return
				}(n || (delete a[s].data, u(a[s]))) && (o ? ft.cleanData([t], !0) : pt.deleteExpando || a != a.window ? delete a[s] : a[s] = undefined)
			}
		}
	}

	function d(t, e, n, i) {
		var r, o = 1,
			a = 20,
			s = i ? function () {
				return i.cur()
			} : function () {
				return ft.css(t, e, "")
			},
			l = s(),
			u = n && n[3] || (ft.cssNumber[e] ? "" : "px"),
			c = (ft.cssNumber[e] || "px" !== u && +l) && Rt.exec(ft.css(t, e));
		if (c && c[3] !== u) {
			u = u || c[3], n = n || [], c = +l || 1;
			do {
				o = o || ".5", c /= o, ft.style(t, e, c + u)
			} while (o !== (o = s() / l) && 1 !== o && --a)
		}
		return n && (c = +c || +l || 0, r = n[1] ? c + (n[1] + 1) * n[2] : +n[2], i && (i.unit = u, i.start = c, i.end = r)), r
	}

	function f(t) {
		var e = Ut.split("|"),
			n = t.createDocumentFragment();
		if (n.createElement)
			for (; e.length;) n.createElement(e.pop());
		return n
	}

	function h(t, e) {
		var n, i, r = 0,
			o = "undefined" != typeof t.getElementsByTagName ? t.getElementsByTagName(e || "*") : "undefined" != typeof t.querySelectorAll ? t.querySelectorAll(e || "*") : undefined;
		if (!o)
			for (o = [], n = t.childNodes || t; null != (i = n[r]); r++) !e || ft.nodeName(i, e) ? o.push(i) : ft.merge(o, h(i, e));
		return e === undefined || e && ft.nodeName(t, e) ? ft.merge([t], o) : o
	}

	function m(t, e) {
		for (var n, i = 0; null != (n = t[i]); i++) ft._data(n, "globalEval", !e || ft._data(e[i], "globalEval"))
	}

	function g(t) {
		Ft.test(t.type) && (t.defaultChecked = t.checked)
	}

	function v(t, e, n, i, r) {
		for (var o, a, s, l, u, c, p, d = t.length, v = f(e), y = [], b = 0; b < d; b++)
			if ((a = t[b]) || 0 === a)
				if ("object" === ft.type(a)) ft.merge(y, a.nodeType ? [a] : a);
				else if (Gt.test(a)) {
			for (l = l || v.appendChild(e.createElement("div")), u = (qt.exec(a) || ["", ""])[1].toLowerCase(), p = Vt[u] || Vt._default, l.innerHTML = p[1] + ft.htmlPrefilter(a) + p[2], o = p[0]; o--;) l = l.lastChild;
			if (!pt.leadingWhitespace && Wt.test(a) && y.push(e.createTextNode(Wt.exec(a)[0])), !pt.tbody)
				for (a = "table" !== u || $t.test(a) ? "<table>" !== p[1] || $t.test(a) ? 0 : l : l.firstChild, o = a && a.childNodes.length; o--;) ft.nodeName(c = a.childNodes[o], "tbody") && !c.childNodes.length && a.removeChild(c);
			for (ft.merge(y, l.childNodes), l.textContent = ""; l.firstChild;) l.removeChild(l.firstChild);
			l = v.lastChild
		} else y.push(e.createTextNode(a));
		for (l && v.removeChild(l), pt.appendChecked || ft.grep(h(y, "input"), g), b = 0; a = y[b++];)
			if (i && ft.inArray(a, i) > -1) r && r.push(a);
			else if (s = ft.contains(a.ownerDocument, a), l = h(v.appendChild(a), "script"), s && m(l), n)
			for (o = 0; a = l[o++];) Bt.test(a.type || "") && n.push(a);
		return l = null, v
	}

	function y() {
		return !0
	}

	function b() {
		return !1
	}

	function _() {
		try {
			return it.activeElement
		} catch (t) {}
	}

	function E(t, e, n, i, r, o) {
		var a, s;
		if ("object" == typeof e) {
			"string" != typeof n && (i = i || n, n = undefined);
			for (s in e) E(t, s, n, i, e[s], o);
			return t
		}
		if (null == i && null == r ? (r = n, i = n = undefined) : null == r && ("string" == typeof n ? (r = i, i = undefined) : (r = i, i = n, n = undefined)), !1 === r) r = b;
		else if (!r) return t;
		return 1 === o && (a = r, r = function (t) {
			return ft().off(t), a.apply(this, arguments)
		}, r.guid = a.guid || (a.guid = ft.guid++)), t.each(function () {
			ft.event.add(this, e, r, i, n)
		})
	}

	function k(t, e) {
		return ft.nodeName(t, "table") && ft.nodeName(11 !== e.nodeType ? e : e.firstChild, "tr") ? t.getElementsByTagName("tbody")[0] || t.appendChild(t.ownerDocument.createElement("tbody")) : t
	}

	function w(t) {
		return t.type = (null !== ft.find.attr(t, "type")) + "/" + t.type, t
	}

	function C(t) {
		var e = ie.exec(t.type);
		return e ? t.type = e[1] : t.removeAttribute("type"), t
	}

	function x(t, e) {
		if (1 === e.nodeType && ft.hasData(t)) {
			var n, i, r, o = ft._data(t),
				a = ft._data(e, o),
				s = o.events;
			if (s) {
				delete a.handle, a.events = {};
				for (n in s)
					for (i = 0, r = s[n].length; i < r; i++) ft.event.add(e, n, s[n][i])
			}
			a.data && (a.data = ft.extend({}, a.data))
		}
	}

	function S(t, e) {
		var n, i, r;
		if (1 === e.nodeType) {
			if (n = e.nodeName.toLowerCase(), !pt.noCloneEvent && e[ft.expando]) {
				r = ft._data(e);
				for (i in r.events) ft.removeEvent(e, i, r.handle);
				e.removeAttribute(ft.expando)
			}
			"script" === n && e.text !== t.text ? (w(e).text = t.text, C(e)) : "object" === n ? (e.parentNode && (e.outerHTML = t.outerHTML), pt.html5Clone && t.innerHTML && !ft.trim(e.innerHTML) && (e.innerHTML = t.innerHTML)) : "input" === n && Ft.test(t.type) ? (e.defaultChecked = e.checked = t.checked, e.value !== t.value && (e.value = t.value)) : "option" === n ? e.defaultSelected = e.selected = t.defaultSelected : "input" !== n && "textarea" !== n || (e.defaultValue = t.defaultValue)
		}
	}

	function T(t, e, n, i) {
		e = ot.apply([], e);
		var r, o, a, s, l, u, c = 0,
			p = t.length,
			d = p - 1,
			f = e[0],
			m = ft.isFunction(f);
		if (m || p > 1 && "string" == typeof f && !pt.checkClone && ne.test(f)) return t.each(function (r) {
			var o = t.eq(r);
			m && (e[0] = f.call(this, r, o.html())), T(o, e, n, i)
		});
		if (p && (u = v(e, t[0].ownerDocument, !1, t, i), r = u.firstChild, 1 === u.childNodes.length && (u = r), r || i)) {
			for (s = ft.map(h(u, "script"), w), a = s.length; c < p; c++) o = u, c !== d && (o = ft.clone(o, !0, !0), a && ft.merge(s, h(o, "script"))), n.call(t[c], o, c);
			if (a)
				for (l = s[s.length - 1].ownerDocument, ft.map(s, C), c = 0; c < a; c++) o = s[c], Bt.test(o.type || "") && !ft._data(o, "globalEval") && ft.contains(l, o) && (o.src ? ft._evalUrl && ft._evalUrl(o.src) : ft.globalEval((o.text || o.textContent || o.innerHTML || "").replace(re, "")));
			u = r = null
		}
		return t
	}

	function A(t, e, n) {
		for (var i, r = e ? ft.filter(e, t) : t, o = 0; null != (i = r[o]); o++) n || 1 !== i.nodeType || ft.cleanData(h(i)), i.parentNode && (n && ft.contains(i.ownerDocument, i) && m(h(i, "script")), i.parentNode.removeChild(i));
		return t
	}

	function D(t, e) {
		var n = ft(e.createElement(t)).appendTo(e.body),
			i = ft.css(n[0], "display");
		return n.detach(), i
	}

	function O(t) {
		var e = it,
			n = le[t];
		return n || (n = D(t, e), "none" !== n && n || (se = (se || ft("<iframe frameborder='0' width='0' height='0'/>")).appendTo(e.documentElement), e = (se[0].contentWindow || se[0].contentDocument).document, e.write(), e.close(), n = D(t, e), se.detach()), le[t] = n), n
	}

	function N(t, e) {
		return {
			get: function () {
				return t() ? void delete this.get : (this.get = e).apply(this, arguments)
			}
		}
	}

	function I(t) {
		if (t in we) return t;
		for (var e = t.charAt(0).toUpperCase() + t.slice(1), n = ke.length; n--;)
			if ((t = ke[n] + e) in we) return t
	}

	function P(t, e) {
		for (var n, i, r, o = [], a = 0, s = t.length; a < s; a++) i = t[a], i.style && (o[a] = ft._data(i, "olddisplay"), n = i.style.display, e ? (o[a] || "none" !== n || (i.style.display = ""), "" === i.style.display && jt(i) && (o[a] = ft._data(i, "olddisplay", O(i.nodeName)))) : (r = jt(i), (n && "none" !== n || !r) && ft._data(i, "olddisplay", r ? n : ft.css(i, "display"))));
		for (a = 0; a < s; a++) i = t[a], i.style && (e && "none" !== i.style.display && "" !== i.style.display || (i.style.display = e ? o[a] || "" : "none"));
		return t
	}

	function L(t, e, n) {
		var i = be.exec(e);
		return i ? Math.max(0, i[1] - (n || 0)) + (i[2] || "px") : e
	}

	function R(t, e, n, i, r) {
		for (var o = n === (i ? "border" : "content") ? 4 : "width" === e ? 1 : 0, a = 0; o < 4; o += 2) "margin" === n && (a += ft.css(t, n + Mt[o], !0, r)), i ? ("content" === n && (a -= ft.css(t, "padding" + Mt[o], !0, r)), "margin" !== n && (a -= ft.css(t, "border" + Mt[o] + "Width", !0, r))) : (a += ft.css(t, "padding" + Mt[o], !0, r), "padding" !== n && (a += ft.css(t, "border" + Mt[o] + "Width", !0, r)));
		return a
	}

	function M(t, e, n) {
		var i = !0,
			r = "width" === e ? t.offsetWidth : t.offsetHeight,
			o = fe(t),
			a = pt.boxSizing && "border-box" === ft.css(t, "boxSizing", !1, o);
		if (r <= 0 || null == r) {
			if (r = he(t, e, o), (r < 0 || null == r) && (r = t.style[e]), ce.test(r)) return r;
			i = a && (pt.boxSizingReliable() || r === t.style[e]), r = parseFloat(r) || 0
		}
		return r + R(t, e, n || (a ? "border" : "content"), i, o) + "px"
	}

	function j(t, e, n, i, r) {
		return new j.prototype.init(t, e, n, i, r)
	}

	function H() {
		return t.setTimeout(function () {
			Ce = undefined
		}), Ce = ft.now()
	}

	function F(t, e) {
		var n, i = {
				height: t
			},
			r = 0;
		for (e = e ? 1 : 0; r < 4; r += 2 - e) n = Mt[r], i["margin" + n] = i["padding" + n] = t;
		return e && (i.opacity = i.width = t), i
	}

	function q(t, e, n) {
		for (var i, r = (U.tweeners[e] || []).concat(U.tweeners["*"]), o = 0, a = r.length; o < a; o++)
			if (i = r[o].call(n, e, t)) return i
	}

	function B(t, e, n) {
		var i, r, o, a, s, l, u, c = this,
			p = {},
			d = t.style,
			f = t.nodeType && jt(t),
			h = ft._data(t, "fxshow");
		n.queue || (s = ft._queueHooks(t, "fx"), null == s.unqueued && (s.unqueued = 0, l = s.empty.fire, s.empty.fire = function () {
			s.unqueued || l()
		}), s.unqueued++, c.always(function () {
			c.always(function () {
				s.unqueued--, ft.queue(t, "fx").length || s.empty.fire()
			})
		})), 1 === t.nodeType && ("height" in e || "width" in e) && (n.overflow = [d.overflow, d.overflowX, d.overflowY], u = ft.css(t, "display"), "inline" === ("none" === u ? ft._data(t, "olddisplay") || O(t.nodeName) : u) && "none" === ft.css(t, "float") && (pt.inlineBlockNeedsLayout && "inline" !== O(t.nodeName) ? d.zoom = 1 : d.display = "inline-block")), n.overflow && (d.overflow = "hidden", pt.shrinkWrapBlocks() || c.always(function () {
			d.overflow = n.overflow[0], d.overflowX = n.overflow[1], d.overflowY = n.overflow[2]
		}));
		for (i in e)
			if (r = e[i], Se.exec(r)) {
				if (delete e[i], o = o || "toggle" === r, r === (f ? "hide" : "show")) {
					if ("show" !== r || !h || h[i] === undefined) continue;
					f = !0
				}
				p[i] = h && h[i] || ft.style(t, i)
			} else u = undefined;
		if (ft.isEmptyObject(p)) "inline" === ("none" === u ? O(t.nodeName) : u) && (d.display = u);
		else {
			h ? "hidden" in h && (f = h.hidden) : h = ft._data(t, "fxshow", {}), o && (h.hidden = !f), f ? ft(t).show() : c.done(function () {
				ft(t).hide()
			}), c.done(function () {
				var e;
				ft._removeData(t, "fxshow");
				for (e in p) ft.style(t, e, p[e])
			});
			for (i in p) a = q(f ? h[i] : 0, i, c), i in h || (h[i] = a.start, f && (a.end = a.start, a.start = "width" === i || "height" === i ? 1 : 0))
		}
	}

	function W(t, e) {
		var n, i, r, o, a;
		for (n in t)
			if (i = ft.camelCase(n), r = e[i], o = t[n], ft.isArray(o) && (r = o[1], o = t[n] = o[0]), n !== i && (t[i] = o, delete t[n]), (a = ft.cssHooks[i]) && "expand" in a) {
				o = a.expand(o), delete t[i];
				for (n in o) n in t || (t[n] = o[n], e[n] = r)
			} else e[i] = r
	}

	function U(t, e, n) {
		var i, r, o = 0,
			a = U.prefilters.length,
			s = ft.Deferred().always(function () {
				delete l.elem
			}),
			l = function () {
				if (r) return !1;
				for (var e = Ce || H(), n = Math.max(0, u.startTime + u.duration - e), i = n / u.duration || 0, o = 1 - i, a = 0, l = u.tweens.length; a < l; a++) u.tweens[a].run(o);
				return s.notifyWith(t, [u, o, n]), o < 1 && l ? n : (s.resolveWith(t, [u]), !1)
			},
			u = s.promise({
				elem: t,
				props: ft.extend({}, e),
				opts: ft.extend(!0, {
					specialEasing: {},
					easing: ft.easing._default
				}, n),
				originalProperties: e,
				originalOptions: n,
				startTime: Ce || H(),
				duration: n.duration,
				tweens: [],
				createTween: function (e, n) {
					var i = ft.Tween(t, u.opts, e, n, u.opts.specialEasing[e] || u.opts.easing);
					return u.tweens.push(i), i
				},
				stop: function (e) {
					var n = 0,
						i = e ? u.tweens.length : 0;
					if (r) return this;
					for (r = !0; n < i; n++) u.tweens[n].run(1);
					return e ? (s.notifyWith(t, [u, 1, 0]), s.resolveWith(t, [u, e])) : s.rejectWith(t, [u, e]), this
				}
			}),
			c = u.props;
		for (W(c, u.opts.specialEasing); o < a; o++)
			if (i = U.prefilters[o].call(u, t, c, u.opts)) return ft.isFunction(i.stop) && (ft._queueHooks(u.elem, u.opts.queue).stop = ft.proxy(i.stop, i)), i;
		return ft.map(c, q, u), ft.isFunction(u.opts.start) && u.opts.start.call(t, u), ft.fx.timer(ft.extend(l, {
			elem: t,
			anim: u,
			queue: u.opts.queue
		})), u.progress(u.opts.progress).done(u.opts.done, u.opts.complete).fail(u.opts.fail).always(u.opts.always)
	}

	function V(t) {
		return ft.attr(t, "class") || ""
	}

	function G(t) {
		return function (e, n) {
			"string" != typeof e && (n = e, e = "*");
			var i, r = 0,
				o = e.toLowerCase().match(At) || [];
			if (ft.isFunction(n))
				for (; i = o[r++];) "+" === i.charAt(0) ? (i = i.slice(1) || "*", (t[i] = t[i] || []).unshift(n)) : (t[i] = t[i] || []).push(n)
		}
	}

	function $(t, e, n, i) {
		function r(s) {
			var l;
			return o[s] = !0, ft.each(t[s] || [], function (t, s) {
				var u = s(e, n, i);
				return "string" != typeof u || a || o[u] ? a ? !(l = u) : void 0 : (e.dataTypes.unshift(u), r(u), !1)
			}), l
		}
		var o = {},
			a = t === Xe;
		return r(e.dataTypes[0]) || !o["*"] && r("*")
	}

	function z(t, e) {
		var n, i, r = ft.ajaxSettings.flatOptions || {};
		for (i in e) e[i] !== undefined && ((r[i] ? t : n || (n = {}))[i] = e[i]);
		return n && ft.extend(!0, t, n), t
	}

	function K(t, e, n) {
		for (var i, r, o, a, s = t.contents, l = t.dataTypes;
			"*" === l[0];) l.shift(), r === undefined && (r = t.mimeType || e.getResponseHeader("Content-Type"));
		if (r)
			for (a in s)
				if (s[a] && s[a].test(r)) {
					l.unshift(a);
					break
				}
		if (l[0] in n) o = l[0];
		else {
			for (a in n) {
				if (!l[0] || t.converters[a + " " + l[0]]) {
					o = a;
					break
				}
				i || (i = a)
			}
			o = o || i
		}
		if (o) return o !== l[0] && l.unshift(o), n[o]
	}

	function Q(t, e, n, i) {
		var r, o, a, s, l, u = {},
			c = t.dataTypes.slice();
		if (c[1])
			for (a in t.converters) u[a.toLowerCase()] = t.converters[a];
		for (o = c.shift(); o;)
			if (t.responseFields[o] && (n[t.responseFields[o]] = e), !l && i && t.dataFilter && (e = t.dataFilter(e, t.dataType)), l = o, o = c.shift())
				if ("*" === o) o = l;
				else if ("*" !== l && l !== o) {
			if (!(a = u[l + " " + o] || u["* " + o]))
				for (r in u)
					if (s = r.split(" "), s[1] === o && (a = u[l + " " + s[0]] || u["* " + s[0]])) {
						!0 === a ? a = u[r] : !0 !== u[r] && (o = s[0], c.unshift(s[1]));
						break
					}
			if (!0 !== a)
				if (a && t["throws"]) e = a(e);
				else try {
					e = a(e)
				} catch (t) {
					return {
						state: "parsererror",
						error: a ? t : "No conversion from " + l + " to " + o
					}
				}
		}
		return {
			state: "success",
			data: e
		}
	}

	function Y(t) {
		return t.style && t.style.display || ft.css(t, "display")
	}

	function X(t) {
		if (!ft.contains(t.ownerDocument || it, t)) return !0;
		for (; t && 1 === t.nodeType;) {
			if ("none" === Y(t) || "hidden" === t.type) return !0;
			t = t.parentNode
		}
		return !1
	}

	function J(t, e, n, i) {
		var r;
		if (ft.isArray(e)) ft.each(e, function (e, r) {
			n || nn.test(t) ? i(t, r) : J(t + "[" + ("object" == typeof r && null != r ? e : "") + "]", r, n, i)
		});
		else if (n || "object" !== ft.type(e)) i(t, e);
		else
			for (r in e) J(t + "[" + r + "]", e[r], n, i)
	}

	function Z() {
		try {
			return new t.XMLHttpRequest
		} catch (t) {}
	}

	function tt() {
		try {
			return new t.ActiveXObject("Microsoft.XMLHTTP")
		} catch (t) {}
	}

	function et(t) {
		return ft.isWindow(t) ? t : 9 === t.nodeType && (t.defaultView || t.parentWindow)
	}
	var nt = [],
		it = t.document,
		rt = nt.slice,
		ot = nt.concat,
		at = nt.push,
		st = nt.indexOf,
		lt = {},
		ut = lt.toString,
		ct = lt.hasOwnProperty,
		pt = {},
		dt = "1.12.4",
		ft = function (t, e) {
			return new ft.fn.init(t, e)
		},
		ht = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,
		mt = /^-ms-/,
		gt = /-([\da-z])/gi,
		vt = function (t, e) {
			return e.toUpperCase()
		};
	ft.fn = ft.prototype = {
		jquery: dt,
		constructor: ft,
		selector: "",
		length: 0,
		toArray: function () {
			return rt.call(this)
		},
		get: function (t) {
			return null != t ? t < 0 ? this[t + this.length] : this[t] : rt.call(this)
		},
		pushStack: function (t) {
			var e = ft.merge(this.constructor(), t);
			return e.prevObject = this, e.context = this.context, e
		},
		each: function (t) {
			return ft.each(this, t)
		},
		map: function (t) {
			return this.pushStack(ft.map(this, function (e, n) {
				return t.call(e, n, e)
			}))
		},
		slice: function () {
			return this.pushStack(rt.apply(this, arguments))
		},
		first: function () {
			return this.eq(0)
		},
		last: function () {
			return this.eq(-1)
		},
		eq: function (t) {
			var e = this.length,
				n = +t + (t < 0 ? e : 0);
			return this.pushStack(n >= 0 && n < e ? [this[n]] : [])
		},
		end: function () {
			return this.prevObject || this.constructor()
		},
		push: at,
		sort: nt.sort,
		splice: nt.splice
	}, ft.extend = ft.fn.extend = function () {
		var t, e, n, i, r, o, a = arguments[0] || {},
			s = 1,
			l = arguments.length,
			u = !1;
		for ("boolean" == typeof a && (u = a, a = arguments[s] || {}, s++), "object" == typeof a || ft.isFunction(a) || (a = {}), s === l && (a = this, s--); s < l; s++)
			if (null != (r = arguments[s]))
				for (i in r) t = a[i], n = r[i], a !== n && (u && n && (ft.isPlainObject(n) || (e = ft.isArray(n))) ? (e ? (e = !1, o = t && ft.isArray(t) ? t : []) : o = t && ft.isPlainObject(t) ? t : {}, a[i] = ft.extend(u, o, n)) : n !== undefined && (a[i] = n));
		return a
	}, ft.extend({
		expando: "jQuery" + (dt + Math.random()).replace(/\D/g, ""),
		isReady: !0,
		error: function (t) {
			throw new Error(t)
		},
		noop: function () {},
		isFunction: function (t) {
			return "function" === ft.type(t)
		},
		isArray: Array.isArray || function (t) {
			return "array" === ft.type(t)
		},
		isWindow: function (t) {
			return null != t && t == t.window
		},
		isNumeric: function (t) {
			var e = t && t.toString();
			return !ft.isArray(t) && e - parseFloat(e) + 1 >= 0
		},
		isEmptyObject: function (t) {
			var e;
			for (e in t) return !1;
			return !0
		},
		isPlainObject: function (t) {
			var e;
			if (!t || "object" !== ft.type(t) || t.nodeType || ft.isWindow(t)) return !1;
			try {
				if (t.constructor && !ct.call(t, "constructor") && !ct.call(t.constructor.prototype, "isPrototypeOf")) return !1
			} catch (t) {
				return !1
			}
			if (!pt.ownFirst)
				for (e in t) return ct.call(t, e);
			for (e in t);
			return e === undefined || ct.call(t, e)
		},
		type: function (t) {
			return null == t ? t + "" : "object" == typeof t || "function" == typeof t ? lt[ut.call(t)] || "object" : typeof t
		},
		globalEval: function (e) {
			e && ft.trim(e) && (t.execScript || function (e) {
				t.eval.call(t, e)
			})(e)
		},
		camelCase: function (t) {
			return t.replace(mt, "ms-").replace(gt, vt)
		},
		nodeName: function (t, e) {
			return t.nodeName && t.nodeName.toLowerCase() === e.toLowerCase()
		},
		each: function (t, e) {
			var i, r = 0;
			if (n(t))
				for (i = t.length; r < i && !1 !== e.call(t[r], r, t[r]); r++);
			else
				for (r in t)
					if (!1 === e.call(t[r], r, t[r])) break;
			return t
		},
		trim: function (t) {
			return null == t ? "" : (t + "").replace(ht, "")
		},
		makeArray: function (t, e) {
			var i = e || [];
			return null != t && (n(Object(t)) ? ft.merge(i, "string" == typeof t ? [t] : t) : at.call(i, t)), i
		},
		inArray: function (t, e, n) {
			var i;
			if (e) {
				if (st) return st.call(e, t, n);
				for (i = e.length, n = n ? n < 0 ? Math.max(0, i + n) : n : 0; n < i; n++)
					if (n in e && e[n] === t) return n
			}
			return -1
		},
		merge: function (t, e) {
			for (var n = +e.length, i = 0, r = t.length; i < n;) t[r++] = e[i++];
			if (n !== n)
				for (; e[i] !== undefined;) t[r++] = e[i++];
			return t.length = r, t
		},
		grep: function (t, e, n) {
			for (var i = [], r = 0, o = t.length, a = !n; r < o; r++) !e(t[r], r) !== a && i.push(t[r]);
			return i
		},
		map: function (t, e, i) {
			var r, o, a = 0,
				s = [];
			if (n(t))
				for (r = t.length; a < r; a++) null != (o = e(t[a], a, i)) && s.push(o);
			else
				for (a in t) null != (o = e(t[a], a, i)) && s.push(o);
			return ot.apply([], s)
		},
		guid: 1,
		proxy: function (t, e) {
			var n, i, r;
			return "string" == typeof e && (r = t[e], e = t, t = r), ft.isFunction(t) ? (n = rt.call(arguments, 2), i = function () {
				return t.apply(e || this, n.concat(rt.call(arguments)))
			}, i.guid = t.guid = t.guid || ft.guid++, i) : undefined
		},
		now: function () {
			return +new Date
		},
		support: pt
	}), "function" == typeof Symbol && (ft.fn[Symbol.iterator] = nt[Symbol.iterator]), ft.each("Boolean Number String Function Array Date RegExp Object Error Symbol".split(" "), function (t, e) {
		lt["[object " + e + "]"] = e.toLowerCase()
	});
	var yt = function (t) {
		function e(t, e, n, i) {
			var r, o, a, s, l, u, p, f, h = e && e.ownerDocument,
				m = e ? e.nodeType : 9;
			if (n = n || [], "string" != typeof t || !t || 1 !== m && 9 !== m && 11 !== m) return n;
			if (!i && ((e ? e.ownerDocument || e : q) !== I && N(e), e = e || I, L)) {
				if (11 !== m && (u = vt.exec(t)))
					if (r = u[1]) {
						if (9 === m) {
							if (!(a = e.getElementById(r))) return n;
							if (a.id === r) return n.push(a), n
						} else if (h && (a = h.getElementById(r)) && H(e, a) && a.id === r) return n.push(a), n
					} else {
						if (u[2]) return J.apply(n, e.getElementsByTagName(t)), n;
						if ((r = u[3]) && E.getElementsByClassName && e.getElementsByClassName) return J.apply(n, e.getElementsByClassName(r)), n
					}
				if (E.qsa && !G[t + " "] && (!R || !R.test(t))) {
					if (1 !== m) h = e, f = t;
					else if ("object" !== e.nodeName.toLowerCase()) {
						for ((s = e.getAttribute("id")) ? s = s.replace(bt, "\\$&") : e.setAttribute("id", s = F), p = x(t), o = p.length, l = dt.test(s) ? "#" + s : "[id='" + s + "']"; o--;) p[o] = l + " " + d(p[o]);
						f = p.join(","), h = yt.test(t) && c(e.parentNode) || e
					}
					if (f) try {
						return J.apply(n, h.querySelectorAll(f)), n
					} catch (t) {} finally {
						s === F && e.removeAttribute("id")
					}
				}
			}
			return T(t.replace(st, "$1"), e, n, i)
		}

		function n() {
			function t(n, i) {
				return e.push(n + " ") > k.cacheLength && delete t[e.shift()], t[n + " "] = i
			}
			var e = [];
			return t
		}

		function i(t) {
			return t[F] = !0, t
		}

		function r(t) {
			var e = I.createElement("div");
			try {
				return !!t(e)
			} catch (t) {
				return !1
			} finally {
				e.parentNode && e.parentNode.removeChild(e), e = null
			}
		}

		function o(t, e) {
			for (var n = t.split("|"), i = n.length; i--;) k.attrHandle[n[i]] = e
		}

		function a(t, e) {
			var n = e && t,
				i = n && 1 === t.nodeType && 1 === e.nodeType && (~e.sourceIndex || z) - (~t.sourceIndex || z);
			if (i) return i;
			if (n)
				for (; n = n.nextSibling;)
					if (n === e) return -1;
			return t ? 1 : -1
		}

		function s(t) {
			return function (e) {
				return "input" === e.nodeName.toLowerCase() && e.type === t
			}
		}

		function l(t) {
			return function (e) {
				var n = e.nodeName.toLowerCase();
				return ("input" === n || "button" === n) && e.type === t
			}
		}

		function u(t) {
			return i(function (e) {
				return e = +e, i(function (n, i) {
					for (var r, o = t([], n.length, e), a = o.length; a--;) n[r = o[a]] && (n[r] = !(i[r] = n[r]))
				})
			})
		}

		function c(t) {
			return t && "undefined" != typeof t.getElementsByTagName && t
		}

		function p() {}

		function d(t) {
			for (var e = 0, n = t.length, i = ""; e < n; e++) i += t[e].value;
			return i
		}

		function f(t, e, n) {
			var i = e.dir,
				r = n && "parentNode" === i,
				o = W++;
			return e.first ? function (e, n, o) {
				for (; e = e[i];)
					if (1 === e.nodeType || r) return t(e, n, o)
			} : function (e, n, a) {
				var s, l, u, c = [B, o];
				if (a) {
					for (; e = e[i];)
						if ((1 === e.nodeType || r) && t(e, n, a)) return !0
				} else
					for (; e = e[i];)
						if (1 === e.nodeType || r) {
							if (u = e[F] || (e[F] = {}), l = u[e.uniqueID] || (u[e.uniqueID] = {}), (s = l[i]) && s[0] === B && s[1] === o) return c[2] = s[2];
							if (l[i] = c, c[2] = t(e, n, a)) return !0
						}
			}
		}

		function h(t) {
			return t.length > 1 ? function (e, n, i) {
				for (var r = t.length; r--;)
					if (!t[r](e, n, i)) return !1;
				return !0
			} : t[0]
		}

		function m(t, n, i) {
			for (var r = 0, o = n.length; r < o; r++) e(t, n[r], i);
			return i
		}

		function g(t, e, n, i, r) {
			for (var o, a = [], s = 0, l = t.length, u = null != e; s < l; s++)(o = t[s]) && (n && !n(o, i, r) || (a.push(o), u && e.push(s)));
			return a
		}

		function v(t, e, n, r, o, a) {
			return r && !r[F] && (r = v(r)), o && !o[F] && (o = v(o, a)), i(function (i, a, s, l) {
				var u, c, p, d = [],
					f = [],
					h = a.length,
					v = i || m(e || "*", s.nodeType ? [s] : s, []),
					y = !t || !i && e ? v : g(v, d, t, s, l),
					b = n ? o || (i ? t : h || r) ? [] : a : y;
				if (n && n(y, b, s, l), r)
					for (u = g(b, f), r(u, [], s, l), c = u.length; c--;)(p = u[c]) && (b[f[c]] = !(y[f[c]] = p));
				if (i) {
					if (o || t) {
						if (o) {
							for (u = [], c = b.length; c--;)(p = b[c]) && u.push(y[c] = p);
							o(null, b = [], u, l)
						}
						for (c = b.length; c--;)(p = b[c]) && (u = o ? tt(i, p) : d[c]) > -1 && (i[u] = !(a[u] = p))
					}
				} else b = g(b === a ? b.splice(h, b.length) : b), o ? o(null, a, b, l) : J.apply(a, b)
			})
		}

		function y(t) {
			for (var e, n, i, r = t.length, o = k.relative[t[0].type], a = o || k.relative[" "], s = o ? 1 : 0, l = f(function (t) {
					return t === e
				}, a, !0), u = f(function (t) {
					return tt(e, t) > -1
				}, a, !0), c = [function (t, n, i) {
					var r = !o && (i || n !== A) || ((e = n).nodeType ? l(t, n, i) : u(t, n, i));
					return e = null, r
				}]; s < r; s++)
				if (n = k.relative[t[s].type]) c = [f(h(c), n)];
				else {
					if (n = k.filter[t[s].type].apply(null, t[s].matches), n[F]) {
						for (i = ++s; i < r && !k.relative[t[i].type]; i++);
						return v(s > 1 && h(c), s > 1 && d(t.slice(0, s - 1).concat({
							value: " " === t[s - 2].type ? "*" : ""
						})).replace(st, "$1"), n, s < i && y(t.slice(s, i)), i < r && y(t = t.slice(i)), i < r && d(t))
					}
					c.push(n)
				}
			return h(c)
		}

		function b(t, n) {
			var r = n.length > 0,
				o = t.length > 0,
				a = function (i, a, s, l, u) {
					var c, p, d, f = 0,
						h = "0",
						m = i && [],
						v = [],
						y = A,
						b = i || o && k.find.TAG("*", u),
						_ = B += null == y ? 1 : Math.random() || .1,
						E = b.length;
					for (u && (A = a === I || a || u); h !== E && null != (c = b[h]); h++) {
						if (o && c) {
							for (p = 0, a || c.ownerDocument === I || (N(c), s = !L); d = t[p++];)
								if (d(c, a || I, s)) {
									l.push(c);
									break
								}
							u && (B = _)
						}
						r && ((c = !d && c) && f--, i && m.push(c))
					}
					if (f += h, r && h !== f) {
						for (p = 0; d = n[p++];) d(m, v, a, s);
						if (i) {
							if (f > 0)
								for (; h--;) m[h] || v[h] || (v[h] = Y.call(l));
							v = g(v)
						}
						J.apply(l, v), u && !i && v.length > 0 && f + n.length > 1 && e.uniqueSort(l)
					}
					return u && (B = _, A = y), m
				};
			return r ? i(a) : a
		}
		var _, E, k, w, C, x, S, T, A, D, O, N, I, P, L, R, M, j, H, F = "sizzle" + 1 * new Date,
			q = t.document,
			B = 0,
			W = 0,
			U = n(),
			V = n(),
			G = n(),
			$ = function (t, e) {
				return t === e && (O = !0), 0
			},
			z = 1 << 31,
			K = {}.hasOwnProperty,
			Q = [],
			Y = Q.pop,
			X = Q.push,
			J = Q.push,
			Z = Q.slice,
			tt = function (t, e) {
				for (var n = 0, i = t.length; n < i; n++)
					if (t[n] === e) return n;
				return -1
			},
			et = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
			nt = "[\\x20\\t\\r\\n\\f]",
			it = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
			rt = "\\[" + nt + "*(" + it + ")(?:" + nt + "*([*^$|!~]?=)" + nt + "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + it + "))|)" + nt + "*\\]",
			ot = ":(" + it + ")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" + rt + ")*)|.*)\\)|)",
			at = new RegExp(nt + "+", "g"),
			st = new RegExp("^" + nt + "+|((?:^|[^\\\\])(?:\\\\.)*)" + nt + "+$", "g"),
			lt = new RegExp("^" + nt + "*," + nt + "*"),
			ut = new RegExp("^" + nt + "*([>+~]|" + nt + ")" + nt + "*"),
			ct = new RegExp("=" + nt + "*([^\\]'\"]*?)" + nt + "*\\]", "g"),
			pt = new RegExp(ot),
			dt = new RegExp("^" + it + "$"),
			ft = {
				ID: new RegExp("^#(" + it + ")"),
				CLASS: new RegExp("^\\.(" + it + ")"),
				TAG: new RegExp("^(" + it + "|[*])"),
				ATTR: new RegExp("^" + rt),
				PSEUDO: new RegExp("^" + ot),
				CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + nt + "*(even|odd|(([+-]|)(\\d*)n|)" + nt + "*(?:([+-]|)" + nt + "*(\\d+)|))" + nt + "*\\)|)", "i"),
				bool: new RegExp("^(?:" + et + ")$", "i"),
				needsContext: new RegExp("^" + nt + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + nt + "*((?:-\\d)?\\d*)" + nt + "*\\)|)(?=[^-]|$)", "i")
			},
			ht = /^(?:input|select|textarea|button)$/i,
			mt = /^h\d$/i,
			gt = /^[^{]+\{\s*\[native \w/,
			vt = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
			yt = /[+~]/,
			bt = /'|\\/g,
			_t = new RegExp("\\\\([\\da-f]{1,6}" + nt + "?|(" + nt + ")|.)", "ig"),
			Et = function (t, e, n) {
				var i = "0x" + e - 65536;
				return i !== i || n ? e : i < 0 ? String.fromCharCode(i + 65536) : String.fromCharCode(i >> 10 | 55296, 1023 & i | 56320)
			},
			kt = function () {
				N()
			};
		try {
			J.apply(Q = Z.call(q.childNodes), q.childNodes), Q[q.childNodes.length].nodeType
		} catch (t) {
			J = {
				apply: Q.length ? function (t, e) {
					X.apply(t, Z.call(e))
				} : function (t, e) {
					for (var n = t.length, i = 0; t[n++] = e[i++];);
					t.length = n - 1
				}
			}
		}
		E = e.support = {}, C = e.isXML = function (t) {
			var e = t && (t.ownerDocument || t).documentElement;
			return !!e && "HTML" !== e.nodeName
		}, N = e.setDocument = function (t) {
			var e, n, i = t ? t.ownerDocument || t : q;
			return i !== I && 9 === i.nodeType && i.documentElement ? (I = i, P = I.documentElement, L = !C(I), (n = I.defaultView) && n.top !== n && (n.addEventListener ? n.addEventListener("unload", kt, !1) : n.attachEvent && n.attachEvent("onunload", kt)), E.attributes = r(function (t) {
				return t.className = "i", !t.getAttribute("className")
			}), E.getElementsByTagName = r(function (t) {
				return t.appendChild(I.createComment("")), !t.getElementsByTagName("*").length
			}), E.getElementsByClassName = gt.test(I.getElementsByClassName), E.getById = r(function (t) {
				return P.appendChild(t).id = F, !I.getElementsByName || !I.getElementsByName(F).length
			}), E.getById ? (k.find.ID = function (t, e) {
				if ("undefined" != typeof e.getElementById && L) {
					var n = e.getElementById(t);
					return n ? [n] : []
				}
			}, k.filter.ID = function (t) {
				var e = t.replace(_t, Et);
				return function (t) {
					return t.getAttribute("id") === e
				}
			}) : (delete k.find.ID, k.filter.ID = function (t) {
				var e = t.replace(_t, Et);
				return function (t) {
					var n = "undefined" != typeof t.getAttributeNode && t.getAttributeNode("id");
					return n && n.value === e
				}
			}), k.find.TAG = E.getElementsByTagName ? function (t, e) {
				return "undefined" != typeof e.getElementsByTagName ? e.getElementsByTagName(t) : E.qsa ? e.querySelectorAll(t) : void 0
			} : function (t, e) {
				var n, i = [],
					r = 0,
					o = e.getElementsByTagName(t);
				if ("*" === t) {
					for (; n = o[r++];) 1 === n.nodeType && i.push(n);
					return i
				}
				return o
			}, k.find.CLASS = E.getElementsByClassName && function (t, e) {
				if ("undefined" != typeof e.getElementsByClassName && L) return e.getElementsByClassName(t)
			}, M = [], R = [], (E.qsa = gt.test(I.querySelectorAll)) && (r(function (t) {
				P.appendChild(t).innerHTML = "<a id='" + F + "'></a><select id='" + F + "-\r\\' msallowcapture=''><option selected=''></option></select>", t.querySelectorAll("[msallowcapture^='']").length && R.push("[*^$]=" + nt + "*(?:''|\"\")"), t.querySelectorAll("[selected]").length || R.push("\\[" + nt + "*(?:value|" + et + ")"), t.querySelectorAll("[id~=" + F + "-]").length || R.push("~="), t.querySelectorAll(":checked").length || R.push(":checked"), t.querySelectorAll("a#" + F + "+*").length || R.push(".#.+[+~]")
			}), r(function (t) {
				var e = I.createElement("input");
				e.setAttribute("type", "hidden"), t.appendChild(e).setAttribute("name", "D"), t.querySelectorAll("[name=d]").length && R.push("name" + nt + "*[*^$|!~]?="), t.querySelectorAll(":enabled").length || R.push(":enabled", ":disabled"), t.querySelectorAll("*,:x"), R.push(",.*:")
			})), (E.matchesSelector = gt.test(j = P.matches || P.webkitMatchesSelector || P.mozMatchesSelector || P.oMatchesSelector || P.msMatchesSelector)) && r(function (t) {
				E.disconnectedMatch = j.call(t, "div"), j.call(t, "[s!='']:x"), M.push("!=", ot)
			}), R = R.length && new RegExp(R.join("|")), M = M.length && new RegExp(M.join("|")), e = gt.test(P.compareDocumentPosition), H = e || gt.test(P.contains) ? function (t, e) {
				var n = 9 === t.nodeType ? t.documentElement : t,
					i = e && e.parentNode;
				return t === i || !(!i || 1 !== i.nodeType || !(n.contains ? n.contains(i) : t.compareDocumentPosition && 16 & t.compareDocumentPosition(i)))
			} : function (t, e) {
				if (e)
					for (; e = e.parentNode;)
						if (e === t) return !0;
				return !1
			}, $ = e ? function (t, e) {
				if (t === e) return O = !0, 0;
				var n = !t.compareDocumentPosition - !e.compareDocumentPosition;
				return n || (n = (t.ownerDocument || t) === (e.ownerDocument || e) ? t.compareDocumentPosition(e) : 1, 1 & n || !E.sortDetached && e.compareDocumentPosition(t) === n ? t === I || t.ownerDocument === q && H(q, t) ? -1 : e === I || e.ownerDocument === q && H(q, e) ? 1 : D ? tt(D, t) - tt(D, e) : 0 : 4 & n ? -1 : 1)
			} : function (t, e) {
				if (t === e) return O = !0, 0;
				var n, i = 0,
					r = t.parentNode,
					o = e.parentNode,
					s = [t],
					l = [e];
				if (!r || !o) return t === I ? -1 : e === I ? 1 : r ? -1 : o ? 1 : D ? tt(D, t) - tt(D, e) : 0;
				if (r === o) return a(t, e);
				for (n = t; n = n.parentNode;) s.unshift(n);
				for (n = e; n = n.parentNode;) l.unshift(n);
				for (; s[i] === l[i];) i++;
				return i ? a(s[i], l[i]) : s[i] === q ? -1 : l[i] === q ? 1 : 0
			}, I) : I
		}, e.matches = function (t, n) {
			return e(t, null, null, n)
		}, e.matchesSelector = function (t, n) {
			if ((t.ownerDocument || t) !== I && N(t), n = n.replace(ct, "='$1']"), E.matchesSelector && L && !G[n + " "] && (!M || !M.test(n)) && (!R || !R.test(n))) try {
				var i = j.call(t, n);
				if (i || E.disconnectedMatch || t.document && 11 !== t.document.nodeType) return i
			} catch (t) {}
			return e(n, I, null, [t]).length > 0
		}, e.contains = function (t, e) {
			return (t.ownerDocument || t) !== I && N(t), H(t, e)
		}, e.attr = function (t, e) {
			(t.ownerDocument || t) !== I && N(t);
			var n = k.attrHandle[e.toLowerCase()],
				i = n && K.call(k.attrHandle, e.toLowerCase()) ? n(t, e, !L) : undefined;
			return i !== undefined ? i : E.attributes || !L ? t.getAttribute(e) : (i = t.getAttributeNode(e)) && i.specified ? i.value : null
		}, e.error = function (t) {
			throw new Error("Syntax error, unrecognized expression: " + t)
		}, e.uniqueSort = function (t) {
			var e, n = [],
				i = 0,
				r = 0;
			if (O = !E.detectDuplicates, D = !E.sortStable && t.slice(0), t.sort($), O) {
				for (; e = t[r++];) e === t[r] && (i = n.push(r));
				for (; i--;) t.splice(n[i], 1)
			}
			return D = null, t
		}, w = e.getText = function (t) {
			var e, n = "",
				i = 0,
				r = t.nodeType;
			if (r) {
				if (1 === r || 9 === r || 11 === r) {
					if ("string" == typeof t.textContent) return t.textContent;
					for (t = t.firstChild; t; t = t.nextSibling) n += w(t)
				} else if (3 === r || 4 === r) return t.nodeValue
			} else
				for (; e = t[i++];) n += w(e);
			return n
		}, k = e.selectors = {
			cacheLength: 50,
			createPseudo: i,
			match: ft,
			attrHandle: {},
			find: {},
			relative: {
				">": {
					dir: "parentNode",
					first: !0
				},
				" ": {
					dir: "parentNode"
				},
				"+": {
					dir: "previousSibling",
					first: !0
				},
				"~": {
					dir: "previousSibling"
				}
			},
			preFilter: {
				ATTR: function (t) {
					return t[1] = t[1].replace(_t, Et), t[3] = (t[3] || t[4] || t[5] || "").replace(_t, Et), "~=" === t[2] && (t[3] = " " + t[3] + " "), t.slice(0, 4)
				},
				CHILD: function (t) {
					return t[1] = t[1].toLowerCase(), "nth" === t[1].slice(0, 3) ? (t[3] || e.error(t[0]), t[4] = +(t[4] ? t[5] + (t[6] || 1) : 2 * ("even" === t[3] || "odd" === t[3])), t[5] = +(t[7] + t[8] || "odd" === t[3])) : t[3] && e.error(t[0]), t
				},
				PSEUDO: function (t) {
					var e, n = !t[6] && t[2];
					return ft.CHILD.test(t[0]) ? null : (t[3] ? t[2] = t[4] || t[5] || "" : n && pt.test(n) && (e = x(n, !0)) && (e = n.indexOf(")", n.length - e) - n.length) && (t[0] = t[0].slice(0, e), t[2] = n.slice(0, e)), t.slice(0, 3))
				}
			},
			filter: {
				TAG: function (t) {
					var e = t.replace(_t, Et).toLowerCase();
					return "*" === t ? function () {
						return !0
					} : function (t) {
						return t.nodeName && t.nodeName.toLowerCase() === e
					}
				},
				CLASS: function (t) {
					var e = U[t + " "];
					return e || (e = new RegExp("(^|" + nt + ")" + t + "(" + nt + "|$)")) && U(t, function (t) {
						return e.test("string" == typeof t.className && t.className || "undefined" != typeof t.getAttribute && t.getAttribute("class") || "")
					})
				},
				ATTR: function (t, n, i) {
					return function (r) {
						var o = e.attr(r, t);
						return null == o ? "!=" === n : !n || (o += "", "=" === n ? o === i : "!=" === n ? o !== i : "^=" === n ? i && 0 === o.indexOf(i) : "*=" === n ? i && o.indexOf(i) > -1 : "$=" === n ? i && o.slice(-i.length) === i : "~=" === n ? (" " + o.replace(at, " ") + " ").indexOf(i) > -1 : "|=" === n && (o === i || o.slice(0, i.length + 1) === i + "-"))
					}
				},
				CHILD: function (t, e, n, i, r) {
					var o = "nth" !== t.slice(0, 3),
						a = "last" !== t.slice(-4),
						s = "of-type" === e;
					return 1 === i && 0 === r ? function (t) {
						return !!t.parentNode
					} : function (e, n, l) {
						var u, c, p, d, f, h, m = o !== a ? "nextSibling" : "previousSibling",
							g = e.parentNode,
							v = s && e.nodeName.toLowerCase(),
							y = !l && !s,
							b = !1;
						if (g) {
							if (o) {
								for (; m;) {
									for (d = e; d = d[m];)
										if (s ? d.nodeName.toLowerCase() === v : 1 === d.nodeType) return !1;
									h = m = "only" === t && !h && "nextSibling"
								}
								return !0
							}
							if (h = [a ? g.firstChild : g.lastChild], a && y) {
								for (d = g, p = d[F] || (d[F] = {}), c = p[d.uniqueID] || (p[d.uniqueID] = {}), u = c[t] || [], f = u[0] === B && u[1], b = f && u[2], d = f && g.childNodes[f]; d = ++f && d && d[m] || (b = f = 0) || h.pop();)
									if (1 === d.nodeType && ++b && d === e) {
										c[t] = [B, f, b];
										break
									}
							} else if (y && (d = e, p = d[F] || (d[F] = {}), c = p[d.uniqueID] || (p[d.uniqueID] = {}), u = c[t] || [], f = u[0] === B && u[1], b = f), !1 === b)
								for (;
									(d = ++f && d && d[m] || (b = f = 0) || h.pop()) && ((s ? d.nodeName.toLowerCase() !== v : 1 !== d.nodeType) || !++b || (y && (p = d[F] || (d[F] = {}), c = p[d.uniqueID] || (p[d.uniqueID] = {}), c[t] = [B, b]), d !== e)););
							return (b -= r) === i || b % i == 0 && b / i >= 0
						}
					}
				},
				PSEUDO: function (t, n) {
					var r, o = k.pseudos[t] || k.setFilters[t.toLowerCase()] || e.error("unsupported pseudo: " + t);
					return o[F] ? o(n) : o.length > 1 ? (r = [t, t, "", n], k.setFilters.hasOwnProperty(t.toLowerCase()) ? i(function (t, e) {
						for (var i, r = o(t, n), a = r.length; a--;) i = tt(t, r[a]), t[i] = !(e[i] = r[a])
					}) : function (t) {
						return o(t, 0, r)
					}) : o
				}
			},
			pseudos: {
				not: i(function (t) {
					var e = [],
						n = [],
						r = S(t.replace(st, "$1"));
					return r[F] ? i(function (t, e, n, i) {
						for (var o, a = r(t, null, i, []), s = t.length; s--;)(o = a[s]) && (t[s] = !(e[s] = o))
					}) : function (t, i, o) {
						return e[0] = t, r(e, null, o, n), e[0] = null, !n.pop()
					}
				}),
				has: i(function (t) {
					return function (n) {
						return e(t, n).length > 0
					}
				}),
				contains: i(function (t) {
					return t = t.replace(_t, Et),
						function (e) {
							return (e.textContent || e.innerText || w(e)).indexOf(t) > -1
						}
				}),
				lang: i(function (t) {
					return dt.test(t || "") || e.error("unsupported lang: " + t), t = t.replace(_t, Et).toLowerCase(),
						function (e) {
							var n;
							do {
								if (n = L ? e.lang : e.getAttribute("xml:lang") || e.getAttribute("lang")) return (n = n.toLowerCase()) === t || 0 === n.indexOf(t + "-")
							} while ((e = e.parentNode) && 1 === e.nodeType);
							return !1
						}
				}),
				target: function (e) {
					var n = t.location && t.location.hash;
					return n && n.slice(1) === e.id
				},
				root: function (t) {
					return t === P
				},
				focus: function (t) {
					return t === I.activeElement && (!I.hasFocus || I.hasFocus()) && !!(t.type || t.href || ~t.tabIndex)
				},
				enabled: function (t) {
					return !1 === t.disabled
				},
				disabled: function (t) {
					return !0 === t.disabled
				},
				checked: function (t) {
					var e = t.nodeName.toLowerCase();
					return "input" === e && !!t.checked || "option" === e && !!t.selected
				},
				selected: function (t) {
					return t.parentNode && t.parentNode.selectedIndex, !0 === t.selected
				},
				empty: function (t) {
					for (t = t.firstChild; t; t = t.nextSibling)
						if (t.nodeType < 6) return !1;
					return !0
				},
				parent: function (t) {
					return !k.pseudos.empty(t)
				},
				header: function (t) {
					return mt.test(t.nodeName)
				},
				input: function (t) {
					return ht.test(t.nodeName)
				},
				button: function (t) {
					var e = t.nodeName.toLowerCase();
					return "input" === e && "button" === t.type || "button" === e
				},
				text: function (t) {
					var e;
					return "input" === t.nodeName.toLowerCase() && "text" === t.type && (null == (e = t.getAttribute("type")) || "text" === e.toLowerCase())
				},
				first: u(function () {
					return [0]
				}),
				last: u(function (t, e) {
					return [e - 1]
				}),
				eq: u(function (t, e, n) {
					return [n < 0 ? n + e : n]
				}),
				even: u(function (t, e) {
					for (var n = 0; n < e; n += 2) t.push(n);
					return t
				}),
				odd: u(function (t, e) {
					for (var n = 1; n < e; n += 2) t.push(n);
					return t
				}),
				lt: u(function (t, e, n) {
					for (var i = n < 0 ? n + e : n; --i >= 0;) t.push(i);
					return t
				}),
				gt: u(function (t, e, n) {
					for (var i = n < 0 ? n + e : n; ++i < e;) t.push(i);
					return t
				})
			}
		}, k.pseudos.nth = k.pseudos.eq;
		for (_ in {
				radio: !0,
				checkbox: !0,
				file: !0,
				password: !0,
				image: !0
			}) k.pseudos[_] = s(_);
		for (_ in {
				submit: !0,
				reset: !0
			}) k.pseudos[_] = l(_);
		return p.prototype = k.filters = k.pseudos, k.setFilters = new p, x = e.tokenize = function (t, n) {
			var i, r, o, a, s, l, u, c = V[t + " "];
			if (c) return n ? 0 : c.slice(0);
			for (s = t, l = [], u = k.preFilter; s;) {
				i && !(r = lt.exec(s)) || (r && (s = s.slice(r[0].length) || s), l.push(o = [])), i = !1, (r = ut.exec(s)) && (i = r.shift(), o.push({
					value: i,
					type: r[0].replace(st, " ")
				}), s = s.slice(i.length));
				for (a in k.filter) !(r = ft[a].exec(s)) || u[a] && !(r = u[a](r)) || (i = r.shift(), o.push({
					value: i,
					type: a,
					matches: r
				}), s = s.slice(i.length));
				if (!i) break
			}
			return n ? s.length : s ? e.error(t) : V(t, l).slice(0)
		}, S = e.compile = function (t, e) {
			var n, i = [],
				r = [],
				o = G[t + " "];
			if (!o) {
				for (e || (e = x(t)), n = e.length; n--;) o = y(e[n]), o[F] ? i.push(o) : r.push(o);
				o = G(t, b(r, i)), o.selector = t
			}
			return o
		}, T = e.select = function (t, e, n, i) {
			var r, o, a, s, l, u = "function" == typeof t && t,
				p = !i && x(t = u.selector || t);
			if (n = n || [], 1 === p.length) {
				if (o = p[0] = p[0].slice(0), o.length > 2 && "ID" === (a = o[0]).type && E.getById && 9 === e.nodeType && L && k.relative[o[1].type]) {
					if (!(e = (k.find.ID(a.matches[0].replace(_t, Et), e) || [])[0])) return n;
					u && (e = e.parentNode), t = t.slice(o.shift().value.length)
				}
				for (r = ft.needsContext.test(t) ? 0 : o.length; r-- && (a = o[r], !k.relative[s = a.type]);)
					if ((l = k.find[s]) && (i = l(a.matches[0].replace(_t, Et), yt.test(o[0].type) && c(e.parentNode) || e))) {
						if (o.splice(r, 1), !(t = i.length && d(o))) return J.apply(n, i), n;
						break
					}
			}
			return (u || S(t, p))(i, e, !L, n, !e || yt.test(t) && c(e.parentNode) || e), n
		}, E.sortStable = F.split("").sort($).join("") === F, E.detectDuplicates = !!O, N(), E.sortDetached = r(function (t) {
			return 1 & t.compareDocumentPosition(I.createElement("div"))
		}), r(function (t) {
			return t.innerHTML = "<a href='#'></a>", "#" === t.firstChild.getAttribute("href")
		}) || o("type|href|height|width", function (t, e, n) {
			if (!n) return t.getAttribute(e, "type" === e.toLowerCase() ? 1 : 2)
		}), E.attributes && r(function (t) {
			return t.innerHTML = "<input/>", t.firstChild.setAttribute("value", ""), "" === t.firstChild.getAttribute("value")
		}) || o("value", function (t, e, n) {
			if (!n && "input" === t.nodeName.toLowerCase()) return t.defaultValue
		}), r(function (t) {
			return null == t.getAttribute("disabled")
		}) || o(et, function (t, e, n) {
			var i;
			if (!n) return !0 === t[e] ? e.toLowerCase() : (i = t.getAttributeNode(e)) && i.specified ? i.value : null
		}), e
	}(t);
	ft.find = yt, ft.expr = yt.selectors, ft.expr[":"] = ft.expr.pseudos, ft.uniqueSort = ft.unique = yt.uniqueSort, ft.text = yt.getText, ft.isXMLDoc = yt.isXML, ft.contains = yt.contains;
	var bt = function (t, e, n) {
			for (var i = [], r = n !== undefined;
				(t = t[e]) && 9 !== t.nodeType;)
				if (1 === t.nodeType) {
					if (r && ft(t).is(n)) break;
					i.push(t)
				}
			return i
		},
		_t = function (t, e) {
			for (var n = []; t; t = t.nextSibling) 1 === t.nodeType && t !== e && n.push(t);
			return n
		},
		Et = ft.expr.match.needsContext,
		kt = /^<([\w-]+)\s*\/?>(?:<\/\1>|)$/,
		wt = /^.[^:#\[\.,]*$/;
	ft.filter = function (t, e, n) {
		var i = e[0];
		return n && (t = ":not(" + t + ")"), 1 === e.length && 1 === i.nodeType ? ft.find.matchesSelector(i, t) ? [i] : [] : ft.find.matches(t, ft.grep(e, function (t) {
			return 1 === t.nodeType
		}))
	}, ft.fn.extend({
		find: function (t) {
			var e, n = [],
				i = this,
				r = i.length;
			if ("string" != typeof t) return this.pushStack(ft(t).filter(function () {
				for (e = 0; e < r; e++)
					if (ft.contains(i[e], this)) return !0
			}));
			for (e = 0; e < r; e++) ft.find(t, i[e], n);
			return n = this.pushStack(r > 1 ? ft.unique(n) : n), n.selector = this.selector ? this.selector + " " + t : t, n
		},
		filter: function (t) {
			return this.pushStack(i(this, t || [], !1))
		},
		not: function (t) {
			return this.pushStack(i(this, t || [], !0))
		},
		is: function (t) {
			return !!i(this, "string" == typeof t && Et.test(t) ? ft(t) : t || [], !1).length
		}
	});
	var Ct, xt = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/;
	(ft.fn.init = function (t, e, n) {
		var i, r;
		if (!t) return this;
		if (n = n || Ct, "string" == typeof t) {
			if (!(i = "<" === t.charAt(0) && ">" === t.charAt(t.length - 1) && t.length >= 3 ? [null, t, null] : xt.exec(t)) || !i[1] && e) return !e || e.jquery ? (e || n).find(t) : this.constructor(e).find(t);
			if (i[1]) {
				if (e = e instanceof ft ? e[0] : e, ft.merge(this, ft.parseHTML(i[1], e && e.nodeType ? e.ownerDocument || e : it, !0)), kt.test(i[1]) && ft.isPlainObject(e))
					for (i in e) ft.isFunction(this[i]) ? this[i](e[i]) : this.attr(i, e[i]);
				return this
			}
			if ((r = it.getElementById(i[2])) && r.parentNode) {
				if (r.id !== i[2]) return Ct.find(t);
				this.length = 1, this[0] = r
			}
			return this.context = it, this.selector = t, this
		}
		return t.nodeType ? (this.context = this[0] = t, this.length = 1, this) : ft.isFunction(t) ? "undefined" != typeof n.ready ? n.ready(t) : t(ft) : (t.selector !== undefined && (this.selector = t.selector, this.context = t.context), ft.makeArray(t, this))
	}).prototype = ft.fn, Ct = ft(it);
	var St = /^(?:parents|prev(?:Until|All))/,
		Tt = {
			children: !0,
			contents: !0,
			next: !0,
			prev: !0
		};
	ft.fn.extend({
		has: function (t) {
			var e, n = ft(t, this),
				i = n.length;
			return this.filter(function () {
				for (e = 0; e < i; e++)
					if (ft.contains(this, n[e])) return !0
			})
		},
		closest: function (t, e) {
			for (var n, i = 0, r = this.length, o = [], a = Et.test(t) || "string" != typeof t ? ft(t, e || this.context) : 0; i < r; i++)
				for (n = this[i]; n && n !== e; n = n.parentNode)
					if (n.nodeType < 11 && (a ? a.index(n) > -1 : 1 === n.nodeType && ft.find.matchesSelector(n, t))) {
						o.push(n);
						break
					}
			return this.pushStack(o.length > 1 ? ft.uniqueSort(o) : o)
		},
		index: function (t) {
			return t ? "string" == typeof t ? ft.inArray(this[0], ft(t)) : ft.inArray(t.jquery ? t[0] : t, this) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
		},
		add: function (t, e) {
			return this.pushStack(ft.uniqueSort(ft.merge(this.get(), ft(t, e))))
		},
		addBack: function (t) {
			return this.add(null == t ? this.prevObject : this.prevObject.filter(t))
		}
	}), ft.each({
		parent: function (t) {
			var e = t.parentNode;
			return e && 11 !== e.nodeType ? e : null
		},
		parents: function (t) {
			return bt(t, "parentNode")
		},
		parentsUntil: function (t, e, n) {
			return bt(t, "parentNode", n)
		},
		next: function (t) {
			return r(t, "nextSibling")
		},
		prev: function (t) {
			return r(t, "previousSibling")
		},
		nextAll: function (t) {
			return bt(t, "nextSibling")
		},
		prevAll: function (t) {
			return bt(t, "previousSibling")
		},
		nextUntil: function (t, e, n) {
			return bt(t, "nextSibling", n)
		},
		prevUntil: function (t, e, n) {
			return bt(t, "previousSibling", n)
		},
		siblings: function (t) {
			return _t((t.parentNode || {}).firstChild, t)
		},
		children: function (t) {
			return _t(t.firstChild)
		},
		contents: function (t) {
			return ft.nodeName(t, "iframe") ? t.contentDocument || t.contentWindow.document : ft.merge([], t.childNodes)
		}
	}, function (t, e) {
		ft.fn[t] = function (n, i) {
			var r = ft.map(this, e, n);
			return "Until" !== t.slice(-5) && (i = n), i && "string" == typeof i && (r = ft.filter(i, r)), this.length > 1 && (Tt[t] || (r = ft.uniqueSort(r)), St.test(t) && (r = r.reverse())), this.pushStack(r)
		}
	});
	var At = /\S+/g;
	ft.Callbacks = function (t) {
		t = "string" == typeof t ? o(t) : ft.extend({}, t);
		var e, n, i, r, a = [],
			s = [],
			l = -1,
			u = function () {
				for (r = t.once, i = e = !0; s.length; l = -1)
					for (n = s.shift(); ++l < a.length;) !1 === a[l].apply(n[0], n[1]) && t.stopOnFalse && (l = a.length, n = !1);
				t.memory || (n = !1), e = !1, r && (a = n ? [] : "")
			},
			c = {
				add: function () {
					return a && (n && !e && (l = a.length - 1, s.push(n)), function e(n) {
						ft.each(n, function (n, i) {
							ft.isFunction(i) ? t.unique && c.has(i) || a.push(i) : i && i.length && "string" !== ft.type(i) && e(i)
						})
					}(arguments), n && !e && u()), this
				},
				remove: function () {
					return ft.each(arguments, function (t, e) {
						for (var n;
							(n = ft.inArray(e, a, n)) > -1;) a.splice(n, 1), n <= l && l--
					}), this
				},
				has: function (t) {
					return t ? ft.inArray(t, a) > -1 : a.length > 0
				},
				empty: function () {
					return a && (a = []), this
				},
				disable: function () {
					return r = s = [], a = n = "", this
				},
				disabled: function () {
					return !a
				},
				lock: function () {
					return r = !0, n || c.disable(), this
				},
				locked: function () {
					return !!r
				},
				fireWith: function (t, n) {
					return r || (n = n || [], n = [t, n.slice ? n.slice() : n], s.push(n), e || u()), this
				},
				fire: function () {
					return c.fireWith(this, arguments), this
				},
				fired: function () {
					return !!i
				}
			};
		return c
	}, ft.extend({
		Deferred: function (t) {
			var e = [
					["resolve", "done", ft.Callbacks("once memory"), "resolved"],
					["reject", "fail", ft.Callbacks("once memory"), "rejected"],
					["notify", "progress", ft.Callbacks("memory")]
				],
				n = "pending",
				i = {
					state: function () {
						return n
					},
					always: function () {
						return r.done(arguments).fail(arguments), this
					},
					then: function () {
						var t = arguments;
						return ft.Deferred(function (n) {
							ft.each(e, function (e, o) {
								var a = ft.isFunction(t[e]) && t[e];
								r[o[1]](function () {
									var t = a && a.apply(this, arguments);
									t && ft.isFunction(t.promise) ? t.promise().progress(n.notify).done(n.resolve).fail(n.reject) : n[o[0] + "With"](this === i ? n.promise() : this, a ? [t] : arguments)
								})
							}), t = null
						}).promise()
					},
					promise: function (t) {
						return null != t ? ft.extend(t, i) : i
					}
				},
				r = {};
			return i.pipe = i.then, ft.each(e, function (t, o) {
				var a = o[2],
					s = o[3];
				i[o[1]] = a.add, s && a.add(function () {
					n = s
				}, e[1 ^ t][2].disable, e[2][2].lock), r[o[0]] = function () {
					return r[o[0] + "With"](this === r ? i : this, arguments), this
				}, r[o[0] + "With"] = a.fireWith
			}), i.promise(r), t && t.call(r, r), r
		},
		when: function (t) {
			var e, n, i, r = 0,
				o = rt.call(arguments),
				a = o.length,
				s = 1 !== a || t && ft.isFunction(t.promise) ? a : 0,
				l = 1 === s ? t : ft.Deferred(),
				u = function (t, n, i) {
					return function (r) {
						n[t] = this, i[t] = arguments.length > 1 ? rt.call(arguments) : r, i === e ? l.notifyWith(n, i) : --s || l.resolveWith(n, i)
					}
				};
			if (a > 1)
				for (e = new Array(a), n = new Array(a), i = new Array(a); r < a; r++) o[r] && ft.isFunction(o[r].promise) ? o[r].promise().progress(u(r, n, e)).done(u(r, i, o)).fail(l.reject) : --s;
			return s || l.resolveWith(i, o), l.promise()
		}
	});
	var Dt;
	ft.fn.ready = function (t) {
		return ft.ready.promise().done(t), this
	}, ft.extend({
		isReady: !1,
		readyWait: 1,
		holdReady: function (t) {
			t ? ft.readyWait++ : ft.ready(!0)
		},
		ready: function (t) {
			(!0 === t ? --ft.readyWait : ft.isReady) || (ft.isReady = !0, !0 !== t && --ft.readyWait > 0 || (Dt.resolveWith(it, [ft]), ft.fn.triggerHandler && (ft(it).triggerHandler("ready"), ft(it).off("ready"))))
		}
	}), ft.ready.promise = function (e) {
		if (!Dt)
			if (Dt = ft.Deferred(), "complete" === it.readyState || "loading" !== it.readyState && !it.documentElement.doScroll) t.setTimeout(ft.ready);
			else if (it.addEventListener) it.addEventListener("DOMContentLoaded", s), t.addEventListener("load", s);
		else {
			it.attachEvent("onreadystatechange", s), t.attachEvent("onload", s);
			var n = !1;
			try {
				n = null == t.frameElement && it.documentElement
			} catch (t) {}
			n && n.doScroll && function e() {
				if (!ft.isReady) {
					try {
						n.doScroll("left")
					} catch (n) {
						return t.setTimeout(e, 50)
					}
					a(), ft.ready()
				}
			}()
		}
		return Dt.promise(e)
	}, ft.ready.promise();
	var Ot;
	for (Ot in ft(pt)) break;
	pt.ownFirst = "0" === Ot, pt.inlineBlockNeedsLayout = !1, ft(function () {
			var t, e, n, i;
			(n = it.getElementsByTagName("body")[0]) && n.style && (e = it.createElement("div"), i = it.createElement("div"), i.style.cssText = "position:absolute;border:0;width:0;height:0;top:0;left:-9999px", n.appendChild(i).appendChild(e), "undefined" != typeof e.style.zoom && (e.style.cssText = "display:inline;margin:0;border:0;padding:1px;width:1px;zoom:1", pt.inlineBlockNeedsLayout = t = 3 === e.offsetWidth, t && (n.style.zoom = 1)), n.removeChild(i))
		}),
		function () {
			var t = it.createElement("div");
			pt.deleteExpando = !0;
			try {
				delete t.test
			} catch (t) {
				pt.deleteExpando = !1
			}
			t = null
		}();
	var Nt = function (t) {
			var e = ft.noData[(t.nodeName + " ").toLowerCase()],
				n = +t.nodeType || 1;
			return (1 === n || 9 === n) && (!e || !0 !== e && t.getAttribute("classid") === e)
		},
		It = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
		Pt = /([A-Z])/g;
	ft.extend({
			cache: {},
			noData: {
				"applet ": !0,
				"embed ": !0,
				"object ": "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
			},
			hasData: function (t) {
				return !!(t = t.nodeType ? ft.cache[t[ft.expando]] : t[ft.expando]) && !u(t)
			},
			data: function (t, e, n) {
				return c(t, e, n)
			},
			removeData: function (t, e) {
				return p(t, e)
			},
			_data: function (t, e, n) {
				return c(t, e, n, !0)
			},
			_removeData: function (t, e) {
				return p(t, e, !0)
			}
		}), ft.fn.extend({
			data: function (t, e) {
				var n, i, r, o = this[0],
					a = o && o.attributes;
				if (t === undefined) {
					if (this.length && (r = ft.data(o), 1 === o.nodeType && !ft._data(o, "parsedAttrs"))) {
						for (n = a.length; n--;) a[n] && (i = a[n].name, 0 === i.indexOf("data-") && (i = ft.camelCase(i.slice(5)), l(o, i, r[i])));
						ft._data(o, "parsedAttrs", !0)
					}
					return r
				}
				return "object" == typeof t ? this.each(function () {
					ft.data(this, t)
				}) : arguments.length > 1 ? this.each(function () {
					ft.data(this, t, e)
				}) : o ? l(o, t, ft.data(o, t)) : undefined
			},
			removeData: function (t) {
				return this.each(function () {
					ft.removeData(this, t)
				})
			}
		}), ft.extend({
			queue: function (t, e, n) {
				var i;
				if (t) return e = (e || "fx") + "queue", i = ft._data(t, e), n && (!i || ft.isArray(n) ? i = ft._data(t, e, ft.makeArray(n)) : i.push(n)), i || []
			},
			dequeue: function (t, e) {
				e = e || "fx";
				var n = ft.queue(t, e),
					i = n.length,
					r = n.shift(),
					o = ft._queueHooks(t, e),
					a = function () {
						ft.dequeue(t, e)
					};
				"inprogress" === r && (r = n.shift(), i--), r && ("fx" === e && n.unshift("inprogress"), delete o.stop, r.call(t, a, o)), !i && o && o.empty.fire()
			},
			_queueHooks: function (t, e) {
				var n = e + "queueHooks";
				return ft._data(t, n) || ft._data(t, n, {
					empty: ft.Callbacks("once memory").add(function () {
						ft._removeData(t, e + "queue"), ft._removeData(t, n)
					})
				})
			}
		}), ft.fn.extend({
			queue: function (t, e) {
				var n = 2;
				return "string" != typeof t && (e = t, t = "fx", n--), arguments.length < n ? ft.queue(this[0], t) : e === undefined ? this : this.each(function () {
					var n = ft.queue(this, t, e);
					ft._queueHooks(this, t), "fx" === t && "inprogress" !== n[0] && ft.dequeue(this, t)
				})
			},
			dequeue: function (t) {
				return this.each(function () {
					ft.dequeue(this, t)
				})
			},
			clearQueue: function (t) {
				return this.queue(t || "fx", [])
			},
			promise: function (t, e) {
				var n, i = 1,
					r = ft.Deferred(),
					o = this,
					a = this.length,
					s = function () {
						--i || r.resolveWith(o, [o])
					};
				for ("string" != typeof t && (e = t, t = undefined), t = t || "fx"; a--;)(n = ft._data(o[a], t + "queueHooks")) && n.empty && (i++, n.empty.add(s));
				return s(), r.promise(e)
			}
		}),
		function () {
			var t;
			pt.shrinkWrapBlocks = function () {
				if (null != t) return t;
				t = !1;
				var e, n, i;
				return (n = it.getElementsByTagName("body")[0]) && n.style ? (e = it.createElement("div"), i = it.createElement("div"), i.style.cssText = "position:absolute;border:0;width:0;height:0;top:0;left:-9999px", n.appendChild(i).appendChild(e), "undefined" != typeof e.style.zoom && (e.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:1px;width:1px;zoom:1", e.appendChild(it.createElement("div")).style.width = "5px", t = 3 !== e.offsetWidth), n.removeChild(i), t) : void 0
			}
		}();
	var Lt = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,
		Rt = new RegExp("^(?:([+-])=|)(" + Lt + ")([a-z%]*)$", "i"),
		Mt = ["Top", "Right", "Bottom", "Left"],
		jt = function (t, e) {
			return t = e || t, "none" === ft.css(t, "display") || !ft.contains(t.ownerDocument, t)
		},
		Ht = function (t, e, n, i, r, o, a) {
			var s = 0,
				l = t.length,
				u = null == n;
			if ("object" === ft.type(n)) {
				r = !0;
				for (s in n) Ht(t, e, s, n[s], !0, o, a)
			} else if (i !== undefined && (r = !0, ft.isFunction(i) || (a = !0), u && (a ? (e.call(t, i), e = null) : (u = e, e = function (t, e, n) {
					return u.call(ft(t), n)
				})), e))
				for (; s < l; s++) e(t[s], n, a ? i : i.call(t[s], s, e(t[s], n)));
			return r ? t : u ? e.call(t) : l ? e(t[0], n) : o
		},
		Ft = /^(?:checkbox|radio)$/i,
		qt = /<([\w:-]+)/,
		Bt = /^$|\/(?:java|ecma)script/i,
		Wt = /^\s+/,
		Ut = "abbr|article|aside|audio|bdi|canvas|data|datalist|details|dialog|figcaption|figure|footer|header|hgroup|main|mark|meter|nav|output|picture|progress|section|summary|template|time|video";
	! function () {
		var t = it.createElement("div"),
			e = it.createDocumentFragment(),
			n = it.createElement("input");
		t.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", pt.leadingWhitespace = 3 === t.firstChild.nodeType, pt.tbody = !t.getElementsByTagName("tbody").length, pt.htmlSerialize = !!t.getElementsByTagName("link").length, pt.html5Clone = "<:nav></:nav>" !== it.createElement("nav").cloneNode(!0).outerHTML, n.type = "checkbox", n.checked = !0, e.appendChild(n), pt.appendChecked = n.checked, t.innerHTML = "<textarea>x</textarea>", pt.noCloneChecked = !!t.cloneNode(!0).lastChild.defaultValue, e.appendChild(t), n = it.createElement("input"), n.setAttribute("type", "radio"), n.setAttribute("checked", "checked"), n.setAttribute("name", "t"), t.appendChild(n), pt.checkClone = t.cloneNode(!0).cloneNode(!0).lastChild.checked, pt.noCloneEvent = !!t.addEventListener, t[ft.expando] = 1, pt.attributes = !t.getAttribute(ft.expando)
	}();
	var Vt = {
		option: [1, "<select multiple='multiple'>", "</select>"],
		legend: [1, "<fieldset>", "</fieldset>"],
		area: [1, "<map>", "</map>"],
		param: [1, "<object>", "</object>"],
		thead: [1, "<table>", "</table>"],
		tr: [2, "<table><tbody>", "</tbody></table>"],
		col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
		td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
		_default: pt.htmlSerialize ? [0, "", ""] : [1, "X<div>", "</div>"]
	};
	Vt.optgroup = Vt.option, Vt.tbody = Vt.tfoot = Vt.colgroup = Vt.caption = Vt.thead, Vt.th = Vt.td;
	var Gt = /<|&#?\w+;/,
		$t = /<tbody/i;
	! function () {
		var e, n, i = it.createElement("div");
		for (e in {
				submit: !0,
				change: !0,
				focusin: !0
			}) n = "on" + e, (pt[e] = n in t) || (i.setAttribute(n, "t"), pt[e] = !1 === i.attributes[n].expando);
		i = null
	}();
	var zt = /^(?:input|select|textarea)$/i,
		Kt = /^key/,
		Qt = /^(?:mouse|pointer|contextmenu|drag|drop)|click/,
		Yt = /^(?:focusinfocus|focusoutblur)$/,
		Xt = /^([^.]*)(?:\.(.+)|)/;
	ft.event = {
		global: {},
		add: function (t, e, n, i, r) {
			var o, a, s, l, u, c, p, d, f, h, m, g = ft._data(t);
			if (g) {
				for (n.handler && (l = n, n = l.handler, r = l.selector), n.guid || (n.guid = ft.guid++), (a = g.events) || (a = g.events = {}), (c = g.handle) || (c = g.handle = function (t) {
						return void 0 === ft || t && ft.event.triggered === t.type ? undefined : ft.event.dispatch.apply(c.elem, arguments)
					}, c.elem = t), e = (e || "").match(At) || [""], s = e.length; s--;) o = Xt.exec(e[s]) || [], f = m = o[1], h = (o[2] || "").split(".").sort(), f && (u = ft.event.special[f] || {}, f = (r ? u.delegateType : u.bindType) || f, u = ft.event.special[f] || {}, p = ft.extend({
					type: f,
					origType: m,
					data: i,
					handler: n,
					guid: n.guid,
					selector: r,
					needsContext: r && ft.expr.match.needsContext.test(r),
					namespace: h.join(".")
				}, l), (d = a[f]) || (d = a[f] = [], d.delegateCount = 0, u.setup && !1 !== u.setup.call(t, i, h, c) || (t.addEventListener ? t.addEventListener(f, c, !1) : t.attachEvent && t.attachEvent("on" + f, c))), u.add && (u.add.call(t, p), p.handler.guid || (p.handler.guid = n.guid)), r ? d.splice(d.delegateCount++, 0, p) : d.push(p), ft.event.global[f] = !0);
				t = null
			}
		},
		remove: function (t, e, n, i, r) {
			var o, a, s, l, u, c, p, d, f, h, m, g = ft.hasData(t) && ft._data(t);
			if (g && (c = g.events)) {
				for (e = (e || "").match(At) || [""], u = e.length; u--;)
					if (s = Xt.exec(e[u]) || [], f = m = s[1], h = (s[2] || "").split(".").sort(), f) {
						for (p = ft.event.special[f] || {}, f = (i ? p.delegateType : p.bindType) || f, d = c[f] || [], s = s[2] && new RegExp("(^|\\.)" + h.join("\\.(?:.*\\.|)") + "(\\.|$)"), l = o = d.length; o--;) a = d[o], !r && m !== a.origType || n && n.guid !== a.guid || s && !s.test(a.namespace) || i && i !== a.selector && ("**" !== i || !a.selector) || (d.splice(o, 1), a.selector && d.delegateCount--, p.remove && p.remove.call(t, a));
						l && !d.length && (p.teardown && !1 !== p.teardown.call(t, h, g.handle) || ft.removeEvent(t, f, g.handle), delete c[f])
					} else
						for (f in c) ft.event.remove(t, f + e[u], n, i, !0);
				ft.isEmptyObject(c) && (delete g.handle, ft._removeData(t, "events"))
			}
		},
		trigger: function (e, n, i, r) {
			var o, a, s, l, u, c, p, d = [i || it],
				f = ct.call(e, "type") ? e.type : e,
				h = ct.call(e, "namespace") ? e.namespace.split(".") : [];
			if (s = c = i = i || it, 3 !== i.nodeType && 8 !== i.nodeType && !Yt.test(f + ft.event.triggered) && (f.indexOf(".") > -1 && (h = f.split("."), f = h.shift(), h.sort()), a = f.indexOf(":") < 0 && "on" + f, e = e[ft.expando] ? e : new ft.Event(f, "object" == typeof e && e), e.isTrigger = r ? 2 : 3, e.namespace = h.join("."), e.rnamespace = e.namespace ? new RegExp("(^|\\.)" + h.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, e.result = undefined, e.target || (e.target = i), n = null == n ? [e] : ft.makeArray(n, [e]), u = ft.event.special[f] || {}, r || !u.trigger || !1 !== u.trigger.apply(i, n))) {
				if (!r && !u.noBubble && !ft.isWindow(i)) {
					for (l = u.delegateType || f, Yt.test(l + f) || (s = s.parentNode); s; s = s.parentNode) d.push(s), c = s;
					c === (i.ownerDocument || it) && d.push(c.defaultView || c.parentWindow || t)
				}
				for (p = 0;
					(s = d[p++]) && !e.isPropagationStopped();) e.type = p > 1 ? l : u.bindType || f, o = (ft._data(s, "events") || {})[e.type] && ft._data(s, "handle"), o && o.apply(s, n), (o = a && s[a]) && o.apply && Nt(s) && (e.result = o.apply(s, n), !1 === e.result && e.preventDefault());
				if (e.type = f, !r && !e.isDefaultPrevented() && (!u._default || !1 === u._default.apply(d.pop(), n)) && Nt(i) && a && i[f] && !ft.isWindow(i)) {
					c = i[a], c && (i[a] = null), ft.event.triggered = f;
					try {
						i[f]()
					} catch (t) {}
					ft.event.triggered = undefined, c && (i[a] = c)
				}
				return e.result
			}
		},
		dispatch: function (t) {
			t = ft.event.fix(t);
			var e, n, i, r, o, a = [],
				s = rt.call(arguments),
				l = (ft._data(this, "events") || {})[t.type] || [],
				u = ft.event.special[t.type] || {};
			if (s[0] = t, t.delegateTarget = this, !u.preDispatch || !1 !== u.preDispatch.call(this, t)) {
				for (a = ft.event.handlers.call(this, t, l), e = 0;
					(r = a[e++]) && !t.isPropagationStopped();)
					for (t.currentTarget = r.elem, n = 0;
						(o = r.handlers[n++]) && !t.isImmediatePropagationStopped();) t.rnamespace && !t.rnamespace.test(o.namespace) || (t.handleObj = o, t.data = o.data, (i = ((ft.event.special[o.origType] || {}).handle || o.handler).apply(r.elem, s)) !== undefined && !1 === (t.result = i) && (t.preventDefault(), t.stopPropagation()));
				return u.postDispatch && u.postDispatch.call(this, t), t.result
			}
		},
		handlers: function (t, e) {
			var n, i, r, o, a = [],
				s = e.delegateCount,
				l = t.target;
			if (s && l.nodeType && ("click" !== t.type || isNaN(t.button) || t.button < 1))
				for (; l != this; l = l.parentNode || this)
					if (1 === l.nodeType && (!0 !== l.disabled || "click" !== t.type)) {
						for (i = [], n = 0; n < s; n++) o = e[n], r = o.selector + " ", i[r] === undefined && (i[r] = o.needsContext ? ft(r, this).index(l) > -1 : ft.find(r, this, null, [l]).length), i[r] && i.push(o);
						i.length && a.push({
							elem: l,
							handlers: i
						})
					}
			return s < e.length && a.push({
				elem: this,
				handlers: e.slice(s)
			}), a
		},
		fix: function (t) {
			if (t[ft.expando]) return t;
			var e, n, i, r = t.type,
				o = t,
				a = this.fixHooks[r];
			for (a || (this.fixHooks[r] = a = Qt.test(r) ? this.mouseHooks : Kt.test(r) ? this.keyHooks : {}), i = a.props ? this.props.concat(a.props) : this.props, t = new ft.Event(o), e = i.length; e--;) n = i[e], t[n] = o[n];
			return t.target || (t.target = o.srcElement || it), 3 === t.target.nodeType && (t.target = t.target.parentNode), t.metaKey = !!t.metaKey, a.filter ? a.filter(t, o) : t
		},
		props: "altKey bubbles cancelable ctrlKey currentTarget detail eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
		fixHooks: {},
		keyHooks: {
			props: "char charCode key keyCode".split(" "),
			filter: function (t, e) {
				return null == t.which && (t.which = null != e.charCode ? e.charCode : e.keyCode), t
			}
		},
		mouseHooks: {
			props: "button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
			filter: function (t, e) {
				var n, i, r, o = e.button,
					a = e.fromElement;
				return null == t.pageX && null != e.clientX && (i = t.target.ownerDocument || it, r = i.documentElement, n = i.body, t.pageX = e.clientX + (r && r.scrollLeft || n && n.scrollLeft || 0) - (r && r.clientLeft || n && n.clientLeft || 0), t.pageY = e.clientY + (r && r.scrollTop || n && n.scrollTop || 0) - (r && r.clientTop || n && n.clientTop || 0)), !t.relatedTarget && a && (t.relatedTarget = a === t.target ? e.toElement : a), t.which || o === undefined || (t.which = 1 & o ? 1 : 2 & o ? 3 : 4 & o ? 2 : 0), t
			}
		},
		special: {
			load: {
				noBubble: !0
			},
			focus: {
				trigger: function () {
					if (this !== _() && this.focus) try {
						return this.focus(), !1
					} catch (t) {}
				},
				delegateType: "focusin"
			},
			blur: {
				trigger: function () {
					if (this === _() && this.blur) return this.blur(), !1
				},
				delegateType: "focusout"
			},
			click: {
				trigger: function () {
					if (ft.nodeName(this, "input") && "checkbox" === this.type && this.click) return this.click(), !1
				},
				_default: function (t) {
					return ft.nodeName(t.target, "a")
				}
			},
			beforeunload: {
				postDispatch: function (t) {
					t.result !== undefined && t.originalEvent && (t.originalEvent.returnValue = t.result)
				}
			}
		},
		simulate: function (t, e, n) {
			var i = ft.extend(new ft.Event, n, {
				type: t,
				isSimulated: !0
			});
			ft.event.trigger(i, null, e), i.isDefaultPrevented() && n.preventDefault()
		}
	}, ft.removeEvent = it.removeEventListener ? function (t, e, n) {
		t.removeEventListener && t.removeEventListener(e, n)
	} : function (t, e, n) {
		var i = "on" + e;
		t.detachEvent && ("undefined" == typeof t[i] && (t[i] = null), t.detachEvent(i, n))
	}, ft.Event = function (t, e) {
		if (!(this instanceof ft.Event)) return new ft.Event(t, e);
		t && t.type ? (this.originalEvent = t, this.type = t.type, this.isDefaultPrevented = t.defaultPrevented || t.defaultPrevented === undefined && !1 === t.returnValue ? y : b) : this.type = t, e && ft.extend(this, e), this.timeStamp = t && t.timeStamp || ft.now(), this[ft.expando] = !0
	}, ft.Event.prototype = {
		constructor: ft.Event,
		isDefaultPrevented: b,
		isPropagationStopped: b,
		isImmediatePropagationStopped: b,
		preventDefault: function () {
			var t = this.originalEvent;
			this.isDefaultPrevented = y, t && (t.preventDefault ? t.preventDefault() : t.returnValue = !1)
		},
		stopPropagation: function () {
			var t = this.originalEvent;
			this.isPropagationStopped = y, t && !this.isSimulated && (t.stopPropagation && t.stopPropagation(), t.cancelBubble = !0)
		},
		stopImmediatePropagation: function () {
			var t = this.originalEvent;
			this.isImmediatePropagationStopped = y, t && t.stopImmediatePropagation && t.stopImmediatePropagation(), this.stopPropagation()
		}
	}, ft.each({
		mouseenter: "mouseover",
		mouseleave: "mouseout",
		pointerenter: "pointerover",
		pointerleave: "pointerout"
	}, function (t, e) {
		ft.event.special[t] = {
			delegateType: e,
			bindType: e,
			handle: function (t) {
				var n, i = this,
					r = t.relatedTarget,
					o = t.handleObj;
				return r && (r === i || ft.contains(i, r)) || (t.type = o.origType, n = o.handler.apply(this, arguments), t.type = e), n
			}
		}
	}), pt.submit || (ft.event.special.submit = {
		setup: function () {
			if (ft.nodeName(this, "form")) return !1;
			ft.event.add(this, "click._submit keypress._submit", function (t) {
				var e = t.target,
					n = ft.nodeName(e, "input") || ft.nodeName(e, "button") ? ft.prop(e, "form") : undefined;
				n && !ft._data(n, "submit") && (ft.event.add(n, "submit._submit", function (t) {
					t._submitBubble = !0
				}), ft._data(n, "submit", !0))
			})
		},
		postDispatch: function (t) {
			t._submitBubble && (delete t._submitBubble, this.parentNode && !t.isTrigger && ft.event.simulate("submit", this.parentNode, t))
		},
		teardown: function () {
			if (ft.nodeName(this, "form")) return !1;
			ft.event.remove(this, "._submit")
		}
	}), pt.change || (ft.event.special.change = {
		setup: function () {
			if (zt.test(this.nodeName)) return "checkbox" !== this.type && "radio" !== this.type || (ft.event.add(this, "propertychange._change", function (t) {
				"checked" === t.originalEvent.propertyName && (this._justChanged = !0)
			}), ft.event.add(this, "click._change", function (t) {
				this._justChanged && !t.isTrigger && (this._justChanged = !1), ft.event.simulate("change", this, t)
			})), !1;
			ft.event.add(this, "beforeactivate._change", function (t) {
				var e = t.target;
				zt.test(e.nodeName) && !ft._data(e, "change") && (ft.event.add(e, "change._change", function (t) {
					!this.parentNode || t.isSimulated || t.isTrigger || ft.event.simulate("change", this.parentNode, t)
				}), ft._data(e, "change", !0))
			})
		},
		handle: function (t) {
			var e = t.target;
			if (this !== e || t.isSimulated || t.isTrigger || "radio" !== e.type && "checkbox" !== e.type) return t.handleObj.handler.apply(this, arguments)
		},
		teardown: function () {
			return ft.event.remove(this, "._change"), !zt.test(this.nodeName)
		}
	}), pt.focusin || ft.each({
		focus: "focusin",
		blur: "focusout"
	}, function (t, e) {
		var n = function (t) {
			ft.event.simulate(e, t.target, ft.event.fix(t))
		};
		ft.event.special[e] = {
			setup: function () {
				var i = this.ownerDocument || this,
					r = ft._data(i, e);
				r || i.addEventListener(t, n, !0), ft._data(i, e, (r || 0) + 1)
			},
			teardown: function () {
				var i = this.ownerDocument || this,
					r = ft._data(i, e) - 1;
				r ? ft._data(i, e, r) : (i.removeEventListener(t, n, !0), ft._removeData(i, e))
			}
		}
	}), ft.fn.extend({
		on: function (t, e, n, i) {
			return E(this, t, e, n, i)
		},
		one: function (t, e, n, i) {
			return E(this, t, e, n, i, 1)
		},
		off: function (t, e, n) {
			var i, r;
			if (t && t.preventDefault && t.handleObj) return i = t.handleObj, ft(t.delegateTarget).off(i.namespace ? i.origType + "." + i.namespace : i.origType, i.selector, i.handler), this;
			if ("object" == typeof t) {
				for (r in t) this.off(r, e, t[r]);
				return this
			}
			return !1 !== e && "function" != typeof e || (n = e, e = undefined), !1 === n && (n = b), this.each(function () {
				ft.event.remove(this, t, n, e)
			})
		},
		trigger: function (t, e) {
			return this.each(function () {
				ft.event.trigger(t, e, this)
			})
		},
		triggerHandler: function (t, e) {
			var n = this[0];
			if (n) return ft.event.trigger(t, e, n, !0)
		}
	});
	var Jt = / jQuery\d+="(?:null|\d+)"/g,
		Zt = new RegExp("<(?:" + Ut + ")[\\s/>]", "i"),
		te = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:-]+)[^>]*)\/>/gi,
		ee = /<script|<style|<link/i,
		ne = /checked\s*(?:[^=]|=\s*.checked.)/i,
		ie = /^true\/(.*)/,
		re = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,
		oe = f(it),
		ae = oe.appendChild(it.createElement("div"));
	ft.extend({
		htmlPrefilter: function (t) {
			return t.replace(te, "<$1></$2>")
		},
		clone: function (t, e, n) {
			var i, r, o, a, s, l = ft.contains(t.ownerDocument, t);
			if (pt.html5Clone || ft.isXMLDoc(t) || !Zt.test("<" + t.nodeName + ">") ? o = t.cloneNode(!0) : (ae.innerHTML = t.outerHTML, ae.removeChild(o = ae.firstChild)), !(pt.noCloneEvent && pt.noCloneChecked || 1 !== t.nodeType && 11 !== t.nodeType || ft.isXMLDoc(t)))
				for (i = h(o), s = h(t), a = 0; null != (r = s[a]); ++a) i[a] && S(r, i[a]);
			if (e)
				if (n)
					for (s = s || h(t), i = i || h(o), a = 0; null != (r = s[a]); a++) x(r, i[a]);
				else x(t, o);
			return i = h(o, "script"), i.length > 0 && m(i, !l && h(t, "script")), i = s = r = null, o
		},
		cleanData: function (t, e) {
			for (var n, i, r, o, a = 0, s = ft.expando, l = ft.cache, u = pt.attributes, c = ft.event.special; null != (n = t[a]); a++)
				if ((e || Nt(n)) && (r = n[s], o = r && l[r])) {
					if (o.events)
						for (i in o.events) c[i] ? ft.event.remove(n, i) : ft.removeEvent(n, i, o.handle);
					l[r] && (delete l[r], u || "undefined" == typeof n.removeAttribute ? n[s] = undefined : n.removeAttribute(s), nt.push(r))
				}
		}
	}), ft.fn.extend({
		domManip: T,
		detach: function (t) {
			return A(this, t, !0)
		},
		remove: function (t) {
			return A(this, t)
		},
		text: function (t) {
			return Ht(this, function (t) {
				return t === undefined ? ft.text(this) : this.empty().append((this[0] && this[0].ownerDocument || it).createTextNode(t))
			}, null, t, arguments.length)
		},
		append: function () {
			return T(this, arguments, function (t) {
				if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
					k(this, t).appendChild(t)
				}
			})
		},
		prepend: function () {
			return T(this, arguments, function (t) {
				if (1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
					var e = k(this, t);
					e.insertBefore(t, e.firstChild)
				}
			})
		},
		before: function () {
			return T(this, arguments, function (t) {
				this.parentNode && this.parentNode.insertBefore(t, this)
			})
		},
		after: function () {
			return T(this, arguments, function (t) {
				this.parentNode && this.parentNode.insertBefore(t, this.nextSibling)
			})
		},
		empty: function () {
			for (var t, e = 0; null != (t = this[e]); e++) {
				for (1 === t.nodeType && ft.cleanData(h(t, !1)); t.firstChild;) t.removeChild(t.firstChild);
				t.options && ft.nodeName(t, "select") && (t.options.length = 0)
			}
			return this
		},
		clone: function (t, e) {
			return t = null != t && t, e = null == e ? t : e, this.map(function () {
				return ft.clone(this, t, e)
			})
		},
		html: function (t) {
			return Ht(this, function (t) {
				var e = this[0] || {},
					n = 0,
					i = this.length;
				if (t === undefined) return 1 === e.nodeType ? e.innerHTML.replace(Jt, "") : undefined;
				if ("string" == typeof t && !ee.test(t) && (pt.htmlSerialize || !Zt.test(t)) && (pt.leadingWhitespace || !Wt.test(t)) && !Vt[(qt.exec(t) || ["", ""])[1].toLowerCase()]) {
					t = ft.htmlPrefilter(t);
					try {
						for (; n < i; n++) e = this[n] || {}, 1 === e.nodeType && (ft.cleanData(h(e, !1)), e.innerHTML = t);
						e = 0
					} catch (t) {}
				}
				e && this.empty().append(t)
			}, null, t, arguments.length)
		},
		replaceWith: function () {
			var t = [];
			return T(this, arguments, function (e) {
				var n = this.parentNode;
				ft.inArray(this, t) < 0 && (ft.cleanData(h(this)), n && n.replaceChild(e, this))
			}, t)
		}
	}), ft.each({
		appendTo: "append",
		prependTo: "prepend",
		insertBefore: "before",
		insertAfter: "after",
		replaceAll: "replaceWith"
	}, function (t, e) {
		ft.fn[t] = function (t) {
			for (var n, i = 0, r = [], o = ft(t), a = o.length - 1; i <= a; i++) n = i === a ? this : this.clone(!0), ft(o[i])[e](n), at.apply(r, n.get());
			return this.pushStack(r)
		}
	});
	var se, le = {
			HTML: "block",
			BODY: "block"
		},
		ue = /^margin/,
		ce = new RegExp("^(" + Lt + ")(?!px)[a-z%]+$", "i"),
		pe = function (t, e, n, i) {
			var r, o, a = {};
			for (o in e) a[o] = t.style[o], t.style[o] = e[o];
			r = n.apply(t, i || []);
			for (o in e) t.style[o] = a[o];
			return r
		},
		de = it.documentElement;
	! function () {
		function e() {
			var e, c, p = it.documentElement;
			p.appendChild(l), u.style.cssText = "-webkit-box-sizing:border-box;box-sizing:border-box;position:relative;display:block;margin:auto;border:1px;padding:1px;top:1%;width:50%", n = r = s = !1, i = a = !0, t.getComputedStyle && (c = t.getComputedStyle(u), n = "1%" !== (c || {}).top, s = "2px" === (c || {}).marginLeft, r = "4px" === (c || {
				width: "4px"
			}).width, u.style.marginRight = "50%", i = "4px" === (c || {
				marginRight: "4px"
			}).marginRight, e = u.appendChild(it.createElement("div")), e.style.cssText = u.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0", e.style.marginRight = e.style.width = "0", u.style.width = "1px", a = !parseFloat((t.getComputedStyle(e) || {}).marginRight), u.removeChild(e)), u.style.display = "none", o = 0 === u.getClientRects().length, o && (u.style.display = "", u.innerHTML = "<table><tr><td></td><td>t</td></tr></table>", u.childNodes[0].style.borderCollapse = "separate", e = u.getElementsByTagName("td"), e[0].style.cssText = "margin:0;border:0;padding:0;display:none", (o = 0 === e[0].offsetHeight) && (e[0].style.display = "", e[1].style.display = "none", o = 0 === e[0].offsetHeight)), p.removeChild(l)
		}
		var n, i, r, o, a, s, l = it.createElement("div"),
			u = it.createElement("div");
		u.style && (u.style.cssText = "float:left;opacity:.5", pt.opacity = "0.5" === u.style.opacity, pt.cssFloat = !!u.style.cssFloat, u.style.backgroundClip = "content-box", u.cloneNode(!0).style.backgroundClip = "", pt.clearCloneStyle = "content-box" === u.style.backgroundClip, l = it.createElement("div"), l.style.cssText = "border:0;width:8px;height:0;top:0;left:-9999px;padding:0;margin-top:1px;position:absolute", u.innerHTML = "", l.appendChild(u), pt.boxSizing = "" === u.style.boxSizing || "" === u.style.MozBoxSizing || "" === u.style.WebkitBoxSizing, ft.extend(pt, {
			reliableHiddenOffsets: function () {
				return null == n && e(), o
			},
			boxSizingReliable: function () {
				return null == n && e(), r
			},
			pixelMarginRight: function () {
				return null == n && e(), i
			},
			pixelPosition: function () {
				return null == n && e(), n
			},
			reliableMarginRight: function () {
				return null == n && e(), a
			},
			reliableMarginLeft: function () {
				return null == n && e(), s
			}
		}))
	}();
	var fe, he, me = /^(top|right|bottom|left)$/;
	t.getComputedStyle ? (fe = function (e) {
		var n = e.ownerDocument.defaultView;
		return n && n.opener || (n = t), n.getComputedStyle(e)
	}, he = function (t, e, n) {
		var i, r, o, a, s = t.style;
		return n = n || fe(t), a = n ? n.getPropertyValue(e) || n[e] : undefined, "" !== a && a !== undefined || ft.contains(t.ownerDocument, t) || (a = ft.style(t, e)), n && !pt.pixelMarginRight() && ce.test(a) && ue.test(e) && (i = s.width, r = s.minWidth, o = s.maxWidth, s.minWidth = s.maxWidth = s.width = a, a = n.width, s.width = i, s.minWidth = r, s.maxWidth = o), a === undefined ? a : a + ""
	}) : de.currentStyle && (fe = function (t) {
		return t.currentStyle
	}, he = function (t, e, n) {
		var i, r, o, a, s = t.style;
		return n = n || fe(t), a = n ? n[e] : undefined, null == a && s && s[e] && (a = s[e]), ce.test(a) && !me.test(e) && (i = s.left, r = t.runtimeStyle, o = r && r.left, o && (r.left = t.currentStyle.left), s.left = "fontSize" === e ? "1em" : a, a = s.pixelLeft + "px", s.left = i, o && (r.left = o)), a === undefined ? a : a + "" || "auto"
	});
	var ge = /alpha\([^)]*\)/i,
		ve = /opacity\s*=\s*([^)]*)/i,
		ye = /^(none|table(?!-c[ea]).+)/,
		be = new RegExp("^(" + Lt + ")(.*)$", "i"),
		_e = {
			position: "absolute",
			visibility: "hidden",
			display: "block"
		},
		Ee = {
			letterSpacing: "0",
			fontWeight: "400"
		},
		ke = ["Webkit", "O", "Moz", "ms"],
		we = it.createElement("div").style;
	ft.extend({
		cssHooks: {
			opacity: {
				get: function (t, e) {
					if (e) {
						var n = he(t, "opacity");
						return "" === n ? "1" : n
					}
				}
			}
		},
		cssNumber: {
			animationIterationCount: !0,
			columnCount: !0,
			fillOpacity: !0,
			flexGrow: !0,
			flexShrink: !0,
			fontWeight: !0,
			lineHeight: !0,
			opacity: !0,
			order: !0,
			orphans: !0,
			widows: !0,
			zIndex: !0,
			zoom: !0
		},
		cssProps: {
			"float": pt.cssFloat ? "cssFloat" : "styleFloat"
		},
		style: function (t, e, n, i) {
			if (t && 3 !== t.nodeType && 8 !== t.nodeType && t.style) {
				var r, o, a, s = ft.camelCase(e),
					l = t.style;
				if (e = ft.cssProps[s] || (ft.cssProps[s] = I(s) || s), a = ft.cssHooks[e] || ft.cssHooks[s], n === undefined) return a && "get" in a && (r = a.get(t, !1, i)) !== undefined ? r : l[e];
				if (o = typeof n, "string" === o && (r = Rt.exec(n)) && r[1] && (n = d(t, e, r), o = "number"), null != n && n === n && ("number" === o && (n += r && r[3] || (ft.cssNumber[s] ? "" : "px")), pt.clearCloneStyle || "" !== n || 0 !== e.indexOf("background") || (l[e] = "inherit"), !(a && "set" in a && (n = a.set(t, n, i)) === undefined))) try {
					l[e] = n
				} catch (t) {}
			}
		},
		css: function (t, e, n, i) {
			var r, o, a, s = ft.camelCase(e);
			return e = ft.cssProps[s] || (ft.cssProps[s] = I(s) || s), a = ft.cssHooks[e] || ft.cssHooks[s], a && "get" in a && (o = a.get(t, !0, n)), o === undefined && (o = he(t, e, i)), "normal" === o && e in Ee && (o = Ee[e]), "" === n || n ? (r = parseFloat(o), !0 === n || isFinite(r) ? r || 0 : o) : o
		}
	}), ft.each(["height", "width"], function (t, e) {
		ft.cssHooks[e] = {
			get: function (t, n, i) {
				if (n) return ye.test(ft.css(t, "display")) && 0 === t.offsetWidth ? pe(t, _e, function () {
					return M(t, e, i)
				}) : M(t, e, i)
			},
			set: function (t, n, i) {
				var r = i && fe(t);
				return L(t, n, i ? R(t, e, i, pt.boxSizing && "border-box" === ft.css(t, "boxSizing", !1, r), r) : 0)
			}
		}
	}), pt.opacity || (ft.cssHooks.opacity = {
		get: function (t, e) {
			return ve.test((e && t.currentStyle ? t.currentStyle.filter : t.style.filter) || "") ? .01 * parseFloat(RegExp.$1) + "" : e ? "1" : ""
		},
		set: function (t, e) {
			var n = t.style,
				i = t.currentStyle,
				r = ft.isNumeric(e) ? "alpha(opacity=" + 100 * e + ")" : "",
				o = i && i.filter || n.filter || "";
			n.zoom = 1, (e >= 1 || "" === e) && "" === ft.trim(o.replace(ge, "")) && n.removeAttribute && (n.removeAttribute("filter"), "" === e || i && !i.filter) || (n.filter = ge.test(o) ? o.replace(ge, r) : o + " " + r)
		}
	}), ft.cssHooks.marginRight = N(pt.reliableMarginRight, function (t, e) {
		if (e) return pe(t, {
			display: "inline-block"
		}, he, [t, "marginRight"])
	}), ft.cssHooks.marginLeft = N(pt.reliableMarginLeft, function (t, e) {
		if (e) return (parseFloat(he(t, "marginLeft")) || (ft.contains(t.ownerDocument, t) ? t.getBoundingClientRect().left - pe(t, {
			marginLeft: 0
		}, function () {
			return t.getBoundingClientRect().left
		}) : 0)) + "px"
	}), ft.each({
		margin: "",
		padding: "",
		border: "Width"
	}, function (t, e) {
		ft.cssHooks[t + e] = {
			expand: function (n) {
				for (var i = 0, r = {}, o = "string" == typeof n ? n.split(" ") : [n]; i < 4; i++) r[t + Mt[i] + e] = o[i] || o[i - 2] || o[0];
				return r
			}
		}, ue.test(t) || (ft.cssHooks[t + e].set = L)
	}), ft.fn.extend({
		css: function (t, e) {
			return Ht(this, function (t, e, n) {
				var i, r, o = {},
					a = 0;
				if (ft.isArray(e)) {
					for (i = fe(t), r = e.length; a < r; a++) o[e[a]] = ft.css(t, e[a], !1, i);
					return o
				}
				return n !== undefined ? ft.style(t, e, n) : ft.css(t, e)
			}, t, e, arguments.length > 1)
		},
		show: function () {
			return P(this, !0)
		},
		hide: function () {
			return P(this)
		},
		toggle: function (t) {
			return "boolean" == typeof t ? t ? this.show() : this.hide() : this.each(function () {
				jt(this) ? ft(this).show() : ft(this).hide()
			})
		}
	}), ft.Tween = j, j.prototype = {
		constructor: j,
		init: function (t, e, n, i, r, o) {
			this.elem = t, this.prop = n, this.easing = r || ft.easing._default, this.options = e, this.start = this.now = this.cur(), this.end = i, this.unit = o || (ft.cssNumber[n] ? "" : "px")
		},
		cur: function () {
			var t = j.propHooks[this.prop];
			return t && t.get ? t.get(this) : j.propHooks._default.get(this)
		},
		run: function (t) {
			var e, n = j.propHooks[this.prop];
			return this.options.duration ? this.pos = e = ft.easing[this.easing](t, this.options.duration * t, 0, 1, this.options.duration) : this.pos = e = t, this.now = (this.end - this.start) * e + this.start, this.options.step && this.options.step.call(this.elem, this.now, this), n && n.set ? n.set(this) : j.propHooks._default.set(this), this
		}
	}, j.prototype.init.prototype = j.prototype, j.propHooks = {
		_default: {
			get: function (t) {
				var e;
				return 1 !== t.elem.nodeType || null != t.elem[t.prop] && null == t.elem.style[t.prop] ? t.elem[t.prop] : (e = ft.css(t.elem, t.prop, ""), e && "auto" !== e ? e : 0)
			},
			set: function (t) {
				ft.fx.step[t.prop] ? ft.fx.step[t.prop](t) : 1 !== t.elem.nodeType || null == t.elem.style[ft.cssProps[t.prop]] && !ft.cssHooks[t.prop] ? t.elem[t.prop] = t.now : ft.style(t.elem, t.prop, t.now + t.unit)
			}
		}
	}, j.propHooks.scrollTop = j.propHooks.scrollLeft = {
		set: function (t) {
			t.elem.nodeType && t.elem.parentNode && (t.elem[t.prop] = t.now)
		}
	}, ft.easing = {
		linear: function (t) {
			return t
		},
		swing: function (t) {
			return .5 - Math.cos(t * Math.PI) / 2
		},
		_default: "swing"
	}, ft.fx = j.prototype.init, ft.fx.step = {};
	var Ce, xe, Se = /^(?:toggle|show|hide)$/,
		Te = /queueHooks$/;
	ft.Animation = ft.extend(U, {
			tweeners: {
				"*": [function (t, e) {
					var n = this.createTween(t, e);
					return d(n.elem, t, Rt.exec(e), n), n
				}]
			},
			tweener: function (t, e) {
				ft.isFunction(t) ? (e = t, t = ["*"]) : t = t.match(At);
				for (var n, i = 0, r = t.length; i < r; i++) n = t[i], U.tweeners[n] = U.tweeners[n] || [], U.tweeners[n].unshift(e)
			},
			prefilters: [B],
			prefilter: function (t, e) {
				e ? U.prefilters.unshift(t) : U.prefilters.push(t)
			}
		}), ft.speed = function (t, e, n) {
			var i = t && "object" == typeof t ? ft.extend({}, t) : {
				complete: n || !n && e || ft.isFunction(t) && t,
				duration: t,
				easing: n && e || e && !ft.isFunction(e) && e
			};
			return i.duration = ft.fx.off ? 0 : "number" == typeof i.duration ? i.duration : i.duration in ft.fx.speeds ? ft.fx.speeds[i.duration] : ft.fx.speeds._default, null != i.queue && !0 !== i.queue || (i.queue = "fx"), i.old = i.complete, i.complete = function () {
				ft.isFunction(i.old) && i.old.call(this), i.queue && ft.dequeue(this, i.queue)
			}, i
		}, ft.fn.extend({
			fadeTo: function (t, e, n, i) {
				return this.filter(jt).css("opacity", 0).show().end().animate({
					opacity: e
				}, t, n, i)
			},
			animate: function (t, e, n, i) {
				var r = ft.isEmptyObject(t),
					o = ft.speed(e, n, i),
					a = function () {
						var e = U(this, ft.extend({}, t), o);
						(r || ft._data(this, "finish")) && e.stop(!0)
					};
				return a.finish = a, r || !1 === o.queue ? this.each(a) : this.queue(o.queue, a)
			},
			stop: function (t, e, n) {
				var i = function (t) {
					var e = t.stop;
					delete t.stop, e(n)
				};
				return "string" != typeof t && (n = e, e = t, t = undefined), e && !1 !== t && this.queue(t || "fx", []), this.each(function () {
					var e = !0,
						r = null != t && t + "queueHooks",
						o = ft.timers,
						a = ft._data(this);
					if (r) a[r] && a[r].stop && i(a[r]);
					else
						for (r in a) a[r] && a[r].stop && Te.test(r) && i(a[r]);
					for (r = o.length; r--;) o[r].elem !== this || null != t && o[r].queue !== t || (o[r].anim.stop(n), e = !1, o.splice(r, 1));
					!e && n || ft.dequeue(this, t)
				})
			},
			finish: function (t) {
				return !1 !== t && (t = t || "fx"), this.each(function () {
					var e, n = ft._data(this),
						i = n[t + "queue"],
						r = n[t + "queueHooks"],
						o = ft.timers,
						a = i ? i.length : 0;
					for (n.finish = !0, ft.queue(this, t, []), r && r.stop && r.stop.call(this, !0), e = o.length; e--;) o[e].elem === this && o[e].queue === t && (o[e].anim.stop(!0), o.splice(e, 1));
					for (e = 0; e < a; e++) i[e] && i[e].finish && i[e].finish.call(this);
					delete n.finish
				})
			}
		}), ft.each(["toggle", "show", "hide"], function (t, e) {
			var n = ft.fn[e];
			ft.fn[e] = function (t, i, r) {
				return null == t || "boolean" == typeof t ? n.apply(this, arguments) : this.animate(F(e, !0), t, i, r)
			}
		}), ft.each({
			slideDown: F("show"),
			slideUp: F("hide"),
			slideToggle: F("toggle"),
			fadeIn: {
				opacity: "show"
			},
			fadeOut: {
				opacity: "hide"
			},
			fadeToggle: {
				opacity: "toggle"
			}
		}, function (t, e) {
			ft.fn[t] = function (t, n, i) {
				return this.animate(e, t, n, i)
			}
		}), ft.timers = [], ft.fx.tick = function () {
			var t, e = ft.timers,
				n = 0;
			for (Ce = ft.now(); n < e.length; n++)(t = e[n])() || e[n] !== t || e.splice(n--, 1);
			e.length || ft.fx.stop(), Ce = undefined
		}, ft.fx.timer = function (t) {
			ft.timers.push(t), t() ? ft.fx.start() : ft.timers.pop()
		}, ft.fx.interval = 13, ft.fx.start = function () {
			xe || (xe = t.setInterval(ft.fx.tick, ft.fx.interval))
		}, ft.fx.stop = function () {
			t.clearInterval(xe), xe = null
		}, ft.fx.speeds = {
			slow: 600,
			fast: 200,
			_default: 400
		}, ft.fn.delay = function (e, n) {
			return e = ft.fx ? ft.fx.speeds[e] || e : e, n = n || "fx", this.queue(n, function (n, i) {
				var r = t.setTimeout(n, e);
				i.stop = function () {
					t.clearTimeout(r)
				}
			})
		},
		function () {
			var t, e = it.createElement("input"),
				n = it.createElement("div"),
				i = it.createElement("select"),
				r = i.appendChild(it.createElement("option"));
			n = it.createElement("div"), n.setAttribute("className", "t"), n.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>", t = n.getElementsByTagName("a")[0], e.setAttribute("type", "checkbox"), n.appendChild(e), t = n.getElementsByTagName("a")[0], t.style.cssText = "top:1px", pt.getSetAttribute = "t" !== n.className, pt.style = /top/.test(t.getAttribute("style")), pt.hrefNormalized = "/a" === t.getAttribute("href"), pt.checkOn = !!e.value, pt.optSelected = r.selected, pt.enctype = !!it.createElement("form").enctype, i.disabled = !0, pt.optDisabled = !r.disabled, e = it.createElement("input"), e.setAttribute("value", ""), pt.input = "" === e.getAttribute("value"), e.value = "t", e.setAttribute("type", "radio"), pt.radioValue = "t" === e.value
		}();
	var Ae = /\r/g,
		De = /[\x20\t\r\n\f]+/g;
	ft.fn.extend({
		val: function (t) {
			var e, n, i, r = this[0]; {
				if (arguments.length) return i = ft.isFunction(t), this.each(function (n) {
					var r;
					1 === this.nodeType && (r = i ? t.call(this, n, ft(this).val()) : t, null == r ? r = "" : "number" == typeof r ? r += "" : ft.isArray(r) && (r = ft.map(r, function (t) {
						return null == t ? "" : t + ""
					})), (e = ft.valHooks[this.type] || ft.valHooks[this.nodeName.toLowerCase()]) && "set" in e && e.set(this, r, "value") !== undefined || (this.value = r))
				});
				if (r) return (e = ft.valHooks[r.type] || ft.valHooks[r.nodeName.toLowerCase()]) && "get" in e && (n = e.get(r, "value")) !== undefined ? n : (n = r.value, "string" == typeof n ? n.replace(Ae, "") : null == n ? "" : n)
			}
		}
	}), ft.extend({
		valHooks: {
			option: {
				get: function (t) {
					var e = ft.find.attr(t, "value");
					return null != e ? e : ft.trim(ft.text(t)).replace(De, " ")
				}
			},
			select: {
				get: function (t) {
					for (var e, n, i = t.options, r = t.selectedIndex, o = "select-one" === t.type || r < 0, a = o ? null : [], s = o ? r + 1 : i.length, l = r < 0 ? s : o ? r : 0; l < s; l++)
						if (n = i[l], (n.selected || l === r) && (pt.optDisabled ? !n.disabled : null === n.getAttribute("disabled")) && (!n.parentNode.disabled || !ft.nodeName(n.parentNode, "optgroup"))) {
							if (e = ft(n).val(), o) return e;
							a.push(e)
						}
					return a
				},
				set: function (t, e) {
					for (var n, i, r = t.options, o = ft.makeArray(e), a = r.length; a--;)
						if (i = r[a], ft.inArray(ft.valHooks.option.get(i), o) > -1) try {
							i.selected = n = !0
						} catch (t) {
							i.scrollHeight
						} else i.selected = !1;
					return n || (t.selectedIndex = -1), r
				}
			}
		}
	}), ft.each(["radio", "checkbox"], function () {
		ft.valHooks[this] = {
			set: function (t, e) {
				if (ft.isArray(e)) return t.checked = ft.inArray(ft(t).val(), e) > -1
			}
		}, pt.checkOn || (ft.valHooks[this].get = function (t) {
			return null === t.getAttribute("value") ? "on" : t.value
		})
	});
	var Oe, Ne, Ie = ft.expr.attrHandle,
		Pe = /^(?:checked|selected)$/i,
		Le = pt.getSetAttribute,
		Re = pt.input;
	ft.fn.extend({
		attr: function (t, e) {
			return Ht(this, ft.attr, t, e, arguments.length > 1)
		},
		removeAttr: function (t) {
			return this.each(function () {
				ft.removeAttr(this, t)
			})
		}
	}), ft.extend({
		attr: function (t, e, n) {
			var i, r, o = t.nodeType;
			if (3 !== o && 8 !== o && 2 !== o) return "undefined" == typeof t.getAttribute ? ft.prop(t, e, n) : (1 === o && ft.isXMLDoc(t) || (e = e.toLowerCase(), r = ft.attrHooks[e] || (ft.expr.match.bool.test(e) ? Ne : Oe)), n !== undefined ? null === n ? void ft.removeAttr(t, e) : r && "set" in r && (i = r.set(t, n, e)) !== undefined ? i : (t.setAttribute(e, n + ""), n) : r && "get" in r && null !== (i = r.get(t, e)) ? i : (i = ft.find.attr(t, e), null == i ? undefined : i))
		},
		attrHooks: {
			type: {
				set: function (t, e) {
					if (!pt.radioValue && "radio" === e && ft.nodeName(t, "input")) {
						var n = t.value;
						return t.setAttribute("type", e), n && (t.value = n), e
					}
				}
			}
		},
		removeAttr: function (t, e) {
			var n, i, r = 0,
				o = e && e.match(At);
			if (o && 1 === t.nodeType)
				for (; n = o[r++];) i = ft.propFix[n] || n, ft.expr.match.bool.test(n) ? Re && Le || !Pe.test(n) ? t[i] = !1 : t[ft.camelCase("default-" + n)] = t[i] = !1 : ft.attr(t, n, ""), t.removeAttribute(Le ? n : i)
		}
	}), Ne = {
		set: function (t, e, n) {
			return !1 === e ? ft.removeAttr(t, n) : Re && Le || !Pe.test(n) ? t.setAttribute(!Le && ft.propFix[n] || n, n) : t[ft.camelCase("default-" + n)] = t[n] = !0, n
		}
	}, ft.each(ft.expr.match.bool.source.match(/\w+/g), function (t, e) {
		var n = Ie[e] || ft.find.attr;
		Re && Le || !Pe.test(e) ? Ie[e] = function (t, e, i) {
			var r, o;
			return i || (o = Ie[e], Ie[e] = r, r = null != n(t, e, i) ? e.toLowerCase() : null, Ie[e] = o), r
		} : Ie[e] = function (t, e, n) {
			if (!n) return t[ft.camelCase("default-" + e)] ? e.toLowerCase() : null
		}
	}), Re && Le || (ft.attrHooks.value = {
		set: function (t, e, n) {
			if (!ft.nodeName(t, "input")) return Oe && Oe.set(t, e, n);
			t.defaultValue = e
		}
	}), Le || (Oe = {
		set: function (t, e, n) {
			var i = t.getAttributeNode(n);
			if (i || t.setAttributeNode(i = t.ownerDocument.createAttribute(n)), i.value = e += "", "value" === n || e === t.getAttribute(n)) return e
		}
	}, Ie.id = Ie.name = Ie.coords = function (t, e, n) {
		var i;
		if (!n) return (i = t.getAttributeNode(e)) && "" !== i.value ? i.value : null
	}, ft.valHooks.button = {
		get: function (t, e) {
			var n = t.getAttributeNode(e);
			if (n && n.specified) return n.value
		},
		set: Oe.set
	}, ft.attrHooks.contenteditable = {
		set: function (t, e, n) {
			Oe.set(t, "" !== e && e, n)
		}
	}, ft.each(["width", "height"], function (t, e) {
		ft.attrHooks[e] = {
			set: function (t, n) {
				if ("" === n) return t.setAttribute(e, "auto"), n
			}
		}
	})), pt.style || (ft.attrHooks.style = {
		get: function (t) {
			return t.style.cssText || undefined
		},
		set: function (t, e) {
			return t.style.cssText = e + ""
		}
	});
	var Me = /^(?:input|select|textarea|button|object)$/i,
		je = /^(?:a|area)$/i;
	ft.fn.extend({
		prop: function (t, e) {
			return Ht(this, ft.prop, t, e, arguments.length > 1)
		},
		removeProp: function (t) {
			return t = ft.propFix[t] || t, this.each(function () {
				try {
					this[t] = undefined, delete this[t]
				} catch (t) {}
			})
		}
	}), ft.extend({
		prop: function (t, e, n) {
			var i, r, o = t.nodeType;
			if (3 !== o && 8 !== o && 2 !== o) return 1 === o && ft.isXMLDoc(t) || (e = ft.propFix[e] || e, r = ft.propHooks[e]), n !== undefined ? r && "set" in r && (i = r.set(t, n, e)) !== undefined ? i : t[e] = n : r && "get" in r && null !== (i = r.get(t, e)) ? i : t[e]
		},
		propHooks: {
			tabIndex: {
				get: function (t) {
					var e = ft.find.attr(t, "tabindex");
					return e ? parseInt(e, 10) : Me.test(t.nodeName) || je.test(t.nodeName) && t.href ? 0 : -1
				}
			}
		},
		propFix: {
			"for": "htmlFor",
			"class": "className"
		}
	}), pt.hrefNormalized || ft.each(["href", "src"], function (t, e) {
		ft.propHooks[e] = {
			get: function (t) {
				return t.getAttribute(e, 4)
			}
		}
	}), pt.optSelected || (ft.propHooks.selected = {
		get: function (t) {
			var e = t.parentNode;
			return e && (e.selectedIndex, e.parentNode && e.parentNode.selectedIndex), null
		},
		set: function (t) {
			var e = t.parentNode;
			e && (e.selectedIndex, e.parentNode && e.parentNode.selectedIndex)
		}
	}), ft.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function () {
		ft.propFix[this.toLowerCase()] = this
	}), pt.enctype || (ft.propFix.enctype = "encoding");
	var He = /[\t\r\n\f]/g;
	ft.fn.extend({
		addClass: function (t) {
			var e, n, i, r, o, a, s, l = 0;
			if (ft.isFunction(t)) return this.each(function (e) {
				ft(this).addClass(t.call(this, e, V(this)))
			});
			if ("string" == typeof t && t)
				for (e = t.match(At) || []; n = this[l++];)
					if (r = V(n), i = 1 === n.nodeType && (" " + r + " ").replace(He, " ")) {
						for (a = 0; o = e[a++];) i.indexOf(" " + o + " ") < 0 && (i += o + " ");
						s = ft.trim(i), r !== s && ft.attr(n, "class", s)
					}
			return this
		},
		removeClass: function (t) {
			var e, n, i, r, o, a, s, l = 0;
			if (ft.isFunction(t)) return this.each(function (e) {
				ft(this).removeClass(t.call(this, e, V(this)))
			});
			if (!arguments.length) return this.attr("class", "");
			if ("string" == typeof t && t)
				for (e = t.match(At) || []; n = this[l++];)
					if (r = V(n), i = 1 === n.nodeType && (" " + r + " ").replace(He, " ")) {
						for (a = 0; o = e[a++];)
							for (; i.indexOf(" " + o + " ") > -1;) i = i.replace(" " + o + " ", " ");
						s = ft.trim(i), r !== s && ft.attr(n, "class", s)
					}
			return this
		},
		toggleClass: function (t, e) {
			var n = typeof t;
			return "boolean" == typeof e && "string" === n ? e ? this.addClass(t) : this.removeClass(t) : ft.isFunction(t) ? this.each(function (n) {
				ft(this).toggleClass(t.call(this, n, V(this), e), e)
			}) : this.each(function () {
				var e, i, r, o;
				if ("string" === n)
					for (i = 0, r = ft(this), o = t.match(At) || []; e = o[i++];) r.hasClass(e) ? r.removeClass(e) : r.addClass(e);
				else t !== undefined && "boolean" !== n || (e = V(this), e && ft._data(this, "__className__", e), ft.attr(this, "class", e || !1 === t ? "" : ft._data(this, "__className__") || ""))
			})
		},
		hasClass: function (t) {
			var e, n, i = 0;
			for (e = " " + t + " "; n = this[i++];)
				if (1 === n.nodeType && (" " + V(n) + " ").replace(He, " ").indexOf(e) > -1) return !0;
			return !1
		}
	}), ft.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function (t, e) {
		ft.fn[e] = function (t, n) {
			return arguments.length > 0 ? this.on(e, null, t, n) : this.trigger(e)
		}
	}), ft.fn.extend({
		hover: function (t, e) {
			return this.mouseenter(t).mouseleave(e || t)
		}
	});
	var Fe = t.location,
		qe = ft.now(),
		Be = /\?/,
		We = /(,)|(\[|{)|(}|])|"(?:[^"\\\r\n]|\\["\\\/bfnrt]|\\u[\da-fA-F]{4})*"\s*:?|true|false|null|-?(?!0\d)\d+(?:\.\d+|)(?:[eE][+-]?\d+|)/g;
	ft.parseJSON = function (e) {
		if (t.JSON && t.JSON.parse) return t.JSON.parse(e + "");
		var n, i = null,
			r = ft.trim(e + "");
		return r && !ft.trim(r.replace(We, function (t, e, r, o) {
			return n && e && (i = 0), 0 === i ? t : (n = r || e, i += !o - !r, "")
		})) ? Function("return " + r)() : ft.error("Invalid JSON: " + e)
	}, ft.parseXML = function (e) {
		var n, i;
		if (!e || "string" != typeof e) return null;
		try {
			t.DOMParser ? (i = new t.DOMParser, n = i.parseFromString(e, "text/xml")) : (n = new t.ActiveXObject("Microsoft.XMLDOM"), n.async = "false", n.loadXML(e))
		} catch (t) {
			n = undefined
		}
		return n && n.documentElement && !n.getElementsByTagName("parsererror").length || ft.error("Invalid XML: " + e), n
	};
	var Ue = /#.*$/,
		Ve = /([?&])_=[^&]*/,
		Ge = /^(.*?):[ \t]*([^\r\n]*)\r?$/gm,
		$e = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
		ze = /^(?:GET|HEAD)$/,
		Ke = /^\/\//,
		Qe = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/,
		Ye = {},
		Xe = {},
		Je = "*/".concat("*"),
		Ze = Fe.href,
		tn = Qe.exec(Ze.toLowerCase()) || [];
	ft.extend({
		active: 0,
		lastModified: {},
		etag: {},
		ajaxSettings: {
			url: Ze,
			type: "GET",
			isLocal: $e.test(tn[1]),
			global: !0,
			processData: !0,
			async: !0,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			accepts: {
				"*": Je,
				text: "text/plain",
				html: "text/html",
				xml: "application/xml, text/xml",
				json: "application/json, text/javascript"
			},
			contents: {
				xml: /\bxml\b/,
				html: /\bhtml/,
				json: /\bjson\b/
			},
			responseFields: {
				xml: "responseXML",
				text: "responseText",
				json: "responseJSON"
			},
			converters: {
				"* text": String,
				"text html": !0,
				"text json": ft.parseJSON,
				"text xml": ft.parseXML
			},
			flatOptions: {
				url: !0,
				context: !0
			}
		},
		ajaxSetup: function (t, e) {
			return e ? z(z(t, ft.ajaxSettings), e) : z(ft.ajaxSettings, t)
		},
		ajaxPrefilter: G(Ye),
		ajaxTransport: G(Xe),
		ajax: function (e, n) {
			function i(e, n, i, r) {
				var o, p, y, b, E, w = n;
				2 !== _ && (_ = 2, l && t.clearTimeout(l), c = undefined, s = r || "", k.readyState = e > 0 ? 4 : 0, o = e >= 200 && e < 300 || 304 === e, i && (b = K(d, k, i)), b = Q(d, b, k, o), o ? (d.ifModified && (E = k.getResponseHeader("Last-Modified"), E && (ft.lastModified[a] = E), (E = k.getResponseHeader("etag")) && (ft.etag[a] = E)), 204 === e || "HEAD" === d.type ? w = "nocontent" : 304 === e ? w = "notmodified" : (w = b.state, p = b.data, y = b.error, o = !y)) : (y = w, !e && w || (w = "error", e < 0 && (e = 0))), k.status = e, k.statusText = (n || w) + "", o ? m.resolveWith(f, [p, w, k]) : m.rejectWith(f, [k, w, y]), k.statusCode(v), v = undefined, u && h.trigger(o ? "ajaxSuccess" : "ajaxError", [k, d, o ? p : y]), g.fireWith(f, [k, w]), u && (h.trigger("ajaxComplete", [k, d]), --ft.active || ft.event.trigger("ajaxStop")))
			}
			"object" == typeof e && (n = e, e = undefined), n = n || {};
			var r, o, a, s, l, u, c, p, d = ft.ajaxSetup({}, n),
				f = d.context || d,
				h = d.context && (f.nodeType || f.jquery) ? ft(f) : ft.event,
				m = ft.Deferred(),
				g = ft.Callbacks("once memory"),
				v = d.statusCode || {},
				y = {},
				b = {},
				_ = 0,
				E = "canceled",
				k = {
					readyState: 0,
					getResponseHeader: function (t) {
						var e;
						if (2 === _) {
							if (!p)
								for (p = {}; e = Ge.exec(s);) p[e[1].toLowerCase()] = e[2];
							e = p[t.toLowerCase()]
						}
						return null == e ? null : e
					},
					getAllResponseHeaders: function () {
						return 2 === _ ? s : null
					},
					setRequestHeader: function (t, e) {
						var n = t.toLowerCase();
						return _ || (t = b[n] = b[n] || t, y[t] = e), this
					},
					overrideMimeType: function (t) {
						return _ || (d.mimeType = t), this
					},
					statusCode: function (t) {
						var e;
						if (t)
							if (_ < 2)
								for (e in t) v[e] = [v[e], t[e]];
							else k.always(t[k.status]);
						return this
					},
					abort: function (t) {
						var e = t || E;
						return c && c.abort(e), i(0, e), this
					}
				};
			if (m.promise(k).complete = g.add, k.success = k.done, k.error = k.fail, d.url = ((e || d.url || Ze) + "").replace(Ue, "").replace(Ke, tn[1] + "//"), d.type = n.method || n.type || d.method || d.type, d.dataTypes = ft.trim(d.dataType || "*").toLowerCase().match(At) || [""], null == d.crossDomain && (r = Qe.exec(d.url.toLowerCase()), d.crossDomain = !(!r || r[1] === tn[1] && r[2] === tn[2] && (r[3] || ("http:" === r[1] ? "80" : "443")) === (tn[3] || ("http:" === tn[1] ? "80" : "443")))), d.data && d.processData && "string" != typeof d.data && (d.data = ft.param(d.data, d.traditional)), $(Ye, d, n, k), 2 === _) return k;
			u = ft.event && d.global, u && 0 == ft.active++ && ft.event.trigger("ajaxStart"), d.type = d.type.toUpperCase(), d.hasContent = !ze.test(d.type), a = d.url, d.hasContent || (d.data && (a = d.url += (Be.test(a) ? "&" : "?") + d.data, delete d.data), !1 === d.cache && (d.url = Ve.test(a) ? a.replace(Ve, "$1_=" + qe++) : a + (Be.test(a) ? "&" : "?") + "_=" + qe++)), d.ifModified && (ft.lastModified[a] && k.setRequestHeader("If-Modified-Since", ft.lastModified[a]), ft.etag[a] && k.setRequestHeader("If-None-Match", ft.etag[a])), (d.data && d.hasContent && !1 !== d.contentType || n.contentType) && k.setRequestHeader("Content-Type", d.contentType), k.setRequestHeader("Accept", d.dataTypes[0] && d.accepts[d.dataTypes[0]] ? d.accepts[d.dataTypes[0]] + ("*" !== d.dataTypes[0] ? ", " + Je + "; q=0.01" : "") : d.accepts["*"]);
			for (o in d.headers) k.setRequestHeader(o, d.headers[o]);
			if (d.beforeSend && (!1 === d.beforeSend.call(f, k, d) || 2 === _)) return k.abort();
			E = "abort";
			for (o in {
					success: 1,
					error: 1,
					complete: 1
				}) k[o](d[o]);
			if (c = $(Xe, d, n, k)) {
				if (k.readyState = 1, u && h.trigger("ajaxSend", [k, d]), 2 === _) return k;
				d.async && d.timeout > 0 && (l = t.setTimeout(function () {
					k.abort("timeout")
				}, d.timeout));
				try {
					_ = 1, c.send(y, i)
				} catch (t) {
					if (!(_ < 2)) throw t;
					i(-1, t)
				}
			} else i(-1, "No Transport");
			return k
		},
		getJSON: function (t, e, n) {
			return ft.get(t, e, n, "json")
		},
		getScript: function (t, e) {
			return ft.get(t, undefined, e, "script")
		}
	}), ft.each(["get", "post"], function (t, e) {
		ft[e] = function (t, n, i, r) {
			return ft.isFunction(n) && (r = r || i, i = n, n = undefined), ft.ajax(ft.extend({
				url: t,
				type: e,
				dataType: r,
				data: n,
				success: i
			}, ft.isPlainObject(t) && t))
		}
	}), ft._evalUrl = function (t) {
		return ft.ajax({
			url: t,
			type: "GET",
			dataType: "script",
			cache: !0,
			async: !1,
			global: !1,
			"throws": !0
		})
	}, ft.fn.extend({
		wrapAll: function (t) {
			if (ft.isFunction(t)) return this.each(function (e) {
				ft(this).wrapAll(t.call(this, e))
			});
			if (this[0]) {
				var e = ft(t, this[0].ownerDocument).eq(0).clone(!0);
				this[0].parentNode && e.insertBefore(this[0]), e.map(function () {
					for (var t = this; t.firstChild && 1 === t.firstChild.nodeType;) t = t.firstChild;
					return t
				}).append(this)
			}
			return this
		},
		wrapInner: function (t) {
			return ft.isFunction(t) ? this.each(function (e) {
				ft(this).wrapInner(t.call(this, e))
			}) : this.each(function () {
				var e = ft(this),
					n = e.contents();
				n.length ? n.wrapAll(t) : e.append(t)
			})
		},
		wrap: function (t) {
			var e = ft.isFunction(t);
			return this.each(function (n) {
				ft(this).wrapAll(e ? t.call(this, n) : t)
			})
		},
		unwrap: function () {
			return this.parent().each(function () {
				ft.nodeName(this, "body") || ft(this).replaceWith(this.childNodes)
			}).end()
		}
	}), ft.expr.filters.hidden = function (t) {
		return pt.reliableHiddenOffsets() ? t.offsetWidth <= 0 && t.offsetHeight <= 0 && !t.getClientRects().length : X(t)
	}, ft.expr.filters.visible = function (t) {
		return !ft.expr.filters.hidden(t)
	};
	var en = /%20/g,
		nn = /\[\]$/,
		rn = /\r?\n/g,
		on = /^(?:submit|button|image|reset|file)$/i,
		an = /^(?:input|select|textarea|keygen)/i;
	ft.param = function (t, e) {
		var n, i = [],
			r = function (t, e) {
				e = ft.isFunction(e) ? e() : null == e ? "" : e, i[i.length] = encodeURIComponent(t) + "=" + encodeURIComponent(e)
			};
		if (e === undefined && (e = ft.ajaxSettings && ft.ajaxSettings.traditional), ft.isArray(t) || t.jquery && !ft.isPlainObject(t)) ft.each(t, function () {
			r(this.name, this.value)
		});
		else
			for (n in t) J(n, t[n], e, r);
		return i.join("&").replace(en, "+")
	}, ft.fn.extend({
		serialize: function () {
			return ft.param(this.serializeArray())
		},
		serializeArray: function () {
			return this.map(function () {
				var t = ft.prop(this, "elements");
				return t ? ft.makeArray(t) : this
			}).filter(function () {
				var t = this.type;
				return this.name && !ft(this).is(":disabled") && an.test(this.nodeName) && !on.test(t) && (this.checked || !Ft.test(t))
			}).map(function (t, e) {
				var n = ft(this).val();
				return null == n ? null : ft.isArray(n) ? ft.map(n, function (t) {
					return {
						name: e.name,
						value: t.replace(rn, "\r\n")
					}
				}) : {
					name: e.name,
					value: n.replace(rn, "\r\n")
				}
			}).get()
		}
	}), ft.ajaxSettings.xhr = t.ActiveXObject !== undefined ? function () {
		return this.isLocal ? tt() : it.documentMode > 8 ? Z() : /^(get|post|head|put|delete|options)$/i.test(this.type) && Z() || tt()
	} : Z;
	var sn = 0,
		ln = {},
		un = ft.ajaxSettings.xhr();
	t.attachEvent && t.attachEvent("onunload", function () {
		for (var t in ln) ln[t](undefined, !0)
	}), pt.cors = !!un && "withCredentials" in un, un = pt.ajax = !!un, un && ft.ajaxTransport(function (e) {
		if (!e.crossDomain || pt.cors) {
			var n;
			return {
				send: function (i, r) {
					var o, a = e.xhr(),
						s = ++sn;
					if (a.open(e.type, e.url, e.async, e.username, e.password), e.xhrFields)
						for (o in e.xhrFields) a[o] = e.xhrFields[o];
					e.mimeType && a.overrideMimeType && a.overrideMimeType(e.mimeType), e.crossDomain || i["X-Requested-With"] || (i["X-Requested-With"] = "XMLHttpRequest");
					for (o in i) i[o] !== undefined && a.setRequestHeader(o, i[o] + "");
					a.send(e.hasContent && e.data || null), n = function (t, i) {
						var o, l, u;
						if (n && (i || 4 === a.readyState))
							if (delete ln[s], n = undefined, a.onreadystatechange = ft.noop, i) 4 !== a.readyState && a.abort();
							else {
								u = {}, o = a.status, "string" == typeof a.responseText && (u.text = a.responseText);
								try {
									l = a.statusText
								} catch (t) {
									l = ""
								}
								o || !e.isLocal || e.crossDomain ? 1223 === o && (o = 204) : o = u.text ? 200 : 404
							}
						u && r(o, l, u, a.getAllResponseHeaders())
					}, e.async ? 4 === a.readyState ? t.setTimeout(n) : a.onreadystatechange = ln[s] = n : n()
				},
				abort: function () {
					n && n(undefined, !0)
				}
			}
		}
	}), ft.ajaxSetup({
		accepts: {
			script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
		},
		contents: {
			script: /\b(?:java|ecma)script\b/
		},
		converters: {
			"text script": function (t) {
				return ft.globalEval(t), t
			}
		}
	}), ft.ajaxPrefilter("script", function (t) {
		t.cache === undefined && (t.cache = !1), t.crossDomain && (t.type = "GET", t.global = !1)
	}), ft.ajaxTransport("script", function (t) {
		if (t.crossDomain) {
			var e, n = it.head || ft("head")[0] || it.documentElement;
			return {
				send: function (i, r) {
					e = it.createElement("script"), e.async = !0, t.scriptCharset && (e.charset = t.scriptCharset), e.src = t.url, e.onload = e.onreadystatechange = function (t, n) {
						(n || !e.readyState || /loaded|complete/.test(e.readyState)) && (e.onload = e.onreadystatechange = null, e.parentNode && e.parentNode.removeChild(e), e = null, n || r(200, "success"))
					}, n.insertBefore(e, n.firstChild)
				},
				abort: function () {
					e && e.onload(undefined, !0)
				}
			}
		}
	});
	var cn = [],
		pn = /(=)\?(?=&|$)|\?\?/;
	ft.ajaxSetup({
		jsonp: "callback",
		jsonpCallback: function () {
			var t = cn.pop() || ft.expando + "_" + qe++;
			return this[t] = !0, t
		}
	}), ft.ajaxPrefilter("json jsonp", function (e, n, i) {
		var r, o, a, s = !1 !== e.jsonp && (pn.test(e.url) ? "url" : "string" == typeof e.data && 0 === (e.contentType || "").indexOf("application/x-www-form-urlencoded") && pn.test(e.data) && "data");
		if (s || "jsonp" === e.dataTypes[0]) return r = e.jsonpCallback = ft.isFunction(e.jsonpCallback) ? e.jsonpCallback() : e.jsonpCallback, s ? e[s] = e[s].replace(pn, "$1" + r) : !1 !== e.jsonp && (e.url += (Be.test(e.url) ? "&" : "?") + e.jsonp + "=" + r), e.converters["script json"] = function () {
			return a || ft.error(r + " was not called"), a[0]
		}, e.dataTypes[0] = "json", o = t[r], t[r] = function () {
			a = arguments
		}, i.always(function () {
			o === undefined ? ft(t).removeProp(r) : t[r] = o, e[r] && (e.jsonpCallback = n.jsonpCallback, cn.push(r)), a && ft.isFunction(o) && o(a[0]), a = o = undefined
		}), "script"
	}), ft.parseHTML = function (t, e, n) {
		if (!t || "string" != typeof t) return null;
		"boolean" == typeof e && (n = e, e = !1), e = e || it;
		var i = kt.exec(t),
			r = !n && [];
		return i ? [e.createElement(i[1])] : (i = v([t], e, r), r && r.length && ft(r).remove(), ft.merge([], i.childNodes))
	};
	var dn = ft.fn.load;
	ft.fn.load = function (t, e, n) {
		if ("string" != typeof t && dn) return dn.apply(this, arguments);
		var i, r, o, a = this,
			s = t.indexOf(" ");
		return s > -1 && (i = ft.trim(t.slice(s, t.length)), t = t.slice(0, s)), ft.isFunction(e) ? (n = e, e = undefined) : e && "object" == typeof e && (r = "POST"), a.length > 0 && ft.ajax({
			url: t,
			type: r || "GET",
			dataType: "html",
			data: e
		}).done(function (t) {
			o = arguments, a.html(i ? ft("<div>").append(ft.parseHTML(t)).find(i) : t)
		}).always(n && function (t, e) {
			a.each(function () {
				n.apply(this, o || [t.responseText, e, t])
			})
		}), this
	}, ft.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function (t, e) {
		ft.fn[e] = function (t) {
			return this.on(e, t)
		}
	}), ft.expr.filters.animated = function (t) {
		return ft.grep(ft.timers, function (e) {
			return t === e.elem
		}).length
	}, ft.offset = {
		setOffset: function (t, e, n) {
			var i, r, o, a, s, l, u, c = ft.css(t, "position"),
				p = ft(t),
				d = {};
			"static" === c && (t.style.position = "relative"), s = p.offset(), o = ft.css(t, "top"), l = ft.css(t, "left"), u = ("absolute" === c || "fixed" === c) && ft.inArray("auto", [o, l]) > -1, u ? (i = p.position(), a = i.top, r = i.left) : (a = parseFloat(o) || 0, r = parseFloat(l) || 0), ft.isFunction(e) && (e = e.call(t, n, ft.extend({}, s))), null != e.top && (d.top = e.top - s.top + a), null != e.left && (d.left = e.left - s.left + r), "using" in e ? e.using.call(t, d) : p.css(d)
		}
	}, ft.fn.extend({
		offset: function (t) {
			if (arguments.length) return t === undefined ? this : this.each(function (e) {
				ft.offset.setOffset(this, t, e)
			});
			var e, n, i = {
					top: 0,
					left: 0
				},
				r = this[0],
				o = r && r.ownerDocument;
			if (o) return e = o.documentElement, ft.contains(e, r) ? ("undefined" != typeof r.getBoundingClientRect && (i = r.getBoundingClientRect()), n = et(o), {
				top: i.top + (n.pageYOffset || e.scrollTop) - (e.clientTop || 0),
				left: i.left + (n.pageXOffset || e.scrollLeft) - (e.clientLeft || 0)
			}) : i
		},
		position: function () {
			if (this[0]) {
				var t, e, n = {
						top: 0,
						left: 0
					},
					i = this[0];
				return "fixed" === ft.css(i, "position") ? e = i.getBoundingClientRect() : (t = this.offsetParent(), e = this.offset(), ft.nodeName(t[0], "html") || (n = t.offset()), n.top += ft.css(t[0], "borderTopWidth", !0), n.left += ft.css(t[0], "borderLeftWidth", !0)), {
					top: e.top - n.top - ft.css(i, "marginTop", !0),
					left: e.left - n.left - ft.css(i, "marginLeft", !0)
				}
			}
		},
		offsetParent: function () {
			return this.map(function () {
				for (var t = this.offsetParent; t && !ft.nodeName(t, "html") && "static" === ft.css(t, "position");) t = t.offsetParent;
				return t || de
			})
		}
	}), ft.each({
		scrollLeft: "pageXOffset",
		scrollTop: "pageYOffset"
	}, function (t, e) {
		var n = /Y/.test(e);
		ft.fn[t] = function (i) {
			return Ht(this, function (t, i, r) {
				var o = et(t);
				if (r === undefined) return o ? e in o ? o[e] : o.document.documentElement[i] : t[i];
				o ? o.scrollTo(n ? ft(o).scrollLeft() : r, n ? r : ft(o).scrollTop()) : t[i] = r
			}, t, i, arguments.length, null)
		}
	}), ft.each(["top", "left"], function (t, e) {
		ft.cssHooks[e] = N(pt.pixelPosition, function (t, n) {
			if (n) return n = he(t, e), ce.test(n) ? ft(t).position()[e] + "px" : n
		})
	}), ft.each({
		Height: "height",
		Width: "width"
	}, function (t, e) {
		ft.each({
			padding: "inner" + t,
			content: e,
			"": "outer" + t
		}, function (n, i) {
			ft.fn[i] = function (i, r) {
				var o = arguments.length && (n || "boolean" != typeof i),
					a = n || (!0 === i || !0 === r ? "margin" : "border");
				return Ht(this, function (e, n, i) {
					var r;
					return ft.isWindow(e) ? e.document.documentElement["client" + t] : 9 === e.nodeType ? (r = e.documentElement, Math.max(e.body["scroll" + t], r["scroll" + t], e.body["offset" + t], r["offset" + t], r["client" + t])) : i === undefined ? ft.css(e, n, a) : ft.style(e, n, i, a)
				}, e, o ? i : undefined, o, null)
			}
		})
	}), ft.fn.extend({
		bind: function (t, e, n) {
			return this.on(t, null, e, n)
		},
		unbind: function (t, e) {
			return this.off(t, null, e)
		},
		delegate: function (t, e, n, i) {
			return this.on(e, t, n, i)
		},
		undelegate: function (t, e, n) {
			return 1 === arguments.length ? this.off(t, "**") : this.off(e, t || "**", n)
		}
	}), ft.fn.size = function () {
		return this.length
	}, ft.fn.andSelf = ft.fn.addBack, "function" == typeof define && define.amd && define("jquery", [], function () {
		return ft
	});
	var fn = t.jQuery,
		hn = t.$;
	return ft.noConflict = function (e) {
		return t.$ === ft && (t.$ = hn), e && t.jQuery === ft && (t.jQuery = fn), ft
	}, e || (t.jQuery = t.$ = ft), ft
}),
function (t, e) {
	"use strict";
	t.rails !== e && t.error("jquery-ujs has already been loaded!");
	var n, i = t(document);
	t.rails = n = {
		linkClickSelector: "a[data-confirm], a[data-method], a[data-remote]:not([disabled]), a[data-disable-with], a[data-disable]",
		buttonClickSelector: "button[data-remote]:not([form]):not(form button), button[data-confirm]:not([form]):not(form button)",
		inputChangeSelector: "select[data-remote], input[data-remote], textarea[data-remote]",
		formSubmitSelector: "form",
		formInputClickSelector: "form input[type=submit], form input[type=image], form button[type=submit], form button:not([type]), input[type=submit][form], input[type=image][form], button[type=submit][form], button[form]:not([type])",
		disableSelector: "input[data-disable-with]:enabled, button[data-disable-with]:enabled, textarea[data-disable-with]:enabled, input[data-disable]:enabled, button[data-disable]:enabled, textarea[data-disable]:enabled",
		enableSelector: "input[data-disable-with]:disabled, button[data-disable-with]:disabled, textarea[data-disable-with]:disabled, input[data-disable]:disabled, button[data-disable]:disabled, textarea[data-disable]:disabled",
		requiredInputSelector: "input[name][required]:not([disabled]), textarea[name][required]:not([disabled])",
		fileInputSelector: "input[name][type=file]:not([disabled])",
		linkDisableSelector: "a[data-disable-with], a[data-disable]",
		buttonDisableSelector: "button[data-remote][data-disable-with], button[data-remote][data-disable]",
		csrfToken: function () {
			return t("meta[name=csrf-token]").attr("content")
		},
		csrfParam: function () {
			return t("meta[name=csrf-param]").attr("content")
		},
		CSRFProtection: function (t) {
			var e = n.csrfToken();
			e && t.setRequestHeader("X-CSRF-Token", e)
		},
		refreshCSRFTokens: function () {
			t('form input[name="' + n.csrfParam() + '"]').val(n.csrfToken())
		},
		fire: function (e, n, i) {
			var r = t.Event(n);
			return e.trigger(r, i), !1 !== r.result
		},
		confirm: function (t) {
			return confirm(t)
		},
		ajax: function (e) {
			return t.ajax(e)
		},
		href: function (t) {
			return t[0].href
		},
		isRemote: function (t) {
			return t.data("remote") !== e && !1 !== t.data("remote")
		},
		handleRemote: function (i) {
			var r, o, a, s, l, u;
			if (n.fire(i, "ajax:before")) {
				if (s = i.data("with-credentials") || null, l = i.data("type") || t.ajaxSettings && t.ajaxSettings.dataType, i.is("form")) {
					r = i.data("ujs:submit-button-formmethod") || i.attr("method"), o = i.data("ujs:submit-button-formaction") || i.attr("action"), a = t(i[0]).serializeArray();
					var c = i.data("ujs:submit-button");
					c && (a.push(c), i.data("ujs:submit-button", null)), i.data("ujs:submit-button-formmethod", null), i.data("ujs:submit-button-formaction", null)
				} else i.is(n.inputChangeSelector) ? (r = i.data("method"), o = i.data("url"), a = i.serialize(), i.data("params") && (a = a + "&" + i.data("params"))) : i.is(n.buttonClickSelector) ? (r = i.data("method") || "get", o = i.data("url"), a = i.serialize(), i.data("params") && (a = a + "&" + i.data("params"))) : (r = i.data("method"), o = n.href(i), a = i.data("params") || null);
				return u = {
					type: r || "GET",
					data: a,
					dataType: l,
					beforeSend: function (t, r) {
						if (r.dataType === e && t.setRequestHeader("accept", "*/*;q=0.5, " + r.accepts.script), !n.fire(i, "ajax:beforeSend", [t, r])) return !1;
						i.trigger("ajax:send", t)
					},
					success: function (t, e, n) {
						i.trigger("ajax:success", [t, e, n])
					},
					complete: function (t, e) {
						i.trigger("ajax:complete", [t, e])
					},
					error: function (t, e, n) {
						i.trigger("ajax:error", [t, e, n])
					},
					crossDomain: n.isCrossDomain(o)
				}, s && (u.xhrFields = {
					withCredentials: s
				}), o && (u.url = o), n.ajax(u)
			}
			return !1
		},
		isCrossDomain: function (t) {
			var e = document.createElement("a");
			e.href = location.href;
			var n = document.createElement("a");
			try {
				return n.href = t, n.href = n.href, !((!n.protocol || ":" === n.protocol) && !n.host || e.protocol + "//" + e.host == n.protocol + "//" + n.host)
			} catch (t) {
				return !0
			}
		},
		handleMethod: function (i) {
			var r = n.href(i),
				o = i.data("method"),
				a = i.attr("target"),
				s = n.csrfToken(),
				l = n.csrfParam(),
				u = t('<form method="post" action="' + r + '"></form>'),
				c = '<input name="_method" value="' + o + '" type="hidden" />';
			l === e || s === e || n.isCrossDomain(r) || (c += '<input name="' + l + '" value="' + s + '" type="hidden" />'), a && u.attr("target", a), u.hide().append(c).appendTo("body"), u.submit()
		},
		formElements: function (e, n) {
			return e.is("form") ? t(e[0].elements).filter(n) : e.find(n)
		},
		disableFormElements: function (e) {
			n.formElements(e, n.disableSelector).each(function () {
				n.disableFormElement(t(this))
			})
		},
		disableFormElement: function (t) {
			var n, i;
			n = t.is("button") ? "html" : "val", i = t.data("disable-with"), i !== e && (t.data("ujs:enable-with", t[n]()), t[n](i)), t.prop("disabled", !0), t.data("ujs:disabled", !0)
		},
		enableFormElements: function (e) {
			n.formElements(e, n.enableSelector).each(function () {
				n.enableFormElement(t(this))
			})
		},
		enableFormElement: function (t) {
			var n = t.is("button") ? "html" : "val";
			t.data("ujs:enable-with") !== e && (t[n](t.data("ujs:enable-with")), t.removeData("ujs:enable-with")), t.prop("disabled", !1), t.removeData("ujs:disabled")
		},
		allowAction: function (t) {
			var e, i = t.data("confirm"),
				r = !1;
			if (!i) return !0;
			if (n.fire(t, "confirm")) {
				try {
					r = n.confirm(i)
				} catch (t) {
					(console.error || console.log).call(console, t.stack || t)
				}
				e = n.fire(t, "confirm:complete", [r])
			}
			return r && e
		},
		blankInputs: function (e, n, i) {
			var r, o, a, s, l = t(),
				u = n || "input,textarea",
				c = e.find(u),
				p = {};
			return c.each(function () {
				r = t(this), r.is("input[type=radio]") ? (s = r.attr("name"), p[s] || (0 === e.find('input[type=radio]:checked[name="' + s + '"]').length && (a = e.find('input[type=radio][name="' + s + '"]'), l = l.add(a)), p[s] = s)) : (o = r.is("input[type=checkbox],input[type=radio]") ? r.is(":checked") : !!r.val()) === i && (l = l.add(r))
			}), !!l.length && l
		},
		nonBlankInputs: function (t, e) {
			return n.blankInputs(t, e, !0)
		},
		stopEverything: function (e) {
			return t(e.target).trigger("ujs:everythingStopped"), e.stopImmediatePropagation(), !1
		},
		disableElement: function (t) {
			var i = t.data("disable-with");
			i !== e && (t.data("ujs:enable-with", t.html()), t.html(i)), t.bind("click.railsDisable", function (t) {
				return n.stopEverything(t)
			}), t.data("ujs:disabled", !0)
		},
		enableElement: function (t) {
			t.data("ujs:enable-with") !== e && (t.html(t.data("ujs:enable-with")), t.removeData("ujs:enable-with")), t.unbind("click.railsDisable"), t.removeData("ujs:disabled")
		}
	}, n.fire(i, "rails:attachBindings") && (t.ajaxPrefilter(function (t, e, i) {
		t.crossDomain || n.CSRFProtection(i)
	}), t(window).on("pageshow.rails", function () {
		t(t.rails.enableSelector).each(function () {
			var e = t(this);
			e.data("ujs:disabled") && t.rails.enableFormElement(e)
		}), t(t.rails.linkDisableSelector).each(function () {
			var e = t(this);
			e.data("ujs:disabled") && t.rails.enableElement(e)
		})
	}), i.on("ajax:complete", n.linkDisableSelector, function () {
		n.enableElement(t(this))
	}), i.on("ajax:complete", n.buttonDisableSelector, function () {
		n.enableFormElement(t(this))
	}), i.on("click.rails", n.linkClickSelector, function (e) {
		var i = t(this),
			r = i.data("method"),
			o = i.data("params"),
			a = e.metaKey || e.ctrlKey;
		if (!n.allowAction(i)) return n.stopEverything(e);
		if (!a && i.is(n.linkDisableSelector) && n.disableElement(i), n.isRemote(i)) {
			if (a && (!r || "GET" === r) && !o) return !0;
			var s = n.handleRemote(i);
			return !1 === s ? n.enableElement(i) : s.fail(function () {
				n.enableElement(i)
			}), !1
		}
		return r ? (n.handleMethod(i), !1) : void 0
	}), i.on("click.rails", n.buttonClickSelector, function (e) {
		var i = t(this);
		if (!n.allowAction(i) || !n.isRemote(i)) return n.stopEverything(e);
		i.is(n.buttonDisableSelector) && n.disableFormElement(i);
		var r = n.handleRemote(i);
		return !1 === r ? n.enableFormElement(i) : r.fail(function () {
			n.enableFormElement(i)
		}), !1
	}), i.on("change.rails", n.inputChangeSelector, function (e) {
		var i = t(this);
		return n.allowAction(i) && n.isRemote(i) ? (n.handleRemote(i), !1) : n.stopEverything(e)
	}), i.on("submit.rails", n.formSubmitSelector, function (i) {
		var r, o, a = t(this),
			s = n.isRemote(a);
		if (!n.allowAction(a)) return n.stopEverything(i);
		if (a.attr("novalidate") === e)
			if (a.data("ujs:formnovalidate-button") === e) {
				if ((r = n.blankInputs(a, n.requiredInputSelector, !1)) && n.fire(a, "ajax:aborted:required", [r])) return n.stopEverything(i)
			} else a.data("ujs:formnovalidate-button", e);
		if (s) {
			if (o = n.nonBlankInputs(a, n.fileInputSelector)) {
				setTimeout(function () {
					n.disableFormElements(a)
				}, 13);
				var l = n.fire(a, "ajax:aborted:file", [o]);
				return l || setTimeout(function () {
					n.enableFormElements(a)
				}, 13), l
			}
			return n.handleRemote(a), !1
		}
		setTimeout(function () {
			n.disableFormElements(a)
		}, 13)
	}), i.on("click.rails", n.formInputClickSelector, function (e) {
		var i = t(this);
		if (!n.allowAction(i)) return n.stopEverything(e);
		var r = i.attr("name"),
			o = r ? {
				name: r,
				value: i.val()
			} : null,
			a = i.closest("form");
		0 === a.length && (a = t("#" + i.attr("form"))), a.data("ujs:submit-button", o), a.data("ujs:formnovalidate-button", i.attr("formnovalidate")), a.data("ujs:submit-button-formaction", i.attr("formaction")), a.data("ujs:submit-button-formmethod", i.attr("formmethod"))
	}), i.on("ajax:send.rails", n.formSubmitSelector, function (e) {
		this === e.target && n.disableFormElements(t(this))
	}), i.on("ajax:complete.rails", n.formSubmitSelector, function (e) {
		this === e.target && n.enableFormElements(t(this))
	}), t(function () {
		n.refreshCSRFTokens()
	}))
}(jQuery),
function (t, e) {
	"object" == typeof exports && "undefined" != typeof module ? module.exports = e() : "function" == typeof define && define.amd ? define(e) : t.Popper = e()
}(this, function () {
	"use strict";

	function t(t) {
		var e = !1,
			n = 0,
			i = document.createElement("span");
		return new MutationObserver(function () {
				t(), e = !1
			}).observe(i, {
				attributes: !0
			}),
			function () {
				e || (e = !0, i.setAttribute("x-index", n), n += 1)
			}
	}

	function e(t) {
		var e = !1;
		return function () {
			e || (e = !0, setTimeout(function () {
				e = !1, t()
			}, lt))
		}
	}

	function n(t) {
		var e = {};
		return t && "[object Function]" === e.toString.call(t)
	}

	function i(t, e) {
		if (1 !== t.nodeType) return [];
		var n = window.getComputedStyle(t, null);
		return e ? n[e] : n
	}

	function r(t) {
		return "HTML" === t.nodeName ? t : t.parentNode || t.host
	}

	function o(t) {
		if (!t || -1 !== ["HTML", "BODY", "#document"].indexOf(t.nodeName)) return window.document.body;
		var e = i(t),
			n = e.overflow,
			a = e.overflowX,
			s = e.overflowY;
		return /(auto|scroll)/.test(n + s + a) ? t : o(r(t))
	}

	function a(t) {
		var e = t && t.offsetParent,
			n = e && e.nodeName;
		return n && "BODY" !== n && "HTML" !== n ? -1 !== ["TD", "TABLE"].indexOf(e.nodeName) && "static" === i(e, "position") ? a(e) : e : window.document.documentElement
	}

	function s(t) {
		var e = t.nodeName;
		return "BODY" !== e && ("HTML" === e || a(t.firstElementChild) === t)
	}

	function l(t) {
		return null !== t.parentNode ? l(t.parentNode) : t
	}

	function u(t, e) {
		if (!(t && t.nodeType && e && e.nodeType)) return window.document.documentElement;
		var n = t.compareDocumentPosition(e) & Node.DOCUMENT_POSITION_FOLLOWING,
			i = n ? t : e,
			r = n ? e : t,
			o = document.createRange();
		o.setStart(i, 0), o.setEnd(r, 0);
		var c = o.commonAncestorContainer;
		if (t !== c && e !== c || i.contains(r)) return s(c) ? c : a(c);
		var p = l(t);
		return p.host ? u(p.host, e) : u(t, l(e).host)
	}

	function c(t) {
		var e = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : "top",
			n = "top" === e ? "scrollTop" : "scrollLeft",
			i = t.nodeName;
		if ("BODY" === i || "HTML" === i) {
			var r = window.document.documentElement;
			return (window.document.scrollingElement || r)[n]
		}
		return t[n]
	}

	function p(t, e) {
		var n = arguments.length > 2 && arguments[2] !== undefined && arguments[2],
			i = c(e, "top"),
			r = c(e, "left"),
			o = n ? -1 : 1;
		return t.top += i * o, t.bottom += i * o, t.left += r * o, t.right += r * o, t
	}

	function d(t, e) {
		var n = "x" === e ? "Left" : "Top",
			i = "Left" === n ? "Right" : "Bottom";
		return +t["border" + n + "Width"].split("px")[0] + +t["border" + i + "Width"].split("px")[0]
	}

	function f(t, e, n, i) {
		return Math.max(e["offset" + t], n["client" + t], n["offset" + t], ft() ? n["offset" + t] + i["margin" + ("Height" === t ? "Top" : "Left")] + i["margin" + ("Height" === t ? "Bottom" : "Right")] : 0)
	}

	function h() {
		var t = window.document.body,
			e = window.document.documentElement,
			n = ft() && window.getComputedStyle(e);
		return {
			height: f("Height", t, e, n),
			width: f("Width", t, e, n)
		}
	}

	function m(t) {
		return vt({}, t, {
			right: t.left + t.width,
			bottom: t.top + t.height
		})
	}

	function g(t) {
		var e = {};
		if (ft()) try {
			e = t.getBoundingClientRect();
			var n = c(t, "top"),
				r = c(t, "left");
			e.top += n, e.left += r, e.bottom += n, e.right += r
		} catch (t) {} else e = t.getBoundingClientRect();
		var o = {
				left: e.left,
				top: e.top,
				width: e.right - e.left,
				height: e.bottom - e.top
			},
			a = "HTML" === t.nodeName ? h() : {},
			s = a.width || t.clientWidth || o.right - o.left,
			l = a.height || t.clientHeight || o.bottom - o.top,
			u = t.offsetWidth - s,
			p = t.offsetHeight - l;
		if (u || p) {
			var f = i(t);
			u -= d(f, "x"), p -= d(f, "y"), o.width -= u, o.height -= p
		}
		return m(o)
	}

	function v(t, e) {
		var n = ft(),
			r = "HTML" === e.nodeName,
			a = g(t),
			s = g(e),
			l = o(t),
			u = i(e),
			c = +u.borderTopWidth.split("px")[0],
			d = +u.borderLeftWidth.split("px")[0],
			f = m({
				top: a.top - s.top - c,
				left: a.left - s.left - d,
				width: a.width,
				height: a.height
			});
		if (f.marginTop = 0, f.marginLeft = 0, !n && r) {
			var h = +u.marginTop.split("px")[0],
				v = +u.marginLeft.split("px")[0];
			f.top -= c - h, f.bottom -= c - h, f.left -= d - v, f.right -= d - v, f.marginTop = h, f.marginLeft = v
		}
		return (n ? e.contains(l) : e === l && "BODY" !== l.nodeName) && (f = p(f, e)), f
	}

	function y(t) {
		var e = window.document.documentElement,
			n = v(t, e),
			i = Math.max(e.clientWidth, window.innerWidth || 0),
			r = Math.max(e.clientHeight, window.innerHeight || 0),
			o = c(e),
			a = c(e, "left");
		return m({
			top: o - n.top + n.marginTop,
			left: a - n.left + n.marginLeft,
			width: i,
			height: r
		})
	}

	function b(t) {
		var e = t.nodeName;
		return "BODY" !== e && "HTML" !== e && ("fixed" === i(t, "position") || b(r(t)))
	}

	function _(t, e, n, i) {
		var a = {
				top: 0,
				left: 0
			},
			s = u(t, e);
		if ("viewport" === i) a = y(s);
		else {
			var l = void 0;
			"scrollParent" === i ? (l = o(r(t)), "BODY" === l.nodeName && (l = window.document.documentElement)) : l = "window" === i ? window.document.documentElement : i;
			var c = v(l, s);
			if ("HTML" !== l.nodeName || b(s)) a = c;
			else {
				var p = h(),
					d = p.height,
					f = p.width;
				a.top += c.top - c.marginTop, a.bottom = d + c.top, a.left += c.left - c.marginLeft, a.right = f + c.left
			}
		}
		return a.left += n, a.top += n, a.right -= n, a.bottom -= n, a
	}

	function E(t) {
		return t.width * t.height
	}

	function k(t, e, n, i, r) {
		var o = arguments.length > 5 && arguments[5] !== undefined ? arguments[5] : 0;
		if (-1 === t.indexOf("auto")) return t;
		var a = _(n, i, o, r),
			s = {
				top: {
					width: a.width,
					height: e.top - a.top
				},
				right: {
					width: a.right - e.right,
					height: a.height
				},
				bottom: {
					width: a.width,
					height: a.bottom - e.bottom
				},
				left: {
					width: e.left - a.left,
					height: a.height
				}
			},
			l = Object.keys(s).map(function (t) {
				return vt({
					key: t
				}, s[t], {
					area: E(s[t])
				})
			}).sort(function (t, e) {
				return e.area - t.area
			}),
			u = l.filter(function (t) {
				var e = t.width,
					i = t.height;
				return e >= n.clientWidth && i >= n.clientHeight
			}),
			c = u.length > 0 ? u[0].key : l[0].key,
			p = t.split("-")[1];
		return c + (p ? "-" + p : "")
	}

	function w(t, e, n) {
		return v(n, u(e, n))
	}

	function C(t) {
		var e = window.getComputedStyle(t),
			n = parseFloat(e.marginTop) + parseFloat(e.marginBottom),
			i = parseFloat(e.marginLeft) + parseFloat(e.marginRight);
		return {
			width: t.offsetWidth + i,
			height: t.offsetHeight + n
		}
	}

	function x(t) {
		var e = {
			left: "right",
			right: "left",
			bottom: "top",
			top: "bottom"
		};
		return t.replace(/left|right|bottom|top/g, function (t) {
			return e[t]
		})
	}

	function S(t, e, n) {
		n = n.split("-")[0];
		var i = C(t),
			r = {
				width: i.width,
				height: i.height
			},
			o = -1 !== ["right", "left"].indexOf(n),
			a = o ? "top" : "left",
			s = o ? "left" : "top",
			l = o ? "height" : "width",
			u = o ? "width" : "height";
		return r[a] = e[a] + e[l] / 2 - i[l] / 2, r[s] = n === s ? e[s] - i[u] : e[x(s)], r
	}

	function T(t, e) {
		return Array.prototype.find ? t.find(e) : t.filter(e)[0]
	}

	function A(t, e, n) {
		if (Array.prototype.findIndex) return t.findIndex(function (t) {
			return t[e] === n
		});
		var i = T(t, function (t) {
			return t[e] === n
		});
		return t.indexOf(i)
	}

	function D(t, e, i) {
		return (i === undefined ? t : t.slice(0, A(t, "name", i))).forEach(function (t) {
			t["function"] && console.warn("`modifier.function` is deprecated, use `modifier.fn`!");
			var i = t["function"] || t.fn;
			t.enabled && n(i) && (e.offsets.popper = m(e.offsets.popper), e.offsets.reference = m(e.offsets.reference), e = i(e, t))
		}), e
	}

	function O() {
		if (!this.state.isDestroyed) {
			var t = {
				instance: this,
				styles: {},
				attributes: {},
				flipped: !1,
				offsets: {}
			};
			t.offsets.reference = w(this.state, this.popper, this.reference), t.placement = k(this.options.placement, t.offsets.reference, this.popper, this.reference, this.options.modifiers.flip.boundariesElement, this.options.modifiers.flip.padding), t.originalPlacement = t.placement, t.offsets.popper = S(this.popper, t.offsets.reference, t.placement), t.offsets.popper.position = "absolute", t = D(this.modifiers, t), this.state.isCreated ? this.options.onUpdate(t) : (this.state.isCreated = !0, this.options.onCreate(t))
		}
	}

	function N(t, e) {
		return t.some(function (t) {
			var n = t.name;
			return t.enabled && n === e
		})
	}

	function I(t) {
		for (var e = [!1, "ms", "Webkit", "Moz", "O"], n = t.charAt(0).toUpperCase() + t.slice(1), i = 0; i < e.length - 1; i++) {
			var r = e[i],
				o = r ? "" + r + n : t;
			if ("undefined" != typeof window.document.body.style[o]) return o
		}
		return null
	}

	function P() {
		return this.state.isDestroyed = !0, N(this.modifiers, "applyStyle") && (this.popper.removeAttribute("x-placement"), this.popper.style.left = "", this.popper.style.position = "", this.popper.style.top = "", this.popper.style[I("transform")] = ""), this.disableEventListeners(), this.options.removeOnDestroy && this.popper.parentNode.removeChild(this.popper), this
	}

	function L(t, e, n, i) {
		var r = "BODY" === t.nodeName,
			a = r ? window : t;
		a.addEventListener(e, n, {
			passive: !0
		}), r || L(o(a.parentNode), e, n, i), i.push(a)
	}

	function R(t, e, n, i) {
		n.updateBound = i, window.addEventListener("resize", n.updateBound, {
			passive: !0
		});
		var r = o(t);
		return L(r, "scroll", n.updateBound, n.scrollParents), n.scrollElement = r, n.eventsEnabled = !0, n
	}

	function M() {
		this.state.eventsEnabled || (this.state = R(this.reference, this.options, this.state, this.scheduleUpdate))
	}

	function j(t, e) {
		return window.removeEventListener("resize", e.updateBound), e.scrollParents.forEach(function (t) {
			t.removeEventListener("scroll", e.updateBound)
		}), e.updateBound = null, e.scrollParents = [], e.scrollElement = null, e.eventsEnabled = !1, e
	}

	function H() {
		this.state.eventsEnabled && (window.cancelAnimationFrame(this.scheduleUpdate), this.state = j(this.reference, this.state))
	}

	function F(t) {
		return "" !== t && !isNaN(parseFloat(t)) && isFinite(t)
	}

	function q(t, e) {
		Object.keys(e).forEach(function (n) {
			var i = ""; - 1 !== ["width", "height", "top", "right", "bottom", "left"].indexOf(n) && F(e[n]) && (i = "px"), t.style[n] = e[n] + i
		})
	}

	function B(t, e) {
		Object.keys(e).forEach(function (n) {
			!1 !== e[n] ? t.setAttribute(n, e[n]) : t.removeAttribute(n)
		})
	}

	function W(t) {
		return q(t.instance.popper, t.styles), B(t.instance.popper, t.attributes), t.offsets.arrow && q(t.arrowElement, t.offsets.arrow), t
	}

	function U(t, e, n, i, r) {
		var o = w(r, e, t),
			a = k(n.placement, o, e, t, n.modifiers.flip.boundariesElement, n.modifiers.flip.padding);
		return e.setAttribute("x-placement", a), q(e, {
			position: "absolute"
		}), n
	}

	function V(t, e) {
		var n = e.x,
			i = e.y,
			r = t.offsets.popper,
			o = T(t.instance.modifiers, function (t) {
				return "applyStyle" === t.name
			}).gpuAcceleration;
		o !== undefined && console.warn("WARNING: `gpuAcceleration` option moved to `computeStyle` modifier and will not be supported in future versions of Popper.js!");
		var s = o !== undefined ? o : e.gpuAcceleration,
			l = a(t.instance.popper),
			u = g(l),
			c = {
				position: r.position
			},
			p = {
				left: Math.floor(r.left),
				top: Math.floor(r.top),
				bottom: Math.floor(r.bottom),
				right: Math.floor(r.right)
			},
			d = "bottom" === n ? "top" : "bottom",
			f = "right" === i ? "left" : "right",
			h = I("transform"),
			m = void 0,
			v = void 0;
		if (v = "bottom" === d ? -u.height + p.bottom : p.top, m = "right" === f ? -u.width + p.right : p.left, s && h) c[h] = "translate3d(" + m + "px, " + v + "px, 0)", c[d] = 0, c[f] = 0, c.willChange = "transform";
		else {
			var y = "bottom" === d ? -1 : 1,
				b = "right" === f ? -1 : 1;
			c[d] = v * y, c[f] = m * b, c.willChange = d + ", " + f
		}
		var _ = {
			"x-placement": t.placement
		};
		return t.attributes = vt({}, _, t.attributes), t.styles = vt({}, c, t.styles), t
	}

	function G(t, e, n) {
		var i = T(t, function (t) {
				return t.name === e
			}),
			r = !!i && t.some(function (t) {
				return t.name === n && t.enabled && t.order < i.order
			});
		if (!r) {
			var o = "`" + e + "`",
				a = "`" + n + "`";
			console.warn(a + " modifier is required by " + o + " modifier in order to work, be sure to include it before " + o + "!")
		}
		return r
	}

	function $(t, e) {
		if (!G(t.instance.modifiers, "arrow", "keepTogether")) return t;
		var n = e.element;
		if ("string" == typeof n) {
			if (!(n = t.instance.popper.querySelector(n))) return t
		} else if (!t.instance.popper.contains(n)) return console.warn("WARNING: `arrow.element` must be child of its popper element!"), t;
		var i = t.placement.split("-")[0],
			r = t.offsets,
			o = r.popper,
			a = r.reference,
			s = -1 !== ["left", "right"].indexOf(i),
			l = s ? "height" : "width",
			u = s ? "top" : "left",
			c = s ? "left" : "top",
			p = s ? "bottom" : "right",
			d = C(n)[l];
		a[p] - d < o[u] && (t.offsets.popper[u] -= o[u] - (a[p] - d)), a[u] + d > o[p] && (t.offsets.popper[u] += a[u] + d - o[p]);
		var f = a[u] + a[l] / 2 - d / 2,
			h = f - m(t.offsets.popper)[u];
		return h = Math.max(Math.min(o[l] - d, h), 0), t.arrowElement = n, t.offsets.arrow = {}, t.offsets.arrow[u] = Math.round(h), t.offsets.arrow[c] = "", t
	}

	function z(t) {
		return "end" === t ? "start" : "start" === t ? "end" : t
	}

	function K(t) {
		var e = arguments.length > 1 && arguments[1] !== undefined && arguments[1],
			n = bt.indexOf(t),
			i = bt.slice(n + 1).concat(bt.slice(0, n));
		return e ? i.reverse() : i
	}

	function Q(t, e) {
		if (N(t.instance.modifiers, "inner")) return t;
		if (t.flipped && t.placement === t.originalPlacement) return t;
		var n = _(t.instance.popper, t.instance.reference, e.padding, e.boundariesElement),
			i = t.placement.split("-")[0],
			r = x(i),
			o = t.placement.split("-")[1] || "",
			a = [];
		switch (e.behavior) {
			case _t.FLIP:
				a = [i, r];
				break;
			case _t.CLOCKWISE:
				a = K(i);
				break;
			case _t.COUNTERCLOCKWISE:
				a = K(i, !0);
				break;
			default:
				a = e.behavior
		}
		return a.forEach(function (s, l) {
			if (i !== s || a.length === l + 1) return t;
			i = t.placement.split("-")[0], r = x(i);
			var u = t.offsets.popper,
				c = t.offsets.reference,
				p = Math.floor,
				d = "left" === i && p(u.right) > p(c.left) || "right" === i && p(u.left) < p(c.right) || "top" === i && p(u.bottom) > p(c.top) || "bottom" === i && p(u.top) < p(c.bottom),
				f = p(u.left) < p(n.left),
				h = p(u.right) > p(n.right),
				m = p(u.top) < p(n.top),
				g = p(u.bottom) > p(n.bottom),
				v = "left" === i && f || "right" === i && h || "top" === i && m || "bottom" === i && g,
				y = -1 !== ["top", "bottom"].indexOf(i),
				b = !!e.flipVariations && (y && "start" === o && f || y && "end" === o && h || !y && "start" === o && m || !y && "end" === o && g);
			(d || v || b) && (t.flipped = !0, (d || v) && (i = a[l + 1]), b && (o = z(o)), t.placement = i + (o ? "-" + o : ""), t.offsets.popper = vt({}, t.offsets.popper, S(t.instance.popper, t.offsets.reference, t.placement)), t = D(t.instance.modifiers, t, "flip"))
		}), t
	}

	function Y(t) {
		var e = t.offsets,
			n = e.popper,
			i = e.reference,
			r = t.placement.split("-")[0],
			o = Math.floor,
			a = -1 !== ["top", "bottom"].indexOf(r),
			s = a ? "right" : "bottom",
			l = a ? "left" : "top",
			u = a ? "width" : "height";
		return n[s] < o(i[l]) && (t.offsets.popper[l] = o(i[l]) - n[u]), n[l] > o(i[s]) && (t.offsets.popper[l] = o(i[s])), t
	}

	function X(t, e, n, i) {
		var r = t.match(/((?:\-|\+)?\d*\.?\d*)(.*)/),
			o = +r[1],
			a = r[2];
		if (!o) return t;
		if (0 === a.indexOf("%")) {
			var s = void 0;
			switch (a) {
				case "%p":
					s = n;
					break;
				case "%":
				case "%r":
				default:
					s = i
			}
			return m(s)[e] / 100 * o
		}
		if ("vh" === a || "vw" === a) {
			return ("vh" === a ? Math.max(document.documentElement.clientHeight, window.innerHeight || 0) : Math.max(document.documentElement.clientWidth, window.innerWidth || 0)) / 100 * o
		}
		return o
	}

	function J(t, e, n, i) {
		var r = [0, 0],
			o = -1 !== ["right", "left"].indexOf(i),
			a = t.split(/(\+|\-)/).map(function (t) {
				return t.trim()
			}),
			s = a.indexOf(T(a, function (t) {
				return -1 !== t.search(/,|\s/)
			}));
		a[s] && -1 === a[s].indexOf(",") && console.warn("Offsets separated by white space(s) are deprecated, use a comma (,) instead.");
		var l = /\s*,\s*|\s+/,
			u = -1 !== s ? [a.slice(0, s).concat([a[s].split(l)[0]]), [a[s].split(l)[1]].concat(a.slice(s + 1))] : [a];
		return u = u.map(function (t, i) {
			var r = (1 === i ? !o : o) ? "height" : "width",
				a = !1;
			return t.reduce(function (t, e) {
				return "" === t[t.length - 1] && -1 !== ["+", "-"].indexOf(e) ? (t[t.length - 1] = e, a = !0, t) : a ? (t[t.length - 1] += e, a = !1, t) : t.concat(e)
			}, []).map(function (t) {
				return X(t, r, e, n)
			})
		}), u.forEach(function (t, e) {
			t.forEach(function (n, i) {
				F(n) && (r[e] += n * ("-" === t[i - 1] ? -1 : 1))
			})
		}), r
	}

	function Z(t, e) {
		var n = e.offset,
			i = t.placement,
			r = t.offsets,
			o = r.popper,
			a = r.reference,
			s = i.split("-")[0],
			l = void 0;
		return l = F(+n) ? [+n, 0] : J(n, o, a, s), "left" === s ? (o.top += l[0], o.left -= l[1]) : "right" === s ? (o.top += l[0], o.left += l[1]) : "top" === s ? (o.left += l[0], o.top -= l[1]) : "bottom" === s && (o.left += l[0], o.top += l[1]), t.popper = o, t
	}

	function tt(t, e) {
		var n = e.boundariesElement || a(t.instance.popper);
		t.instance.reference === n && (n = a(n));
		var i = _(t.instance.popper, t.instance.reference, e.padding, n);
		e.boundaries = i;
		var r = e.priority,
			o = t.offsets.popper,
			s = {
				primary: function (t) {
					var n = o[t];
					return o[t] < i[t] && !e.escapeWithReference && (n = Math.max(o[t], i[t])), gt({}, t, n)
				},
				secondary: function (t) {
					var n = "right" === t ? "left" : "top",
						r = o[n];
					return o[t] > i[t] && !e.escapeWithReference && (r = Math.min(o[n], i[t] - ("right" === t ? o.width : o.height))), gt({}, n, r)
				}
			};
		return r.forEach(function (t) {
			var e = -1 !== ["left", "top"].indexOf(t) ? "primary" : "secondary";
			o = vt({}, o, s[e](t))
		}), t.offsets.popper = o, t
	}

	function et(t) {
		var e = t.placement,
			n = e.split("-")[0],
			i = e.split("-")[1];
		if (i) {
			var r = t.offsets,
				o = r.reference,
				a = r.popper,
				s = -1 !== ["bottom", "top"].indexOf(n),
				l = s ? "left" : "top",
				u = s ? "width" : "height",
				c = {
					start: gt({}, l, o[l]),
					end: gt({}, l, o[l] + o[u] - a[u])
				};
			t.offsets.popper = vt({}, a, c[i])
		}
		return t
	}

	function nt(t) {
		if (!G(t.instance.modifiers, "hide", "preventOverflow")) return t;
		var e = t.offsets.reference,
			n = T(t.instance.modifiers, function (t) {
				return "preventOverflow" === t.name
			}).boundaries;
		if (e.bottom < n.top || e.left > n.right || e.top > n.bottom || e.right < n.left) {
			if (!0 === t.hide) return t;
			t.hide = !0, t.attributes["x-out-of-boundaries"] = ""
		} else {
			if (!1 === t.hide) return t;
			t.hide = !1, t.attributes["x-out-of-boundaries"] = !1
		}
		return t
	}

	function it(t) {
		var e = t.placement,
			n = e.split("-")[0],
			i = t.offsets,
			r = i.popper,
			o = i.reference,
			a = -1 !== ["left", "right"].indexOf(n),
			s = -1 === ["top", "left"].indexOf(n);
		return r[a ? "left" : "top"] = o[e] - (s ? r[a ? "width" : "height"] : 0), t.placement = x(e), t.offsets.popper = m(r), t
	}
	for (var rt = ["native code", "[object MutationObserverConstructor]"], ot = function (t) {
			return rt.some(function (e) {
				return (t || "").toString().indexOf(e) > -1
			})
		}, at = "undefined" != typeof window, st = ["Edge", "Trident", "Firefox"], lt = 0, ut = 0; ut < st.length; ut += 1)
		if (at && navigator.userAgent.indexOf(st[ut]) >= 0) {
			lt = 1;
			break
		}
	var ct = at && ot(window.MutationObserver),
		pt = ct ? t : e,
		dt = undefined,
		ft = function () {
			return dt === undefined && (dt = -1 !== navigator.appVersion.indexOf("MSIE 10")), dt
		},
		ht = function (t, e) {
			if (!(t instanceof e)) throw new TypeError("Cannot call a class as a function")
		},
		mt = function () {
			function t(t, e) {
				for (var n = 0; n < e.length; n++) {
					var i = e[n];
					i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
				}
			}
			return function (e, n, i) {
				return n && t(e.prototype, n), i && t(e, i), e
			}
		}(),
		gt = function (t, e, n) {
			return e in t ? Object.defineProperty(t, e, {
				value: n,
				enumerable: !0,
				configurable: !0,
				writable: !0
			}) : t[e] = n, t
		},
		vt = Object.assign || function (t) {
			for (var e = 1; e < arguments.length; e++) {
				var n = arguments[e];
				for (var i in n) Object.prototype.hasOwnProperty.call(n, i) && (t[i] = n[i])
			}
			return t
		},
		yt = ["auto-start", "auto", "auto-end", "top-start", "top", "top-end", "right-start", "right", "right-end", "bottom-end", "bottom", "bottom-start", "left-end", "left", "left-start"],
		bt = yt.slice(3),
		_t = {
			FLIP: "flip",
			CLOCKWISE: "clockwise",
			COUNTERCLOCKWISE: "counterclockwise"
		},
		Et = {
			shift: {
				order: 100,
				enabled: !0,
				fn: et
			},
			offset: {
				order: 200,
				enabled: !0,
				fn: Z,
				offset: 0
			},
			preventOverflow: {
				order: 300,
				enabled: !0,
				fn: tt,
				priority: ["left", "right", "top", "bottom"],
				padding: 5,
				boundariesElement: "scrollParent"
			},
			keepTogether: {
				order: 400,
				enabled: !0,
				fn: Y
			},
			arrow: {
				order: 500,
				enabled: !0,
				fn: $,
				element: "[x-arrow]"
			},
			flip: {
				order: 600,
				enabled: !0,
				fn: Q,
				behavior: "flip",
				padding: 5,
				boundariesElement: "viewport"
			},
			inner: {
				order: 700,
				enabled: !1,
				fn: it
			},
			hide: {
				order: 800,
				enabled: !0,
				fn: nt
			},
			computeStyle: {
				order: 850,
				enabled: !0,
				fn: V,
				gpuAcceleration: !0,
				x: "bottom",
				y: "right"
			},
			applyStyle: {
				order: 900,
				enabled: !0,
				fn: W,
				onLoad: U,
				gpuAcceleration: undefined
			}
		},
		kt = {
			placement: "bottom",
			eventsEnabled: !0,
			removeOnDestroy: !1,
			onCreate: function () {},
			onUpdate: function () {},
			modifiers: Et
		},
		wt = function () {
			function t(e, i) {
				var r = this,
					o = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : {};
				ht(this, t), this.scheduleUpdate = function () {
					return requestAnimationFrame(r.update)
				}, this.update = pt(this.update.bind(this)), this.options = vt({}, t.Defaults, o), this.state = {
					isDestroyed: !1,
					isCreated: !1,
					scrollParents: []
				}, this.reference = e.jquery ? e[0] : e, this.popper = i.jquery ? i[0] : i, this.options.modifiers = {}, Object.keys(vt({}, t.Defaults.modifiers, o.modifiers)).forEach(function (e) {
					r.options.modifiers[e] = vt({}, t.Defaults.modifiers[e] || {}, o.modifiers ? o.modifiers[e] : {})
				}), this.modifiers = Object.keys(this.options.modifiers).map(function (t) {
					return vt({
						name: t
					}, r.options.modifiers[t])
				}).sort(function (t, e) {
					return t.order - e.order
				}), this.modifiers.forEach(function (t) {
					t.enabled && n(t.onLoad) && t.onLoad(r.reference, r.popper, r.options, t, r.state)
				}), this.update();
				var a = this.options.eventsEnabled;
				a && this.enableEventListeners(), this.state.eventsEnabled = a
			}
			return mt(t, [{
				key: "update",
				value: function () {
					return O.call(this)
				}
			}, {
				key: "destroy",
				value: function () {
					return P.call(this)
				}
			}, {
				key: "enableEventListeners",
				value: function () {
					return M.call(this)
				}
			}, {
				key: "disableEventListeners",
				value: function () {
					return H.call(this)
				}
			}]), t
		}();
	return wt.Utils = ("undefined" != typeof window ? window : global).PopperUtils, wt.placements = yt, wt.Defaults = kt, wt
}),
function () {
	(function () {
		(function () {
			this.Turbolinks = {
				supported: function () {
					return null != window.history.pushState && null != window.requestAnimationFrame && null != window.addEventListener
				}(),
				visit: function (e, n) {
					return t.controller.visit(e, n)
				},
				clearCache: function () {
					return t.controller.clearCache()
				}
			}
		}).call(this)
	}).call(this);
	var t = this.Turbolinks;
	(function () {
		(function () {
			var e, n, i = [].slice;
			t.copyObject = function (t) {
				var e, n, i;
				n = {};
				for (e in t) i = t[e], n[e] = i;
				return n
			}, t.closest = function (t, n) {
				return e.call(t, n)
			}, e = function () {
				var t, e;
				return t = document.documentElement, null != (e = t.closest) ? e : function (t) {
					var e;
					for (e = this; e;) {
						if (e.nodeType === Node.ELEMENT_NODE && n.call(e, t)) return e;
						e = e.parentNode
					}
				}
			}(), t.defer = function (t) {
				return setTimeout(t, 1)
			}, t.throttle = function (t) {
				var e;
				return e = null,
					function () {
						var n;
						return n = 1 <= arguments.length ? i.call(arguments, 0) : [], null != e ? e : e = requestAnimationFrame(function (i) {
							return function () {
								return e = null, t.apply(i, n)
							}
						}(this))
					}
			}, t.dispatch = function (t, e) {
				var n, i, r, o, a;
				return o = null != e ? e : {}, a = o.target, n = o.cancelable, i = o.data, r = document.createEvent("Events"), r.initEvent(t, !0, !0 === n), r.data = null != i ? i : {}, (null != a ? a : document).dispatchEvent(r), r
			}, t.match = function (t, e) {
				return n.call(t, e)
			}, n = function () {
				var t, e, n, i;
				return t = document.documentElement, null != (e = null != (n = null != (i = t.matchesSelector) ? i : t.webkitMatchesSelector) ? n : t.msMatchesSelector) ? e : t.mozMatchesSelector
			}(), t.uuid = function () {
				var t, e, n;
				for (n = "", t = e = 1; 36 >= e; t = ++e) n += 9 === t || 14 === t || 19 === t || 24 === t ? "-" : 15 === t ? "4" : 20 === t ? (Math.floor(4 * Math.random()) + 8).toString(16) : Math.floor(15 * Math.random()).toString(16);
				return n
			}
		}).call(this),
			function () {
				t.Location = function () {
					function t(t) {
						var e, n;
						null == t && (t = ""), n = document.createElement("a"), n.href = t.toString(), this.absoluteURL = n.href, e = n.hash.length, 2 > e ? this.requestURL = this.absoluteURL : (this.requestURL = this.absoluteURL.slice(0, -e), this.anchor = n.hash.slice(1))
					}
					var e, n, i, r;
					return t.wrap = function (t) {
						return t instanceof this ? t : new this(t)
					}, t.prototype.getOrigin = function () {
						return this.absoluteURL.split("/", 3).join("/")
					}, t.prototype.getPath = function () {
						var t, e;
						return null != (t = null != (e = this.absoluteURL.match(/\/\/[^\/]*(\/[^?;]*)/)) ? e[1] : void 0) ? t : "/"
					}, t.prototype.getPathComponents = function () {
						return this.getPath().split("/").slice(1)
					}, t.prototype.getLastPathComponent = function () {
						return this.getPathComponents().slice(-1)[0]
					}, t.prototype.getExtension = function () {
						var t, e;
						return null != (t = null != (e = this.getLastPathComponent().match(/\.[^.]*$/)) ? e[0] : void 0) ? t : ""
					}, t.prototype.isHTML = function () {
						return this.getExtension().match(/^(?:|\.(?:htm|html|xhtml))$/)
					}, t.prototype.isPrefixedBy = function (t) {
						var e;
						return e = n(t), this.isEqualTo(t) || r(this.absoluteURL, e)
					}, t.prototype.isEqualTo = function (t) {
						return this.absoluteURL === (null != t ? t.absoluteURL : void 0)
					}, t.prototype.toCacheKey = function () {
						return this.requestURL
					}, t.prototype.toJSON = function () {
						return this.absoluteURL
					}, t.prototype.toString = function () {
						return this.absoluteURL
					}, t.prototype.valueOf = function () {
						return this.absoluteURL
					}, n = function (t) {
						return e(t.getOrigin() + t.getPath())
					}, e = function (t) {
						return i(t, "/") ? t : t + "/"
					}, r = function (t, e) {
						return t.slice(0, e.length) === e
					}, i = function (t, e) {
						return t.slice(-e.length) === e
					}, t
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.HttpRequest = function () {
					function n(n, i, r) {
						this.delegate = n, this.requestCanceled = e(this.requestCanceled, this), this.requestTimedOut = e(this.requestTimedOut, this), this.requestFailed = e(this.requestFailed, this),
							this.requestLoaded = e(this.requestLoaded, this), this.requestProgressed = e(this.requestProgressed, this), this.url = t.Location.wrap(i).requestURL, this.referrer = t.Location.wrap(r).absoluteURL, this.createXHR()
					}
					return n.NETWORK_FAILURE = 0, n.TIMEOUT_FAILURE = -1, n.timeout = 60, n.prototype.send = function () {
						var t;
						return this.xhr && !this.sent ? (this.notifyApplicationBeforeRequestStart(), this.setProgress(0), this.xhr.send(), this.sent = !0, "function" == typeof (t = this.delegate).requestStarted ? t.requestStarted() : void 0) : void 0
					}, n.prototype.cancel = function () {
						return this.xhr && this.sent ? this.xhr.abort() : void 0
					}, n.prototype.requestProgressed = function (t) {
						return t.lengthComputable ? this.setProgress(t.loaded / t.total) : void 0
					}, n.prototype.requestLoaded = function () {
						return this.endRequest(function (t) {
							return function () {
								var e;
								return 200 <= (e = t.xhr.status) && 300 > e ? t.delegate.requestCompletedWithResponse(t.xhr.responseText, t.xhr.getResponseHeader("Turbolinks-Location")) : (t.failed = !0, t.delegate.requestFailedWithStatusCode(t.xhr.status, t.xhr.responseText))
							}
						}(this))
					}, n.prototype.requestFailed = function () {
						return this.endRequest(function (t) {
							return function () {
								return t.failed = !0, t.delegate.requestFailedWithStatusCode(t.constructor.NETWORK_FAILURE)
							}
						}(this))
					}, n.prototype.requestTimedOut = function () {
						return this.endRequest(function (t) {
							return function () {
								return t.failed = !0, t.delegate.requestFailedWithStatusCode(t.constructor.TIMEOUT_FAILURE)
							}
						}(this))
					}, n.prototype.requestCanceled = function () {
						return this.endRequest()
					}, n.prototype.notifyApplicationBeforeRequestStart = function () {
						return t.dispatch("turbolinks:request-start", {
							data: {
								url: this.url,
								xhr: this.xhr
							}
						})
					}, n.prototype.notifyApplicationAfterRequestEnd = function () {
						return t.dispatch("turbolinks:request-end", {
							data: {
								url: this.url,
								xhr: this.xhr
							}
						})
					}, n.prototype.createXHR = function () {
						return this.xhr = new XMLHttpRequest, this.xhr.open("GET", this.url, !0), this.xhr.timeout = 1e3 * this.constructor.timeout, this.xhr.setRequestHeader("Accept", "text/html, application/xhtml+xml"), this.xhr.setRequestHeader("Turbolinks-Referrer", this.referrer), this.xhr.onprogress = this.requestProgressed, this.xhr.onload = this.requestLoaded, this.xhr.onerror = this.requestFailed, this.xhr.ontimeout = this.requestTimedOut, this.xhr.onabort = this.requestCanceled
					}, n.prototype.endRequest = function (t) {
						return this.xhr ? (this.notifyApplicationAfterRequestEnd(), null != t && t.call(this), this.destroy()) : void 0
					}, n.prototype.setProgress = function (t) {
						var e;
						return this.progress = t, "function" == typeof (e = this.delegate).requestProgressed ? e.requestProgressed(this.progress) : void 0
					}, n.prototype.destroy = function () {
						var t;
						return this.setProgress(1), "function" == typeof (t = this.delegate).requestFinished && t.requestFinished(), this.delegate = null, this.xhr = null
					}, n
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.ProgressBar = function () {
					function t() {
						this.trickle = e(this.trickle, this), this.stylesheetElement = this.createStylesheetElement(), this.progressElement = this.createProgressElement()
					}
					var n;
					return n = 300, t.defaultCSS = ".turbolinks-progress-bar {\n  position: fixed;\n  display: block;\n  top: 0;\n  left: 0;\n  height: 3px;\n  background: #0076ff;\n  z-index: 9999;\n  transition: width " + n + "ms ease-out, opacity " + n / 2 + "ms " + n / 2 + "ms ease-in;\n  transform: translate3d(0, 0, 0);\n}", t.prototype.show = function () {
						return this.visible ? void 0 : (this.visible = !0, this.installStylesheetElement(), this.installProgressElement(), this.startTrickling())
					}, t.prototype.hide = function () {
						return this.visible && !this.hiding ? (this.hiding = !0, this.fadeProgressElement(function (t) {
							return function () {
								return t.uninstallProgressElement(), t.stopTrickling(), t.visible = !1, t.hiding = !1
							}
						}(this))) : void 0
					}, t.prototype.setValue = function (t) {
						return this.value = t, this.refresh()
					}, t.prototype.installStylesheetElement = function () {
						return document.head.insertBefore(this.stylesheetElement, document.head.firstChild)
					}, t.prototype.installProgressElement = function () {
						return this.progressElement.style.width = 0, this.progressElement.style.opacity = 1, document.documentElement.insertBefore(this.progressElement, document.body), this.refresh()
					}, t.prototype.fadeProgressElement = function (t) {
						return this.progressElement.style.opacity = 0, setTimeout(t, 1.5 * n)
					}, t.prototype.uninstallProgressElement = function () {
						return this.progressElement.parentNode ? document.documentElement.removeChild(this.progressElement) : void 0
					}, t.prototype.startTrickling = function () {
						return null != this.trickleInterval ? this.trickleInterval : this.trickleInterval = setInterval(this.trickle, n)
					}, t.prototype.stopTrickling = function () {
						return clearInterval(this.trickleInterval), this.trickleInterval = null
					}, t.prototype.trickle = function () {
						return this.setValue(this.value + Math.random() / 100)
					}, t.prototype.refresh = function () {
						return requestAnimationFrame(function (t) {
							return function () {
								return t.progressElement.style.width = 10 + 90 * t.value + "%"
							}
						}(this))
					}, t.prototype.createStylesheetElement = function () {
						var t;
						return t = document.createElement("style"), t.type = "text/css", t.textContent = this.constructor.defaultCSS, t
					}, t.prototype.createProgressElement = function () {
						var t;
						return t = document.createElement("div"), t.className = "turbolinks-progress-bar", t
					}, t
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.BrowserAdapter = function () {
					function n(n) {
						this.controller = n, this.showProgressBar = e(this.showProgressBar, this), this.progressBar = new t.ProgressBar
					}
					var i, r, o, a;
					return a = t.HttpRequest, i = a.NETWORK_FAILURE, o = a.TIMEOUT_FAILURE, r = 500, n.prototype.visitProposedToLocationWithAction = function (t, e) {
						return this.controller.startVisitToLocationWithAction(t, e)
					}, n.prototype.visitStarted = function (t) {
						return t.issueRequest(), t.changeHistory(), t.loadCachedSnapshot()
					}, n.prototype.visitRequestStarted = function (t) {
						return this.progressBar.setValue(0), t.hasCachedSnapshot() || "restore" !== t.action ? this.showProgressBarAfterDelay() : this.showProgressBar()
					}, n.prototype.visitRequestProgressed = function (t) {
						return this.progressBar.setValue(t.progress)
					}, n.prototype.visitRequestCompleted = function (t) {
						return t.loadResponse()
					}, n.prototype.visitRequestFailedWithStatusCode = function (t, e) {
						switch (e) {
							case i:
							case o:
								return this.reload();
							default:
								return t.loadResponse()
						}
					}, n.prototype.visitRequestFinished = function () {
						return this.hideProgressBar()
					}, n.prototype.visitCompleted = function (t) {
						return t.followRedirect()
					}, n.prototype.pageInvalidated = function () {
						return this.reload()
					}, n.prototype.showProgressBarAfterDelay = function () {
						return this.progressBarTimeout = setTimeout(this.showProgressBar, r)
					}, n.prototype.showProgressBar = function () {
						return this.progressBar.show()
					}, n.prototype.hideProgressBar = function () {
						return this.progressBar.hide(), clearTimeout(this.progressBarTimeout)
					}, n.prototype.reload = function () {
						return window.location.reload()
					}, n
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.History = function () {
					function n(t) {
						this.delegate = t, this.onPageLoad = e(this.onPageLoad, this), this.onPopState = e(this.onPopState, this)
					}
					return n.prototype.start = function () {
						return this.started ? void 0 : (addEventListener("popstate", this.onPopState, !1), addEventListener("load", this.onPageLoad, !1), this.started = !0)
					}, n.prototype.stop = function () {
						return this.started ? (removeEventListener("popstate", this.onPopState, !1), removeEventListener("load", this.onPageLoad, !1), this.started = !1) : void 0
					}, n.prototype.push = function (e, n) {
						return e = t.Location.wrap(e), this.update("push", e, n)
					}, n.prototype.replace = function (e, n) {
						return e = t.Location.wrap(e), this.update("replace", e, n)
					}, n.prototype.onPopState = function (e) {
						var n, i, r, o;
						return this.shouldHandlePopState() && (o = null != (i = e.state) ? i.turbolinks : void 0) ? (n = t.Location.wrap(window.location), r = o.restorationIdentifier, this.delegate.historyPoppedToLocationWithRestorationIdentifier(n, r)) : void 0
					}, n.prototype.onPageLoad = function () {
						return t.defer(function (t) {
							return function () {
								return t.pageLoaded = !0
							}
						}(this))
					}, n.prototype.shouldHandlePopState = function () {
						return this.pageIsLoaded()
					}, n.prototype.pageIsLoaded = function () {
						return this.pageLoaded || "complete" === document.readyState
					}, n.prototype.update = function (t, e, n) {
						var i;
						return i = {
							turbolinks: {
								restorationIdentifier: n
							}
						}, history[t + "State"](i, null, e)
					}, n
				}()
			}.call(this),
			function () {
				t.Snapshot = function () {
					function e(t) {
						var e, n;
						n = t.head, e = t.body, this.head = null != n ? n : document.createElement("head"), this.body = null != e ? e : document.createElement("body")
					}
					return e.wrap = function (t) {
						return t instanceof this ? t : this.fromHTML(t)
					}, e.fromHTML = function (t) {
						var e;
						return e = document.createElement("html"), e.innerHTML = t, this.fromElement(e)
					}, e.fromElement = function (t) {
						return new this({
							head: t.querySelector("head"),
							body: t.querySelector("body")
						})
					}, e.prototype.clone = function () {
						return new e({
							head: this.head.cloneNode(!0),
							body: this.body.cloneNode(!0)
						})
					}, e.prototype.getRootLocation = function () {
						var e, n;
						return n = null != (e = this.getSetting("root")) ? e : "/", new t.Location(n)
					}, e.prototype.getCacheControlValue = function () {
						return this.getSetting("cache-control")
					}, e.prototype.hasAnchor = function (t) {
						try {
							return null != this.body.querySelector("[id='" + t + "']")
						} catch (t) {}
					}, e.prototype.isPreviewable = function () {
						return "no-preview" !== this.getCacheControlValue()
					}, e.prototype.isCacheable = function () {
						return "no-cache" !== this.getCacheControlValue()
					}, e.prototype.getSetting = function (t) {
						var e, n;
						return n = this.head.querySelectorAll("meta[name='turbolinks-" + t + "']"), e = n[n.length - 1], null != e ? e.getAttribute("content") : void 0
					}, e
				}()
			}.call(this),
			function () {
				var e = [].slice;
				t.Renderer = function () {
					function t() {}
					var n;
					return t.render = function () {
						var t, n, i, r;
						return i = arguments[0], n = arguments[1], t = 3 <= arguments.length ? e.call(arguments, 2) : [], r = function (t, e, n) {
							n.prototype = t.prototype;
							var i = new n,
								r = t.apply(i, e);
							return Object(r) === r ? r : i
						}(this, t, function () {}), r.delegate = i, r.render(n), r
					}, t.prototype.renderView = function (t) {
						return this.delegate.viewWillRender(this.newBody), t(), this.delegate.viewRendered(this.newBody)
					}, t.prototype.invalidateView = function () {
						return this.delegate.viewInvalidated()
					}, t.prototype.createScriptElement = function (t) {
						var e;
						return "false" === t.getAttribute("data-turbolinks-eval") ? t : (e = document.createElement("script"), e.textContent = t.textContent, n(e, t), e)
					}, n = function (t, e) {
						var n, i, r, o, a, s, l;
						for (o = e.attributes, s = [], n = 0, i = o.length; i > n; n++) a = o[n], r = a.name, l = a.value, s.push(t.setAttribute(r, l));
						return s
					}, t
				}()
			}.call(this),
			function () {
				t.HeadDetails = function () {
					function t(t) {
						var e, n, o, a, s, l, u;
						for (this.element = t, this.elements = {}, u = this.element.childNodes, a = 0, l = u.length; l > a; a++) o = u[a], o.nodeType === Node.ELEMENT_NODE && (s = o.outerHTML, n = null != (e = this.elements)[s] ? e[s] : e[s] = {
							type: r(o),
							tracked: i(o),
							elements: []
						}, n.elements.push(o))
					}
					var e, n, i, r;
					return t.prototype.hasElementWithKey = function (t) {
						return t in this.elements
					}, t.prototype.getTrackedElementSignature = function () {
						var t, e;
						return function () {
							var n, i;
							n = this.elements, i = [];
							for (t in n)(e = n[t].tracked) && i.push(t);
							return i
						}.call(this).join("")
					}, t.prototype.getScriptElementsNotInDetails = function (t) {
						return this.getElementsMatchingTypeNotInDetails("script", t)
					}, t.prototype.getStylesheetElementsNotInDetails = function (t) {
						return this.getElementsMatchingTypeNotInDetails("stylesheet", t)
					}, t.prototype.getElementsMatchingTypeNotInDetails = function (t, e) {
						var n, i, r, o, a, s;
						r = this.elements, a = [];
						for (i in r) o = r[i], s = o.type, n = o.elements, s !== t || e.hasElementWithKey(i) || a.push(n[0]);
						return a
					}, t.prototype.getProvisionalElements = function () {
						var t, e, n, i, r, o, a;
						n = [], i = this.elements;
						for (e in i) r = i[e], a = r.type, o = r.tracked, t = r.elements, null != a || o ? t.length > 1 && n.push.apply(n, t.slice(1)) : n.push.apply(n, t);
						return n
					}, r = function (t) {
						return e(t) ? "script" : n(t) ? "stylesheet" : void 0
					}, i = function (t) {
						return "reload" === t.getAttribute("data-turbolinks-track")
					}, e = function (t) {
						return "script" === t.tagName.toLowerCase()
					}, n = function (t) {
						var e;
						return "style" === (e = t.tagName.toLowerCase()) || "link" === e && "stylesheet" === t.getAttribute("rel")
					}, t
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
						function i() {
							this.constructor = t
						}
						for (var r in e) n.call(e, r) && (t[r] = e[r]);
						return i.prototype = e.prototype, t.prototype = new i, t.__super__ = e.prototype, t
					},
					n = {}.hasOwnProperty;
				t.SnapshotRenderer = function (n) {
					function i(e, n) {
						this.currentSnapshot = e, this.newSnapshot = n, this.currentHeadDetails = new t.HeadDetails(this.currentSnapshot.head), this.newHeadDetails = new t.HeadDetails(this.newSnapshot.head), this.newBody = this.newSnapshot.body
					}
					return e(i, n), i.prototype.render = function (t) {
						return this.trackedElementsAreIdentical() ? (this.mergeHead(), this.renderView(function (e) {
							return function () {
								return e.replaceBody(), e.focusFirstAutofocusableElement(), t()
							}
						}(this))) : this.invalidateView()
					}, i.prototype.mergeHead = function () {
						return this.copyNewHeadStylesheetElements(), this.copyNewHeadScriptElements(), this.removeCurrentHeadProvisionalElements(), this.copyNewHeadProvisionalElements()
					}, i.prototype.replaceBody = function () {
						return this.activateBodyScriptElements(), this.importBodyPermanentElements(), this.assignNewBody()
					}, i.prototype.trackedElementsAreIdentical = function () {
						return this.currentHeadDetails.getTrackedElementSignature() === this.newHeadDetails.getTrackedElementSignature()
					}, i.prototype.copyNewHeadStylesheetElements = function () {
						var t, e, n, i, r;
						for (i = this.getNewHeadStylesheetElements(), r = [], e = 0, n = i.length; n > e; e++) t = i[e], r.push(document.head.appendChild(t));
						return r
					}, i.prototype.copyNewHeadScriptElements = function () {
						var t, e, n, i, r;
						for (i = this.getNewHeadScriptElements(), r = [], e = 0, n = i.length; n > e; e++) t = i[e], r.push(document.head.appendChild(this.createScriptElement(t)));
						return r
					}, i.prototype.removeCurrentHeadProvisionalElements = function () {
						var t, e, n, i, r;
						for (i = this.getCurrentHeadProvisionalElements(), r = [], e = 0, n = i.length; n > e; e++) t = i[e], r.push(document.head.removeChild(t));
						return r
					}, i.prototype.copyNewHeadProvisionalElements = function () {
						var t, e, n, i, r;
						for (i = this.getNewHeadProvisionalElements(), r = [], e = 0, n = i.length; n > e; e++) t = i[e], r.push(document.head.appendChild(t));
						return r
					}, i.prototype.importBodyPermanentElements = function () {
						var t, e, n, i, r, o;
						for (i = this.getNewBodyPermanentElements(), o = [], e = 0, n = i.length; n > e; e++) r = i[e], (t = this.findCurrentBodyPermanentElement(r)) ? o.push(r.parentNode.replaceChild(t, r)) : o.push(void 0);
						return o
					}, i.prototype.activateBodyScriptElements = function () {
						var t, e, n, i, r, o;
						for (i = this.getNewBodyScriptElements(), o = [], e = 0, n = i.length; n > e; e++) r = i[e], t = this.createScriptElement(r), o.push(r.parentNode.replaceChild(t, r));
						return o
					}, i.prototype.assignNewBody = function () {
						return document.body = this.newBody
					}, i.prototype.focusFirstAutofocusableElement = function () {
						var t;
						return null != (t = this.findFirstAutofocusableElement()) ? t.focus() : void 0
					}, i.prototype.getNewHeadStylesheetElements = function () {
						return this.newHeadDetails.getStylesheetElementsNotInDetails(this.currentHeadDetails)
					}, i.prototype.getNewHeadScriptElements = function () {
						return this.newHeadDetails.getScriptElementsNotInDetails(this.currentHeadDetails)
					}, i.prototype.getCurrentHeadProvisionalElements = function () {
						return this.currentHeadDetails.getProvisionalElements()
					}, i.prototype.getNewHeadProvisionalElements = function () {
						return this.newHeadDetails.getProvisionalElements()
					}, i.prototype.getNewBodyPermanentElements = function () {
						return this.newBody.querySelectorAll("[id][data-turbolinks-permanent]")
					}, i.prototype.findCurrentBodyPermanentElement = function (t) {
						return document.body.querySelector("#" + t.id + "[data-turbolinks-permanent]")
					}, i.prototype.getNewBodyScriptElements = function () {
						return this.newBody.querySelectorAll("script")
					}, i.prototype.findFirstAutofocusableElement = function () {
						return document.body.querySelector("[autofocus]")
					}, i
				}(t.Renderer)
			}.call(this),
			function () {
				var e = function (t, e) {
						function i() {
							this.constructor = t
						}
						for (var r in e) n.call(e, r) && (t[r] = e[r]);
						return i.prototype = e.prototype, t.prototype = new i, t.__super__ = e.prototype, t
					},
					n = {}.hasOwnProperty;
				t.ErrorRenderer = function (t) {
					function n(t) {
						this.html = t
					}
					return e(n, t), n.prototype.render = function (t) {
						return this.renderView(function (e) {
							return function () {
								return e.replaceDocumentHTML(), e.activateBodyScriptElements(), t()
							}
						}(this))
					}, n.prototype.replaceDocumentHTML = function () {
						return document.documentElement.innerHTML = this.html
					}, n.prototype.activateBodyScriptElements = function () {
						var t, e, n, i, r, o;
						for (i = this.getScriptElements(), o = [], e = 0, n = i.length; n > e; e++) r = i[e], t = this.createScriptElement(r), o.push(r.parentNode.replaceChild(t, r));
						return o
					}, n.prototype.getScriptElements = function () {
						return document.documentElement.querySelectorAll("script")
					}, n
				}(t.Renderer)
			}.call(this),
			function () {
				t.View = function () {
					function e(t) {
						this.delegate = t, this.element = document.documentElement
					}
					return e.prototype.getRootLocation = function () {
						return this.getSnapshot().getRootLocation()
					}, e.prototype.getSnapshot = function () {
						return t.Snapshot.fromElement(this.element)
					}, e.prototype.render = function (t, e) {
						var n, i, r;
						return r = t.snapshot, n = t.error, i = t.isPreview, this.markAsPreview(i), null != r ? this.renderSnapshot(r, e) : this.renderError(n, e)
					}, e.prototype.markAsPreview = function (t) {
						return t ? this.element.setAttribute("data-turbolinks-preview", "") : this.element.removeAttribute("data-turbolinks-preview")
					}, e.prototype.renderSnapshot = function (e, n) {
						return t.SnapshotRenderer.render(this.delegate, n, this.getSnapshot(), t.Snapshot.wrap(e))
					}, e.prototype.renderError = function (e, n) {
						return t.ErrorRenderer.render(this.delegate, n, e)
					}, e
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.ScrollManager = function () {
					function n(n) {
						this.delegate = n, this.onScroll = e(this.onScroll, this), this.onScroll = t.throttle(this.onScroll)
					}
					return n.prototype.start = function () {
						return this.started ? void 0 : (addEventListener("scroll", this.onScroll, !1), this.onScroll(), this.started = !0)
					}, n.prototype.stop = function () {
						return this.started ? (removeEventListener("scroll", this.onScroll, !1), this.started = !1) : void 0
					}, n.prototype.scrollToElement = function (t) {
						return t.scrollIntoView()
					}, n.prototype.scrollToPosition = function (t) {
						var e, n;
						return e = t.x, n = t.y, window.scrollTo(e, n)
					}, n.prototype.onScroll = function () {
						return this.updatePosition({
							x: window.pageXOffset,
							y: window.pageYOffset
						})
					}, n.prototype.updatePosition = function (t) {
						var e;
						return this.position = t, null != (e = this.delegate) ? e.scrollPositionChanged(this.position) : void 0
					}, n
				}()
			}.call(this),
			function () {
				t.SnapshotCache = function () {
					function e(t) {
						this.size = t, this.keys = [], this.snapshots = {}
					}
					var n;
					return e.prototype.has = function (t) {
						return n(t) in this.snapshots
					}, e.prototype.get = function (t) {
						var e;
						if (this.has(t)) return e = this.read(t), this.touch(t), e
					}, e.prototype.put = function (t, e) {
						return this.write(t, e), this.touch(t), e
					}, e.prototype.read = function (t) {
						var e;
						return e = n(t), this.snapshots[e]
					}, e.prototype.write = function (t, e) {
						var i;
						return i = n(t), this.snapshots[i] = e
					}, e.prototype.touch = function (t) {
						var e, i;
						return i = n(t), e = this.keys.indexOf(i), e > -1 && this.keys.splice(e, 1), this.keys.unshift(i), this.trim()
					}, e.prototype.trim = function () {
						var t, e, n, i, r;
						for (i = this.keys.splice(this.size), r = [], t = 0, n = i.length; n > t; t++) e = i[t], r.push(delete this.snapshots[e]);
						return r
					}, n = function (e) {
						return t.Location.wrap(e).toCacheKey()
					}, e
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.Visit = function () {
					function n(n, i, r) {
						this.controller = n, this.action = r, this.performScroll = e(this.performScroll, this), this.identifier = t.uuid(), this.location = t.Location.wrap(i), this.adapter = this.controller.adapter, this.state = "initialized", this.timingMetrics = {}
					}
					var i;
					return n.prototype.start = function () {
						return "initialized" === this.state ? (this.recordTimingMetric("visitStart"), this.state = "started", this.adapter.visitStarted(this)) : void 0
					}, n.prototype.cancel = function () {
						var t;
						return "started" === this.state ? (null != (t = this.request) && t.cancel(), this.cancelRender(), this.state = "canceled") : void 0
					}, n.prototype.complete = function () {
						var t;
						return "started" === this.state ? (this.recordTimingMetric("visitEnd"), this.state = "completed", "function" == typeof (t = this.adapter).visitCompleted && t.visitCompleted(this), this.controller.visitCompleted(this)) : void 0
					}, n.prototype.fail = function () {
						var t;
						return "started" === this.state ? (this.state = "failed", "function" == typeof (t = this.adapter).visitFailed ? t.visitFailed(this) : void 0) : void 0
					}, n.prototype.changeHistory = function () {
						var t, e;
						return this.historyChanged ? void 0 : (t = this.location.isEqualTo(this.referrer) ? "replace" : this.action, e = i(t), this.controller[e](this.location, this.restorationIdentifier), this.historyChanged = !0)
					}, n.prototype.issueRequest = function () {
						return this.shouldIssueRequest() && null == this.request ? (this.progress = 0, this.request = new t.HttpRequest(this, this.location, this.referrer), this.request.send()) : void 0
					}, n.prototype.getCachedSnapshot = function () {
						var t;
						return !(t = this.controller.getCachedSnapshotForLocation(this.location)) || null != this.location.anchor && !t.hasAnchor(this.location.anchor) || "restore" !== this.action && !t.isPreviewable() ? void 0 : t
					}, n.prototype.hasCachedSnapshot = function () {
						return null != this.getCachedSnapshot()
					}, n.prototype.loadCachedSnapshot = function () {
						var t, e;
						return (e = this.getCachedSnapshot()) ? (t = this.shouldIssueRequest(), this.render(function () {
							var n;
							return this.cacheSnapshot(), this.controller.render({
								snapshot: e,
								isPreview: t
							}, this.performScroll), "function" == typeof (n = this.adapter).visitRendered && n.visitRendered(this), t ? void 0 : this.complete()
						})) : void 0
					}, n.prototype.loadResponse = function () {
						return null != this.response ? this.render(function () {
							var t, e;
							return this.cacheSnapshot(), this.request.failed ? (this.controller.render({
								error: this.response
							}, this.performScroll), "function" == typeof (t = this.adapter).visitRendered && t.visitRendered(this), this.fail()) : (this.controller.render({
								snapshot: this.response
							}, this.performScroll), "function" == typeof (e = this.adapter).visitRendered && e.visitRendered(this), this.complete())
						}) : void 0
					}, n.prototype.followRedirect = function () {
						return this.redirectedToLocation && !this.followedRedirect ? (this.location = this.redirectedToLocation, this.controller.replaceHistoryWithLocationAndRestorationIdentifier(this.redirectedToLocation, this.restorationIdentifier), this.followedRedirect = !0) : void 0
					}, n.prototype.requestStarted = function () {
						var t;
						return this.recordTimingMetric("requestStart"), "function" == typeof (t = this.adapter).visitRequestStarted ? t.visitRequestStarted(this) : void 0
					}, n.prototype.requestProgressed = function (t) {
						var e;
						return this.progress = t, "function" == typeof (e = this.adapter).visitRequestProgressed ? e.visitRequestProgressed(this) : void 0
					}, n.prototype.requestCompletedWithResponse = function (e, n) {
						return this.response = e, null != n && (this.redirectedToLocation = t.Location.wrap(n)), this.adapter.visitRequestCompleted(this)
					}, n.prototype.requestFailedWithStatusCode = function (t, e) {
						return this.response = e, this.adapter.visitRequestFailedWithStatusCode(this, t)
					}, n.prototype.requestFinished = function () {
						var t;
						return this.recordTimingMetric("requestEnd"), "function" == typeof (t = this.adapter).visitRequestFinished ? t.visitRequestFinished(this) : void 0
					}, n.prototype.performScroll = function () {
						return this.scrolled ? void 0 : ("restore" === this.action ? this.scrollToRestoredPosition() || this.scrollToTop() : this.scrollToAnchor() || this.scrollToTop(), this.scrolled = !0)
					}, n.prototype.scrollToRestoredPosition = function () {
						var t, e;
						return t = null != (e = this.restorationData) ? e.scrollPosition : void 0, null != t ? (this.controller.scrollToPosition(t), !0) : void 0
					}, n.prototype.scrollToAnchor = function () {
						return null != this.location.anchor ? (this.controller.scrollToAnchor(this.location.anchor), !0) : void 0
					}, n.prototype.scrollToTop = function () {
						return this.controller.scrollToPosition({
							x: 0,
							y: 0
						})
					}, n.prototype.recordTimingMetric = function (t) {
						var e;
						return null != (e = this.timingMetrics)[t] ? e[t] : e[t] = (new Date).getTime()
					}, n.prototype.getTimingMetrics = function () {
						return t.copyObject(this.timingMetrics)
					}, i = function (t) {
						switch (t) {
							case "replace":
								return "replaceHistoryWithLocationAndRestorationIdentifier";
							case "advance":
							case "restore":
								return "pushHistoryWithLocationAndRestorationIdentifier"
						}
					}, n.prototype.shouldIssueRequest = function () {
						return "restore" !== this.action || !this.hasCachedSnapshot()
					}, n.prototype.cacheSnapshot = function () {
						return this.snapshotCached ? void 0 : (this.controller.cacheSnapshot(), this.snapshotCached = !0)
					}, n.prototype.render = function (t) {
						return this.cancelRender(), this.frame = requestAnimationFrame(function (e) {
							return function () {
								return e.frame = null, t.call(e)
							}
						}(this))
					}, n.prototype.cancelRender = function () {
						return this.frame ? cancelAnimationFrame(this.frame) : void 0
					}, n
				}()
			}.call(this),
			function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.Controller = function () {
					function n() {
						this.clickBubbled = e(this.clickBubbled, this), this.clickCaptured = e(this.clickCaptured, this), this.pageLoaded = e(this.pageLoaded, this), this.history = new t.History(this), this.view = new t.View(this), this.scrollManager = new t.ScrollManager(this), this.restorationData = {}, this.clearCache()
					}
					return n.prototype.start = function () {
						return t.supported && !this.started ? (addEventListener("click", this.clickCaptured, !0), addEventListener("DOMContentLoaded", this.pageLoaded, !1), this.scrollManager.start(), this.startHistory(), this.started = !0, this.enabled = !0) : void 0
					}, n.prototype.disable = function () {
						return this.enabled = !1
					}, n.prototype.stop = function () {
						return this.started ? (removeEventListener("click", this.clickCaptured, !0), removeEventListener("DOMContentLoaded", this.pageLoaded, !1), this.scrollManager.stop(), this.stopHistory(), this.started = !1) : void 0
					}, n.prototype.clearCache = function () {
						return this.cache = new t.SnapshotCache(10)
					}, n.prototype.visit = function (e, n) {
						var i, r;
						return null == n && (n = {}), e = t.Location.wrap(e), this.applicationAllowsVisitingLocation(e) ? this.locationIsVisitable(e) ? (i = null != (r = n.action) ? r : "advance", this.adapter.visitProposedToLocationWithAction(e, i)) : window.location = e : void 0
					}, n.prototype.startVisitToLocationWithAction = function (e, n, i) {
						var r;
						return t.supported ? (r = this.getRestorationDataForIdentifier(i), this.startVisit(e, n, {
							restorationData: r
						})) : window.location = e
					}, n.prototype.startHistory = function () {
						return this.location = t.Location.wrap(window.location), this.restorationIdentifier = t.uuid(), this.history.start(), this.history.replace(this.location, this.restorationIdentifier)
					}, n.prototype.stopHistory = function () {
						return this.history.stop()
					}, n.prototype.pushHistoryWithLocationAndRestorationIdentifier = function (e, n) {
						return this.restorationIdentifier = n, this.location = t.Location.wrap(e), this.history.push(this.location, this.restorationIdentifier)
					}, n.prototype.replaceHistoryWithLocationAndRestorationIdentifier = function (e, n) {
						return this.restorationIdentifier = n, this.location = t.Location.wrap(e), this.history.replace(this.location, this.restorationIdentifier)
					}, n.prototype.historyPoppedToLocationWithRestorationIdentifier = function (e, n) {
						var i;
						return this.restorationIdentifier = n, this.enabled ? (i = this.getRestorationDataForIdentifier(this.restorationIdentifier), this.startVisit(e, "restore", {
							restorationIdentifier: this.restorationIdentifier,
							restorationData: i,
							historyChanged: !0
						}), this.location = t.Location.wrap(e)) : this.adapter.pageInvalidated()
					}, n.prototype.getCachedSnapshotForLocation = function (t) {
						var e;
						return e = this.cache.get(t), e ? e.clone() : void 0
					}, n.prototype.shouldCacheSnapshot = function () {
						return this.view.getSnapshot().isCacheable()
					}, n.prototype.cacheSnapshot = function () {
						var t;
						return this.shouldCacheSnapshot() ? (this.notifyApplicationBeforeCachingSnapshot(), t = this.view.getSnapshot(), this.cache.put(this.lastRenderedLocation, t.clone())) : void 0
					}, n.prototype.scrollToAnchor = function (t) {
						var e;
						return (e = document.getElementById(t)) ? this.scrollToElement(e) : this.scrollToPosition({
							x: 0,
							y: 0
						})
					}, n.prototype.scrollToElement = function (t) {
						return this.scrollManager.scrollToElement(t)
					}, n.prototype.scrollToPosition = function (t) {
						return this.scrollManager.scrollToPosition(t)
					}, n.prototype.scrollPositionChanged = function (t) {
						var e;
						return e = this.getCurrentRestorationData(), e.scrollPosition = t
					}, n.prototype.render = function (t, e) {
						return this.view.render(t, e)
					}, n.prototype.viewInvalidated = function () {
						return this.adapter.pageInvalidated()
					}, n.prototype.viewWillRender = function (t) {
						return this.notifyApplicationBeforeRender(t)
					}, n.prototype.viewRendered = function () {
						return this.lastRenderedLocation = this.currentVisit.location, this.notifyApplicationAfterRender()
					}, n.prototype.pageLoaded = function () {
						return this.lastRenderedLocation = this.location, this.notifyApplicationAfterPageLoad()
					}, n.prototype.clickCaptured = function () {
						return removeEventListener("click", this.clickBubbled, !1), addEventListener("click", this.clickBubbled, !1)
					}, n.prototype.clickBubbled = function (t) {
						var e, n, i;
						return this.enabled && this.clickEventIsSignificant(t) && (n = this.getVisitableLinkForNode(t.target)) && (i = this.getVisitableLocationForLink(n)) && this.applicationAllowsFollowingLinkToLocation(n, i) ? (t.preventDefault(), e = this.getActionForLink(n), this.visit(i, {
							action: e
						})) : void 0
					}, n.prototype.applicationAllowsFollowingLinkToLocation = function (t, e) {
						var n;
						return n = this.notifyApplicationAfterClickingLinkToLocation(t, e), !n.defaultPrevented
					}, n.prototype.applicationAllowsVisitingLocation = function (t) {
						var e;
						return e = this.notifyApplicationBeforeVisitingLocation(t), !e.defaultPrevented
					}, n.prototype.notifyApplicationAfterClickingLinkToLocation = function (e, n) {
						return t.dispatch("turbolinks:click", {
							target: e,
							data: {
								url: n.absoluteURL
							},
							cancelable: !0
						})
					}, n.prototype.notifyApplicationBeforeVisitingLocation = function (e) {
						return t.dispatch("turbolinks:before-visit", {
							data: {
								url: e.absoluteURL
							},
							cancelable: !0
						})
					}, n.prototype.notifyApplicationAfterVisitingLocation = function (e) {
						return t.dispatch("turbolinks:visit", {
							data: {
								url: e.absoluteURL
							}
						})
					}, n.prototype.notifyApplicationBeforeCachingSnapshot = function () {
						return t.dispatch("turbolinks:before-cache")
					}, n.prototype.notifyApplicationBeforeRender = function (e) {
						return t.dispatch("turbolinks:before-render", {
							data: {
								newBody: e
							}
						})
					}, n.prototype.notifyApplicationAfterRender = function () {
						return t.dispatch("turbolinks:render")
					}, n.prototype.notifyApplicationAfterPageLoad = function (e) {
						return null == e && (e = {}), t.dispatch("turbolinks:load", {
							data: {
								url: this.location.absoluteURL,
								timing: e
							}
						})
					}, n.prototype.startVisit = function (t, e, n) {
						var i;
						return null != (i = this.currentVisit) && i.cancel(), this.currentVisit = this.createVisit(t, e, n), this.currentVisit.start(), this.notifyApplicationAfterVisitingLocation(t)
					}, n.prototype.createVisit = function (e, n, i) {
						var r, o, a, s, l;
						return o = null != i ? i : {}, s = o.restorationIdentifier, a = o.restorationData, r = o.historyChanged, l = new t.Visit(this, e, n), l.restorationIdentifier = null != s ? s : t.uuid(), l.restorationData = t.copyObject(a), l.historyChanged = r, l.referrer = this.location, l
					}, n.prototype.visitCompleted = function (t) {
						return this.notifyApplicationAfterPageLoad(t.getTimingMetrics())
					}, n.prototype.clickEventIsSignificant = function (t) {
						return !(t.defaultPrevented || t.target.isContentEditable || t.which > 1 || t.altKey || t.ctrlKey || t.metaKey || t.shiftKey)
					}, n.prototype.getVisitableLinkForNode = function (e) {
						return this.nodeIsVisitable(e) ? t.closest(e, "a[href]:not([target]):not([download])") : void 0
					}, n.prototype.getVisitableLocationForLink = function (e) {
						var n;
						return n = new t.Location(e.getAttribute("href")), this.locationIsVisitable(n) ? n : void 0
					}, n.prototype.getActionForLink = function (t) {
						var e;
						return null != (e = t.getAttribute("data-turbolinks-action")) ? e : "advance"
					}, n.prototype.nodeIsVisitable = function (e) {
						var n;
						return !(n = t.closest(e, "[data-turbolinks]")) || "false" !== n.getAttribute("data-turbolinks")
					}, n.prototype.locationIsVisitable = function (t) {
						return t.isPrefixedBy(this.view.getRootLocation()) && t.isHTML()
					}, n.prototype.getCurrentRestorationData = function () {
						return this.getRestorationDataForIdentifier(this.restorationIdentifier)
					}, n.prototype.getRestorationDataForIdentifier = function (t) {
						var e;
						return null != (e = this.restorationData)[t] ? e[t] : e[t] = {}
					}, n
				}()
			}.call(this),
			function () {
				var e, n, i;
				t.start = function () {
					return n() ? (null == t.controller && (t.controller = e()), t.controller.start()) : void 0
				}, n = function () {
					return null == window.Turbolinks && (window.Turbolinks = t), i()
				}, e = function () {
					var e;
					return e = new t.Controller, e.adapter = new t.BrowserAdapter(e), e
				}, (i = function () {
					return window.Turbolinks === t
				})() && t.start()
			}.call(this)
	}).call(this), "object" == typeof module && module.exports ? module.exports = t : "function" == typeof define && define.amd && define(t)
}.call(this);
var Util = function (t) {
		function e(t) {
			return {}.toString.call(t).match(/\s([a-zA-Z]+)/)[1].toLowerCase()
		}

		function n(t) {
			return (t[0] || t).nodeType
		}

		function i() {
			return {
				bindType: s.end,
				delegateType: s.end,
				handle: function (e) {
					return t(e.target).is(this) ? e.handleObj.handler.apply(this, arguments) : undefined
				}
			}
		}

		function r() {
			if (window.QUnit) return !1;
			var t = document.createElement("bootstrap");
			for (var e in u)
				if (t.style[e] !== undefined) return {
					end: u[e]
				};
			return !1
		}

		function o(e) {
			var n = this,
				i = !1;
			return t(this).one(c.TRANSITION_END, function () {
				i = !0
			}), setTimeout(function () {
				i || c.triggerTransitionEnd(n)
			}, e), this
		}

		function a() {
			s = r(), t.fn.emulateTransitionEnd = o, c.supportsTransitionEnd() && (t.event.special[c.TRANSITION_END] = i())
		}
		var s = !1,
			l = 1e6,
			u = {
				WebkitTransition: "webkitTransitionEnd",
				MozTransition: "transitionend",
				OTransition: "oTransitionEnd otransitionend",
				transition: "transitionend"
			},
			c = {
				TRANSITION_END: "bsTransitionEnd",
				getUID: function (t) {
					do {
						t += ~~(Math.random() * l)
					} while (document.getElementById(t));
					return t
				},
				getSelectorFromElement: function (e) {
					var n = e.getAttribute("data-target");
					n && "#" !== n || (n = e.getAttribute("href") || "");
					try {
						return t(n).length > 0 ? n : null
					} catch (t) {
						return null
					}
				},
				reflow: function (t) {
					return t.offsetHeight
				},
				triggerTransitionEnd: function (e) {
					t(e).trigger(s.end)
				},
				supportsTransitionEnd: function () {
					return Boolean(s)
				},
				typeCheckConfig: function (t, i, r) {
					for (var o in r)
						if (r.hasOwnProperty(o)) {
							var a = r[o],
								s = i[o],
								l = s && n(s) ? "element" : e(s);
							if (!new RegExp(a).test(l)) throw new Error(t.toUpperCase() + ': Option "' + o + '" provided type "' + l + '" but expected type "' + a + '".')
						}
				}
			};
		return a(), c
	}(jQuery),
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Alert = function (t) {
		var e = "alert",
			n = "4.0.0-beta",
			i = "bs.alert",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 150,
			l = {
				DISMISS: '[data-dismiss="alert"]'
			},
			u = {
				CLOSE: "close" + r,
				CLOSED: "closed" + r,
				CLICK_DATA_API: "click" + r + o
			},
			c = {
				ALERT: "alert",
				FADE: "fade",
				SHOW: "show"
			},
			p = function () {
				function e(t) {
					_classCallCheck(this, e), this._element = t
				}
				return e.prototype.close = function (t) {
					t = t || this._element;
					var e = this._getRootElement(t);
					this._triggerCloseEvent(e).isDefaultPrevented() || this._removeElement(e)
				}, e.prototype.dispose = function () {
					t.removeData(this._element, i), this._element = null
				}, e.prototype._getRootElement = function (e) {
					var n = Util.getSelectorFromElement(e),
						i = !1;
					return n && (i = t(n)[0]), i || (i = t(e).closest("." + c.ALERT)[0]), i
				}, e.prototype._triggerCloseEvent = function (e) {
					var n = t.Event(u.CLOSE);
					return t(e).trigger(n), n
				}, e.prototype._removeElement = function (e) {
					var n = this;
					if (t(e).removeClass(c.SHOW), !Util.supportsTransitionEnd() || !t(e).hasClass(c.FADE)) return void this._destroyElement(e);
					t(e).one(Util.TRANSITION_END, function (t) {
						return n._destroyElement(e, t)
					}).emulateTransitionEnd(s)
				}, e.prototype._destroyElement = function (e) {
					t(e).detach().trigger(u.CLOSED).remove()
				}, e._jQueryInterface = function (n) {
					return this.each(function () {
						var r = t(this),
							o = r.data(i);
						o || (o = new e(this), r.data(i, o)), "close" === n && o[n](this)
					})
				}, e._handleDismiss = function (t) {
					return function (e) {
						e && e.preventDefault(), t.close(this)
					}
				}, _createClass(e, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}]), e
			}();
		return t(document).on(u.CLICK_DATA_API, l.DISMISS, p._handleDismiss(new p)), t.fn[e] = p._jQueryInterface, t.fn[e].Constructor = p, t.fn[e].noConflict = function () {
			return t.fn[e] = a, p._jQueryInterface
		}, p
	}(jQuery),
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Button = function (t) {
		var e = "button",
			n = "4.0.0-beta",
			i = "bs.button",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = {
				ACTIVE: "active",
				BUTTON: "btn",
				FOCUS: "focus"
			},
			l = {
				DATA_TOGGLE_CARROT: '[data-toggle^="button"]',
				DATA_TOGGLE: '[data-toggle="buttons"]',
				INPUT: "input",
				ACTIVE: ".active",
				BUTTON: ".btn"
			},
			u = {
				CLICK_DATA_API: "click" + r + o,
				FOCUS_BLUR_DATA_API: "focus" + r + o + " blur" + r + o
			},
			c = function () {
				function e(t) {
					_classCallCheck(this, e), this._element = t
				}
				return e.prototype.toggle = function () {
					var e = !0,
						n = !0,
						i = t(this._element).closest(l.DATA_TOGGLE)[0];
					if (i) {
						var r = t(this._element).find(l.INPUT)[0];
						if (r) {
							if ("radio" === r.type)
								if (r.checked && t(this._element).hasClass(s.ACTIVE)) e = !1;
								else {
									var o = t(i).find(l.ACTIVE)[0];
									o && t(o).removeClass(s.ACTIVE)
								}
							if (e) {
								if (r.hasAttribute("disabled") || i.hasAttribute("disabled") || r.classList.contains("disabled") || i.classList.contains("disabled")) return;
								r.checked = !t(this._element).hasClass(s.ACTIVE), t(r).trigger("change")
							}
							r.focus(), n = !1
						}
					}
					n && this._element.setAttribute("aria-pressed", !t(this._element).hasClass(s.ACTIVE)), e && t(this._element).toggleClass(s.ACTIVE)
				}, e.prototype.dispose = function () {
					t.removeData(this._element, i), this._element = null
				}, e._jQueryInterface = function (n) {
					return this.each(function () {
						var r = t(this).data(i);
						r || (r = new e(this), t(this).data(i, r)), "toggle" === n && r[n]()
					})
				}, _createClass(e, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}]), e
			}();
		return t(document).on(u.CLICK_DATA_API, l.DATA_TOGGLE_CARROT, function (e) {
			e.preventDefault();
			var n = e.target;
			t(n).hasClass(s.BUTTON) || (n = t(n).closest(l.BUTTON)), c._jQueryInterface.call(t(n), "toggle")
		}).on(u.FOCUS_BLUR_DATA_API, l.DATA_TOGGLE_CARROT, function (e) {
			var n = t(e.target).closest(l.BUTTON)[0];
			t(n).toggleClass(s.FOCUS, /^focus(in)?$/.test(e.type))
		}), t.fn[e] = c._jQueryInterface, t.fn[e].Constructor = c, t.fn[e].noConflict = function () {
			return t.fn[e] = a, c._jQueryInterface
		}, c
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Carousel = function (t) {
		var e = "carousel",
			n = "4.0.0-beta",
			i = "bs.carousel",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 600,
			l = 37,
			u = 39,
			c = 500,
			p = {
				interval: 5e3,
				keyboard: !0,
				slide: !1,
				pause: "hover",
				wrap: !0
			},
			d = {
				interval: "(number|boolean)",
				keyboard: "boolean",
				slide: "(boolean|string)",
				pause: "(string|boolean)",
				wrap: "boolean"
			},
			f = {
				NEXT: "next",
				PREV: "prev",
				LEFT: "left",
				RIGHT: "right"
			},
			h = {
				SLIDE: "slide" + r,
				SLID: "slid" + r,
				KEYDOWN: "keydown" + r,
				MOUSEENTER: "mouseenter" + r,
				MOUSELEAVE: "mouseleave" + r,
				TOUCHEND: "touchend" + r,
				LOAD_DATA_API: "load" + r + o,
				CLICK_DATA_API: "click" + r + o
			},
			m = {
				CAROUSEL: "carousel",
				ACTIVE: "active",
				SLIDE: "slide",
				RIGHT: "carousel-item-right",
				LEFT: "carousel-item-left",
				NEXT: "carousel-item-next",
				PREV: "carousel-item-prev",
				ITEM: "carousel-item"
			},
			g = {
				ACTIVE: ".active",
				ACTIVE_ITEM: ".active.carousel-item",
				ITEM: ".carousel-item",
				NEXT_PREV: ".carousel-item-next, .carousel-item-prev",
				INDICATORS: ".carousel-indicators",
				DATA_SLIDE: "[data-slide], [data-slide-to]",
				DATA_RIDE: '[data-ride="carousel"]'
			},
			v = function () {
				function o(e, n) {
					_classCallCheck(this, o), this._items = null, this._interval = null, this._activeElement = null, this._isPaused = !1, this._isSliding = !1, this.touchTimeout = null, this._config = this._getConfig(n), this._element = t(e)[0], this._indicatorsElement = t(this._element).find(g.INDICATORS)[0], this._addEventListeners()
				}
				return o.prototype.next = function () {
					this._isSliding || this._slide(f.NEXT)
				}, o.prototype.nextWhenVisible = function () {
					document.hidden || this.next()
				}, o.prototype.prev = function () {
					this._isSliding || this._slide(f.PREV)
				}, o.prototype.pause = function (e) {
					e || (this._isPaused = !0), t(this._element).find(g.NEXT_PREV)[0] && Util.supportsTransitionEnd() && (Util.triggerTransitionEnd(this._element), this.cycle(!0)), clearInterval(this._interval), this._interval = null
				}, o.prototype.cycle = function (t) {
					t || (this._isPaused = !1), this._interval && (clearInterval(this._interval), this._interval = null), this._config.interval && !this._isPaused && (this._interval = setInterval((document.visibilityState ? this.nextWhenVisible : this.next).bind(this), this._config.interval))
				}, o.prototype.to = function (e) {
					var n = this;
					this._activeElement = t(this._element).find(g.ACTIVE_ITEM)[0];
					var i = this._getItemIndex(this._activeElement);
					if (!(e > this._items.length - 1 || e < 0)) {
						if (this._isSliding) return void t(this._element).one(h.SLID, function () {
							return n.to(e)
						});
						if (i === e) return this.pause(), void this.cycle();
						var r = e > i ? f.NEXT : f.PREV;
						this._slide(r, this._items[e])
					}
				}, o.prototype.dispose = function () {
					t(this._element).off(r), t.removeData(this._element, i), this._items = null, this._config = null, this._element = null, this._interval = null, this._isPaused = null, this._isSliding = null, this._activeElement = null, this._indicatorsElement = null
				}, o.prototype._getConfig = function (n) {
					return n = t.extend({}, p, n), Util.typeCheckConfig(e, n, d), n
				}, o.prototype._addEventListeners = function () {
					var e = this;
					this._config.keyboard && t(this._element).on(h.KEYDOWN, function (t) {
						return e._keydown(t)
					}), "hover" === this._config.pause && (t(this._element).on(h.MOUSEENTER, function (t) {
						return e.pause(t)
					}).on(h.MOUSELEAVE, function (t) {
						return e.cycle(t)
					}), "ontouchstart" in document.documentElement && t(this._element).on(h.TOUCHEND, function () {
						e.pause(), e.touchTimeout && clearTimeout(e.touchTimeout), e.touchTimeout = setTimeout(function (t) {
							return e.cycle(t)
						}, c + e._config.interval)
					}))
				}, o.prototype._keydown = function (t) {
					if (!/input|textarea/i.test(t.target.tagName)) switch (t.which) {
						case l:
							t.preventDefault(), this.prev();
							break;
						case u:
							t.preventDefault(), this.next();
							break;
						default:
							return
					}
				}, o.prototype._getItemIndex = function (e) {
					return this._items = t.makeArray(t(e).parent().find(g.ITEM)), this._items.indexOf(e)
				}, o.prototype._getItemByDirection = function (t, e) {
					var n = t === f.NEXT,
						i = t === f.PREV,
						r = this._getItemIndex(e),
						o = this._items.length - 1;
					if ((i && 0 === r || n && r === o) && !this._config.wrap) return e;
					var a = t === f.PREV ? -1 : 1,
						s = (r + a) % this._items.length;
					return -1 === s ? this._items[this._items.length - 1] : this._items[s]
				}, o.prototype._triggerSlideEvent = function (e, n) {
					var i = this._getItemIndex(e),
						r = this._getItemIndex(t(this._element).find(g.ACTIVE_ITEM)[0]),
						o = t.Event(h.SLIDE, {
							relatedTarget: e,
							direction: n,
							from: r,
							to: i
						});
					return t(this._element).trigger(o), o
				}, o.prototype._setActiveIndicatorElement = function (e) {
					if (this._indicatorsElement) {
						t(this._indicatorsElement).find(g.ACTIVE).removeClass(m.ACTIVE);
						var n = this._indicatorsElement.children[this._getItemIndex(e)];
						n && t(n).addClass(m.ACTIVE)
					}
				}, o.prototype._slide = function (e, n) {
					var i = this,
						r = t(this._element).find(g.ACTIVE_ITEM)[0],
						o = this._getItemIndex(r),
						a = n || r && this._getItemByDirection(e, r),
						l = this._getItemIndex(a),
						u = Boolean(this._interval),
						c = void 0,
						p = void 0,
						d = void 0;
					if (e === f.NEXT ? (c = m.LEFT, p = m.NEXT, d = f.LEFT) : (c = m.RIGHT, p = m.PREV, d = f.RIGHT), a && t(a).hasClass(m.ACTIVE)) return void(this._isSliding = !1);
					if (!this._triggerSlideEvent(a, d).isDefaultPrevented() && r && a) {
						this._isSliding = !0, u && this.pause(), this._setActiveIndicatorElement(a);
						var v = t.Event(h.SLID, {
							relatedTarget: a,
							direction: d,
							from: o,
							to: l
						});
						Util.supportsTransitionEnd() && t(this._element).hasClass(m.SLIDE) ? (t(a).addClass(p), Util.reflow(a), t(r).addClass(c), t(a).addClass(c), t(r).one(Util.TRANSITION_END, function () {
							t(a).removeClass(c + " " + p).addClass(m.ACTIVE), t(r).removeClass(m.ACTIVE + " " + p + " " + c), i._isSliding = !1, setTimeout(function () {
								return t(i._element).trigger(v)
							}, 0)
						}).emulateTransitionEnd(s)) : (t(r).removeClass(m.ACTIVE), t(a).addClass(m.ACTIVE), this._isSliding = !1, t(this._element).trigger(v)), u && this.cycle()
					}
				}, o._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this).data(i),
							r = t.extend({}, p, t(this).data());
						"object" === (void 0 === e ? "undefined" : _typeof(e)) && t.extend(r, e);
						var a = "string" == typeof e ? e : r.slide;
						if (n || (n = new o(this, r), t(this).data(i, n)), "number" == typeof e) n.to(e);
						else if ("string" == typeof a) {
							if (n[a] === undefined) throw new Error('No method named "' + a + '"');
							n[a]()
						} else r.interval && (n.pause(), n.cycle())
					})
				}, o._dataApiClickHandler = function (e) {
					var n = Util.getSelectorFromElement(this);
					if (n) {
						var r = t(n)[0];
						if (r && t(r).hasClass(m.CAROUSEL)) {
							var a = t.extend({}, t(r).data(), t(this).data()),
								s = this.getAttribute("data-slide-to");
							s && (a.interval = !1), o._jQueryInterface.call(t(r), a), s && t(r).data(i).to(s), e.preventDefault()
						}
					}
				}, _createClass(o, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return p
					}
				}]), o
			}();
		return t(document).on(h.CLICK_DATA_API, g.DATA_SLIDE, v._dataApiClickHandler), t(window).on(h.LOAD_DATA_API, function () {
			t(g.DATA_RIDE).each(function () {
				var e = t(this);
				v._jQueryInterface.call(e, e.data())
			})
		}), t.fn[e] = v._jQueryInterface, t.fn[e].Constructor = v, t.fn[e].noConflict = function () {
			return t.fn[e] = a, v._jQueryInterface
		}, v
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Collapse = function (t) {
		var e = "collapse",
			n = "4.0.0-beta",
			i = "bs.collapse",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 600,
			l = {
				toggle: !0,
				parent: ""
			},
			u = {
				toggle: "boolean",
				parent: "string"
			},
			c = {
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				CLICK_DATA_API: "click" + r + o
			},
			p = {
				SHOW: "show",
				COLLAPSE: "collapse",
				COLLAPSING: "collapsing",
				COLLAPSED: "collapsed"
			},
			d = {
				WIDTH: "width",
				HEIGHT: "height"
			},
			f = {
				ACTIVES: ".show, .collapsing",
				DATA_TOGGLE: '[data-toggle="collapse"]'
			},
			h = function () {
				function r(e, n) {
					_classCallCheck(this, r), this._isTransitioning = !1, this._element = e, this._config = this._getConfig(n), this._triggerArray = t.makeArray(t('[data-toggle="collapse"][href="#' + e.id + '"],[data-toggle="collapse"][data-target="#' + e.id + '"]'));
					for (var i = t(f.DATA_TOGGLE), o = 0; o < i.length; o++) {
						var a = i[o],
							s = Util.getSelectorFromElement(a);
						null !== s && t(s).filter(e).length > 0 && this._triggerArray.push(a)
					}
					this._parent = this._config.parent ? this._getParent() : null, this._config.parent || this._addAriaAndCollapsedClass(this._element, this._triggerArray), this._config.toggle && this.toggle()
				}
				return r.prototype.toggle = function () {
					t(this._element).hasClass(p.SHOW) ? this.hide() : this.show()
				}, r.prototype.show = function () {
					var e = this;
					if (!this._isTransitioning && !t(this._element).hasClass(p.SHOW)) {
						var n = void 0,
							o = void 0;
						if (this._parent && (n = t.makeArray(t(this._parent).children().children(f.ACTIVES)), n.length || (n = null)), !(n && (o = t(n).data(i)) && o._isTransitioning)) {
							var a = t.Event(c.SHOW);
							if (t(this._element).trigger(a), !a.isDefaultPrevented()) {
								n && (r._jQueryInterface.call(t(n), "hide"), o || t(n).data(i, null));
								var l = this._getDimension();
								t(this._element).removeClass(p.COLLAPSE).addClass(p.COLLAPSING), this._element.style[l] = 0, this._triggerArray.length && t(this._triggerArray).removeClass(p.COLLAPSED).attr("aria-expanded", !0), this.setTransitioning(!0);
								var u = function () {
									t(e._element).removeClass(p.COLLAPSING).addClass(p.COLLAPSE).addClass(p.SHOW), e._element.style[l] = "", e.setTransitioning(!1), t(e._element).trigger(c.SHOWN)
								};
								if (!Util.supportsTransitionEnd()) return void u();
								var d = l[0].toUpperCase() + l.slice(1),
									h = "scroll" + d;
								t(this._element).one(Util.TRANSITION_END, u).emulateTransitionEnd(s), this._element.style[l] = this._element[h] + "px"
							}
						}
					}
				}, r.prototype.hide = function () {
					var e = this;
					if (!this._isTransitioning && t(this._element).hasClass(p.SHOW)) {
						var n = t.Event(c.HIDE);
						if (t(this._element).trigger(n), !n.isDefaultPrevented()) {
							var i = this._getDimension();
							if (this._element.style[i] = this._element.getBoundingClientRect()[i] + "px", Util.reflow(this._element), t(this._element).addClass(p.COLLAPSING).removeClass(p.COLLAPSE).removeClass(p.SHOW), this._triggerArray.length)
								for (var r = 0; r < this._triggerArray.length; r++) {
									var o = this._triggerArray[r],
										a = Util.getSelectorFromElement(o);
									if (null !== a) {
										var l = t(a);
										l.hasClass(p.SHOW) || t(o).addClass(p.COLLAPSED).attr("aria-expanded", !1)
									}
								}
							this.setTransitioning(!0);
							var u = function () {
								e.setTransitioning(!1), t(e._element).removeClass(p.COLLAPSING).addClass(p.COLLAPSE).trigger(c.HIDDEN)
							};
							if (this._element.style[i] = "", !Util.supportsTransitionEnd()) return void u();
							t(this._element).one(Util.TRANSITION_END, u).emulateTransitionEnd(s)
						}
					}
				}, r.prototype.setTransitioning = function (t) {
					this._isTransitioning = t
				}, r.prototype.dispose = function () {
					t.removeData(this._element, i), this._config = null, this._parent = null, this._element = null, this._triggerArray = null, this._isTransitioning = null
				}, r.prototype._getConfig = function (n) {
					return n = t.extend({}, l, n), n.toggle = Boolean(n.toggle), Util.typeCheckConfig(e, n, u), n
				}, r.prototype._getDimension = function () {
					return t(this._element).hasClass(d.WIDTH) ? d.WIDTH : d.HEIGHT
				}, r.prototype._getParent = function () {
					var e = this,
						n = t(this._config.parent)[0],
						i = '[data-toggle="collapse"][data-parent="' + this._config.parent + '"]';
					return t(n).find(i).each(function (t, n) {
						e._addAriaAndCollapsedClass(r._getTargetFromElement(n), [n])
					}), n
				}, r.prototype._addAriaAndCollapsedClass = function (e, n) {
					if (e) {
						var i = t(e).hasClass(p.SHOW);
						n.length && t(n).toggleClass(p.COLLAPSED, !i).attr("aria-expanded", i)
					}
				}, r._getTargetFromElement = function (e) {
					var n = Util.getSelectorFromElement(e);
					return n ? t(n)[0] : null
				}, r._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this),
							o = n.data(i),
							a = t.extend({}, l, n.data(), "object" === (void 0 === e ? "undefined" : _typeof(e)) && e);
						if (!o && a.toggle && /show|hide/.test(e) && (a.toggle = !1), o || (o = new r(this, a), n.data(i, o)), "string" == typeof e) {
							if (o[e] === undefined) throw new Error('No method named "' + e + '"');
							o[e]()
						}
					})
				}, _createClass(r, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return l
					}
				}]), r
			}();
		return t(document).on(c.CLICK_DATA_API, f.DATA_TOGGLE, function (e) {
			/input|textarea/i.test(e.target.tagName) || e.preventDefault();
			var n = t(this),
				r = Util.getSelectorFromElement(this);
			t(r).each(function () {
				var e = t(this),
					r = e.data(i),
					o = r ? "toggle" : n.data();
				h._jQueryInterface.call(e, o)
			})
		}), t.fn[e] = h._jQueryInterface, t.fn[e].Constructor = h, t.fn[e].noConflict = function () {
			return t.fn[e] = a, h._jQueryInterface
		}, h
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Dropdown = function (t) {
		if ("undefined" == typeof Popper) throw new Error("Bootstrap dropdown require Popper.js (https://popper.js.org)");
		var e = "dropdown",
			n = "4.0.0-beta",
			i = "bs.dropdown",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 27,
			l = 32,
			u = 9,
			c = 38,
			p = 40,
			d = 3,
			f = new RegExp(c + "|" + p + "|" + s),
			h = {
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				CLICK: "click" + r,
				CLICK_DATA_API: "click" + r + o,
				KEYDOWN_DATA_API: "keydown" + r + o,
				KEYUP_DATA_API: "keyup" + r + o
			},
			m = {
				DISABLED: "disabled",
				SHOW: "show",
				DROPUP: "dropup",
				MENURIGHT: "dropdown-menu-right",
				MENULEFT: "dropdown-menu-left"
			},
			g = {
				DATA_TOGGLE: '[data-toggle="dropdown"]',
				FORM_CHILD: ".dropdown form",
				MENU: ".dropdown-menu",
				NAVBAR_NAV: ".navbar-nav",
				VISIBLE_ITEMS: ".dropdown-menu .dropdown-item:not(.disabled)"
			},
			v = {
				TOP: "top-start",
				TOPEND: "top-end",
				BOTTOM: "bottom-start",
				BOTTOMEND: "bottom-end"
			},
			y = {
				placement: v.BOTTOM,
				offset: 0,
				flip: !0
			},
			b = {
				placement: "string",
				offset: "(number|string)",
				flip: "boolean"
			},
			_ = function () {
				function o(t, e) {
					_classCallCheck(this, o), this._element = t, this._popper = null, this._config = this._getConfig(e), this._menu = this._getMenuElement(), this._inNavbar = this._detectNavbar(), this._addEventListeners()
				}
				return o.prototype.toggle = function () {
					if (!this._element.disabled && !t(this._element).hasClass(m.DISABLED)) {
						var e = o._getParentFromElement(this._element),
							n = t(this._menu).hasClass(m.SHOW);
						if (o._clearMenus(), !n) {
							var i = {
									relatedTarget: this._element
								},
								r = t.Event(h.SHOW, i);
							if (t(e).trigger(r), !r.isDefaultPrevented()) {
								var a = this._element;
								t(e).hasClass(m.DROPUP) && (t(this._menu).hasClass(m.MENULEFT) || t(this._menu).hasClass(m.MENURIGHT)) && (a = e), this._popper = new Popper(a, this._menu, this._getPopperConfig()), "ontouchstart" in document.documentElement && !t(e).closest(g.NAVBAR_NAV).length && t("body").children().on("mouseover", null, t.noop), this._element.focus(), this._element.setAttribute("aria-expanded", !0), t(this._menu).toggleClass(m.SHOW), t(e).toggleClass(m.SHOW).trigger(t.Event(h.SHOWN, i))
							}
						}
					}
				}, o.prototype.dispose = function () {
					t.removeData(this._element, i), t(this._element).off(r), this._element = null, this._menu = null, null !== this._popper && this._popper.destroy(), this._popper = null
				}, o.prototype.update = function () {
					this._inNavbar = this._detectNavbar(), null !== this._popper && this._popper.scheduleUpdate()
				}, o.prototype._addEventListeners = function () {
					var e = this;
					t(this._element).on(h.CLICK, function (t) {
						t.preventDefault(), t.stopPropagation(), e.toggle()
					})
				}, o.prototype._getConfig = function (n) {
					var i = t(this._element).data();
					return i.placement !== undefined && (i.placement = v[i.placement.toUpperCase()]), n = t.extend({}, this.constructor.Default, t(this._element).data(), n), Util.typeCheckConfig(e, n, this.constructor.DefaultType), n
				}, o.prototype._getMenuElement = function () {
					if (!this._menu) {
						var e = o._getParentFromElement(this._element);
						this._menu = t(e).find(g.MENU)[0]
					}
					return this._menu
				}, o.prototype._getPlacement = function () {
					var e = t(this._element).parent(),
						n = this._config.placement;
					return e.hasClass(m.DROPUP) || this._config.placement === v.TOP ? (n = v.TOP, t(this._menu).hasClass(m.MENURIGHT) && (n = v.TOPEND)) : t(this._menu).hasClass(m.MENURIGHT) && (n = v.BOTTOMEND), n
				}, o.prototype._detectNavbar = function () {
					return t(this._element).closest(".navbar").length > 0
				}, o.prototype._getPopperConfig = function () {
					var t = {
						placement: this._getPlacement(),
						modifiers: {
							offset: {
								offset: this._config.offset
							},
							flip: {
								enabled: this._config.flip
							}
						}
					};
					return this._inNavbar && (t.modifiers.applyStyle = {
						enabled: !this._inNavbar
					}), t
				}, o._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this).data(i),
							r = "object" === (void 0 === e ? "undefined" : _typeof(e)) ? e : null;
						if (n || (n = new o(this, r), t(this).data(i, n)), "string" == typeof e) {
							if (n[e] === undefined) throw new Error('No method named "' + e + '"');
							n[e]()
						}
					})
				}, o._clearMenus = function (e) {
					if (!e || e.which !== d && ("keyup" !== e.type || e.which === u))
						for (var n = t.makeArray(t(g.DATA_TOGGLE)), r = 0; r < n.length; r++) {
							var a = o._getParentFromElement(n[r]),
								s = t(n[r]).data(i),
								l = {
									relatedTarget: n[r]
								};
							if (s) {
								var c = s._menu;
								if (t(a).hasClass(m.SHOW) && !(e && ("click" === e.type && /input|textarea/i.test(e.target.tagName) || "keyup" === e.type && e.which === u) && t.contains(a, e.target))) {
									var p = t.Event(h.HIDE, l);
									t(a).trigger(p), p.isDefaultPrevented() || ("ontouchstart" in document.documentElement && t("body").children().off("mouseover", null, t.noop), n[r].setAttribute("aria-expanded", "false"), t(c).removeClass(m.SHOW), t(a).removeClass(m.SHOW).trigger(t.Event(h.HIDDEN, l)))
								}
							}
						}
				}, o._getParentFromElement = function (e) {
					var n = void 0,
						i = Util.getSelectorFromElement(e);
					return i && (n = t(i)[0]), n || e.parentNode
				}, o._dataApiKeydownHandler = function (e) {
					if (!(!f.test(e.which) || /button/i.test(e.target.tagName) && e.which === l || /input|textarea/i.test(e.target.tagName) || (e.preventDefault(), e.stopPropagation(), this.disabled || t(this).hasClass(m.DISABLED)))) {
						var n = o._getParentFromElement(this),
							i = t(n).hasClass(m.SHOW);
						if (!i && (e.which !== s || e.which !== l) || i && (e.which === s || e.which === l)) {
							if (e.which === s) {
								var r = t(n).find(g.DATA_TOGGLE)[0];
								t(r).trigger("focus")
							}
							return void t(this).trigger("click")
						}
						var a = t(n).find(g.VISIBLE_ITEMS).get();
						if (a.length) {
							var u = a.indexOf(e.target);
							e.which === c && u > 0 && u--, e.which === p && u < a.length - 1 && u++, u < 0 && (u = 0), a[u].focus()
						}
					}
				}, _createClass(o, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return y
					}
				}, {
					key: "DefaultType",
					get: function () {
						return b
					}
				}]), o
			}();
		return t(document).on(h.KEYDOWN_DATA_API, g.DATA_TOGGLE, _._dataApiKeydownHandler).on(h.KEYDOWN_DATA_API, g.MENU, _._dataApiKeydownHandler).on(h.CLICK_DATA_API + " " + h.KEYUP_DATA_API, _._clearMenus).on(h.CLICK_DATA_API, g.DATA_TOGGLE, function (e) {
			e.preventDefault(), e.stopPropagation(), _._jQueryInterface.call(t(this), "toggle")
		}).on(h.CLICK_DATA_API, g.FORM_CHILD, function (t) {
			t.stopPropagation()
		}), t.fn[e] = _._jQueryInterface, t.fn[e].Constructor = _, t.fn[e].noConflict = function () {
			return t.fn[e] = a, _._jQueryInterface
		}, _
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Modal = function (t) {
		var e = "modal",
			n = "4.0.0-beta",
			i = "bs.modal",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 300,
			l = 150,
			u = 27,
			c = {
				backdrop: !0,
				keyboard: !0,
				focus: !0,
				show: !0
			},
			p = {
				backdrop: "(boolean|string)",
				keyboard: "boolean",
				focus: "boolean",
				show: "boolean"
			},
			d = {
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				FOCUSIN: "focusin" + r,
				RESIZE: "resize" + r,
				CLICK_DISMISS: "click.dismiss" + r,
				KEYDOWN_DISMISS: "keydown.dismiss" + r,
				MOUSEUP_DISMISS: "mouseup.dismiss" + r,
				MOUSEDOWN_DISMISS: "mousedown.dismiss" + r,
				CLICK_DATA_API: "click" + r + o
			},
			f = {
				SCROLLBAR_MEASURER: "modal-scrollbar-measure",
				BACKDROP: "modal-backdrop",
				OPEN: "modal-open",
				FADE: "fade",
				SHOW: "show"
			},
			h = {
				DIALOG: ".modal-dialog",
				DATA_TOGGLE: '[data-toggle="modal"]',
				DATA_DISMISS: '[data-dismiss="modal"]',
				FIXED_CONTENT: ".fixed-top, .fixed-bottom, .is-fixed, .sticky-top",
				NAVBAR_TOGGLER: ".navbar-toggler"
			},
			m = function () {
				function o(e, n) {
					_classCallCheck(this, o), this._config = this._getConfig(n), this._element = e, this._dialog = t(e).find(h.DIALOG)[0], this._backdrop = null, this._isShown = !1, this._isBodyOverflowing = !1, this._ignoreBackdropClick = !1, this._originalBodyPadding = 0, this._scrollbarWidth = 0
				}
				return o.prototype.toggle = function (t) {
					return this._isShown ? this.hide() : this.show(t)
				}, o.prototype.show = function (e) {
					var n = this;
					if (!this._isTransitioning) {
						Util.supportsTransitionEnd() && t(this._element).hasClass(f.FADE) && (this._isTransitioning = !0);
						var i = t.Event(d.SHOW, {
							relatedTarget: e
						});
						t(this._element).trigger(i), this._isShown || i.isDefaultPrevented() || (this._isShown = !0, this._checkScrollbar(), this._setScrollbar(), t(document.body).addClass(f.OPEN), this._setEscapeEvent(), this._setResizeEvent(), t(this._element).on(d.CLICK_DISMISS, h.DATA_DISMISS, function (t) {
							return n.hide(t)
						}), t(this._dialog).on(d.MOUSEDOWN_DISMISS, function () {
							t(n._element).one(d.MOUSEUP_DISMISS, function (e) {
								t(e.target).is(n._element) && (n._ignoreBackdropClick = !0)
							})
						}), this._showBackdrop(function () {
							return n._showElement(e)
						}))
					}
				}, o.prototype.hide = function (e) {
					var n = this;
					if (e && e.preventDefault(), !this._isTransitioning && this._isShown) {
						var i = Util.supportsTransitionEnd() && t(this._element).hasClass(f.FADE);
						i && (this._isTransitioning = !0);
						var r = t.Event(d.HIDE);
						t(this._element).trigger(r), this._isShown && !r.isDefaultPrevented() && (this._isShown = !1, this._setEscapeEvent(), this._setResizeEvent(), t(document).off(d.FOCUSIN), t(this._element).removeClass(f.SHOW), t(this._element).off(d.CLICK_DISMISS), t(this._dialog).off(d.MOUSEDOWN_DISMISS), i ? t(this._element).one(Util.TRANSITION_END, function (t) {
							return n._hideModal(t)
						}).emulateTransitionEnd(s) : this._hideModal())
					}
				}, o.prototype.dispose = function () {
					t.removeData(this._element, i), t(window, document, this._element, this._backdrop).off(r), this._config = null, this._element = null, this._dialog = null, this._backdrop = null, this._isShown = null, this._isBodyOverflowing = null, this._ignoreBackdropClick = null, this._scrollbarWidth = null
				}, o.prototype.handleUpdate = function () {
					this._adjustDialog()
				}, o.prototype._getConfig = function (n) {
					return n = t.extend({}, c, n), Util.typeCheckConfig(e, n, p), n
				}, o.prototype._showElement = function (e) {
					var n = this,
						i = Util.supportsTransitionEnd() && t(this._element).hasClass(f.FADE);
					this._element.parentNode && this._element.parentNode.nodeType === Node.ELEMENT_NODE || document.body.appendChild(this._element), this._element.style.display = "block", this._element.removeAttribute("aria-hidden"), this._element.scrollTop = 0, i && Util.reflow(this._element), t(this._element).addClass(f.SHOW), this._config.focus && this._enforceFocus();
					var r = t.Event(d.SHOWN, {
							relatedTarget: e
						}),
						o = function () {
							n._config.focus && n._element.focus(), n._isTransitioning = !1, t(n._element).trigger(r)
						};
					i ? t(this._dialog).one(Util.TRANSITION_END, o).emulateTransitionEnd(s) : o()
				}, o.prototype._enforceFocus = function () {
					var e = this;
					t(document).off(d.FOCUSIN).on(d.FOCUSIN, function (n) {
						document === n.target || e._element === n.target || t(e._element).has(n.target).length || e._element.focus()
					})
				}, o.prototype._setEscapeEvent = function () {
					var e = this;
					this._isShown && this._config.keyboard ? t(this._element).on(d.KEYDOWN_DISMISS, function (t) {
						t.which === u && (t.preventDefault(), e.hide())
					}) : this._isShown || t(this._element).off(d.KEYDOWN_DISMISS)
				}, o.prototype._setResizeEvent = function () {
					var e = this;
					this._isShown ? t(window).on(d.RESIZE, function (t) {
						return e.handleUpdate(t)
					}) : t(window).off(d.RESIZE)
				}, o.prototype._hideModal = function () {
					var e = this;
					this._element.style.display = "none", this._element.setAttribute("aria-hidden", !0), this._isTransitioning = !1, this._showBackdrop(function () {
						t(document.body).removeClass(f.OPEN), e._resetAdjustments(), e._resetScrollbar(), t(e._element).trigger(d.HIDDEN)
					})
				}, o.prototype._removeBackdrop = function () {
					this._backdrop && (t(this._backdrop).remove(), this._backdrop = null)
				}, o.prototype._showBackdrop = function (e) {
					var n = this,
						i = t(this._element).hasClass(f.FADE) ? f.FADE : "";
					if (this._isShown && this._config.backdrop) {
						var r = Util.supportsTransitionEnd() && i;
						if (this._backdrop = document.createElement("div"), this._backdrop.className = f.BACKDROP, i && t(this._backdrop).addClass(i), t(this._backdrop).appendTo(document.body), t(this._element).on(d.CLICK_DISMISS, function (t) {
								if (n._ignoreBackdropClick) return void(n._ignoreBackdropClick = !1);
								t.target === t.currentTarget && ("static" === n._config.backdrop ? n._element.focus() : n.hide())
							}), r && Util.reflow(this._backdrop), t(this._backdrop).addClass(f.SHOW), !e) return;
						if (!r) return void e();
						t(this._backdrop).one(Util.TRANSITION_END, e).emulateTransitionEnd(l)
					} else if (!this._isShown && this._backdrop) {
						t(this._backdrop).removeClass(f.SHOW);
						var o = function () {
							n._removeBackdrop(), e && e()
						};
						Util.supportsTransitionEnd() && t(this._element).hasClass(f.FADE) ? t(this._backdrop).one(Util.TRANSITION_END, o).emulateTransitionEnd(l) : o()
					} else e && e()
				}, o.prototype._adjustDialog = function () {
					var t = this._element.scrollHeight > document.documentElement.clientHeight;
					!this._isBodyOverflowing && t && (this._element.style.paddingLeft = this._scrollbarWidth + "px"), this._isBodyOverflowing && !t && (this._element.style.paddingRight = this._scrollbarWidth + "px")
				}, o.prototype._resetAdjustments = function () {
					this._element.style.paddingLeft = "", this._element.style.paddingRight = ""
				}, o.prototype._checkScrollbar = function () {
					this._isBodyOverflowing = document.body.clientWidth < window.innerWidth, this._scrollbarWidth = this._getScrollbarWidth()
				}, o.prototype._setScrollbar = function () {
					var e = this;
					if (this._isBodyOverflowing) {
						t(h.FIXED_CONTENT).each(function (n, i) {
							var r = t(i)[0].style.paddingRight,
								o = t(i).css("padding-right");
							t(i).data("padding-right", r).css("padding-right", parseFloat(o) + e._scrollbarWidth + "px")
						}), t(h.NAVBAR_TOGGLER).each(function (n, i) {
							var r = t(i)[0].style.marginRight,
								o = t(i).css("margin-right");
							t(i).data("margin-right", r).css("margin-right", parseFloat(o) + e._scrollbarWidth + "px")
						});
						var n = document.body.style.paddingRight,
							i = t("body").css("padding-right");
						t("body").data("padding-right", n).css("padding-right", parseFloat(i) + this._scrollbarWidth + "px")
					}
				}, o.prototype._resetScrollbar = function () {
					t(h.FIXED_CONTENT).each(function (e, n) {
						var i = t(n).data("padding-right");
						void 0 !== i && t(n).css("padding-right", i).removeData("padding-right")
					}), t(h.NAVBAR_TOGGLER).each(function (e, n) {
						var i = t(n).data("margin-right");
						void 0 !== i && t(n).css("margin-right", i).removeData("margin-right")
					});
					var e = t("body").data("padding-right");
					void 0 !== e && t("body").css("padding-right", e).removeData("padding-right")
				}, o.prototype._getScrollbarWidth = function () {
					var t = document.createElement("div");
					t.className = f.SCROLLBAR_MEASURER, document.body.appendChild(t);
					var e = t.getBoundingClientRect().width - t.clientWidth;
					return document.body.removeChild(t), e
				}, o._jQueryInterface = function (e, n) {
					return this.each(function () {
						var r = t(this).data(i),
							a = t.extend({}, o.Default, t(this).data(), "object" === (void 0 === e ? "undefined" : _typeof(e)) && e);
						if (r || (r = new o(this, a), t(this).data(i, r)), "string" == typeof e) {
							if (r[e] === undefined) throw new Error('No method named "' + e + '"');
							r[e](n)
						} else a.show && r.show(n)
					})
				}, _createClass(o, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return c
					}
				}]), o
			}();
		return t(document).on(d.CLICK_DATA_API, h.DATA_TOGGLE, function (e) {
			var n = this,
				r = void 0,
				o = Util.getSelectorFromElement(this);
			o && (r = t(o)[0]);
			var a = t(r).data(i) ? "toggle" : t.extend({}, t(r).data(), t(this).data());
			"A" !== this.tagName && "AREA" !== this.tagName || e.preventDefault();
			var s = t(r).one(d.SHOW, function (e) {
				e.isDefaultPrevented() || s.one(d.HIDDEN, function () {
					t(n).is(":visible") && n.focus()
				})
			});
			m._jQueryInterface.call(t(r), a, this)
		}), t.fn[e] = m._jQueryInterface, t.fn[e].Constructor = m, t.fn[e].noConflict = function () {
			return t.fn[e] = a, m._jQueryInterface
		}, m
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	ScrollSpy = function (t) {
		var e = "scrollspy",
			n = "4.0.0-beta",
			i = "bs.scrollspy",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = {
				offset: 10,
				method: "auto",
				target: ""
			},
			l = {
				offset: "number",
				method: "string",
				target: "(string|element)"
			},
			u = {
				ACTIVATE: "activate" + r,
				SCROLL: "scroll" + r,
				LOAD_DATA_API: "load" + r + o
			},
			c = {
				DROPDOWN_ITEM: "dropdown-item",
				DROPDOWN_MENU: "dropdown-menu",
				ACTIVE: "active"
			},
			p = {
				DATA_SPY: '[data-spy="scroll"]',
				ACTIVE: ".active",
				NAV_LIST_GROUP: ".nav, .list-group",
				NAV_LINKS: ".nav-link",
				LIST_ITEMS: ".list-group-item",
				DROPDOWN: ".dropdown",
				DROPDOWN_ITEMS: ".dropdown-item",
				DROPDOWN_TOGGLE: ".dropdown-toggle"
			},
			d = {
				OFFSET: "offset",
				POSITION: "position"
			},
			f = function () {
				function o(e, n) {
					var i = this;
					_classCallCheck(this, o), this._element = e, this._scrollElement = "BODY" === e.tagName ? window : e, this._config = this._getConfig(n), this._selector = this._config.target + " " + p.NAV_LINKS + "," + this._config.target + " " + p.LIST_ITEMS + "," + this._config.target + " " + p.DROPDOWN_ITEMS, this._offsets = [], this._targets = [], this._activeTarget = null, this._scrollHeight = 0, t(this._scrollElement).on(u.SCROLL, function (t) {
						return i._process(t)
					}), this.refresh(), this._process()
				}
				return o.prototype.refresh = function () {
					var e = this,
						n = this._scrollElement !== this._scrollElement.window ? d.POSITION : d.OFFSET,
						i = "auto" === this._config.method ? n : this._config.method,
						r = i === d.POSITION ? this._getScrollTop() : 0;
					this._offsets = [], this._targets = [], this._scrollHeight = this._getScrollHeight(), t.makeArray(t(this._selector)).map(function (e) {
						var n = void 0,
							o = Util.getSelectorFromElement(e);
						if (o && (n = t(o)[0]), n) {
							var a = n.getBoundingClientRect();
							if (a.width || a.height) return [t(n)[i]().top + r, o]
						}
						return null
					}).filter(function (t) {
						return t
					}).sort(function (t, e) {
						return t[0] - e[0]
					}).forEach(function (t) {
						e._offsets.push(t[0]), e._targets.push(t[1])
					})
				}, o.prototype.dispose = function () {
					t.removeData(this._element, i), t(this._scrollElement).off(r), this._element = null, this._scrollElement = null, this._config = null, this._selector = null, this._offsets = null, this._targets = null, this._activeTarget = null, this._scrollHeight = null
				}, o.prototype._getConfig = function (n) {
					if (n = t.extend({}, s, n), "string" != typeof n.target) {
						var i = t(n.target).attr("id");
						i || (i = Util.getUID(e), t(n.target).attr("id", i)), n.target = "#" + i
					}
					return Util.typeCheckConfig(e, n, l), n
				}, o.prototype._getScrollTop = function () {
					return this._scrollElement === window ? this._scrollElement.pageYOffset : this._scrollElement.scrollTop
				}, o.prototype._getScrollHeight = function () {
					return this._scrollElement.scrollHeight || Math.max(document.body.scrollHeight, document.documentElement.scrollHeight)
				}, o.prototype._getOffsetHeight = function () {
					return this._scrollElement === window ? window.innerHeight : this._scrollElement.getBoundingClientRect().height
				}, o.prototype._process = function () {
					var t = this._getScrollTop() + this._config.offset,
						e = this._getScrollHeight(),
						n = this._config.offset + e - this._getOffsetHeight();
					if (this._scrollHeight !== e && this.refresh(), t >= n) {
						var i = this._targets[this._targets.length - 1];
						return void(this._activeTarget !== i && this._activate(i))
					}
					if (this._activeTarget && t < this._offsets[0] && this._offsets[0] > 0) return this._activeTarget = null, void this._clear();
					for (var r = this._offsets.length; r--;) {
						this._activeTarget !== this._targets[r] && t >= this._offsets[r] && (this._offsets[r + 1] === undefined || t < this._offsets[r + 1]) && this._activate(this._targets[r])
					}
				}, o.prototype._activate = function (e) {
					this._activeTarget = e, this._clear();
					var n = this._selector.split(",");
					n = n.map(function (t) {
						return t + '[data-target="' + e + '"],' + t + '[href="' + e + '"]'
					});
					var i = t(n.join(","));
					i.hasClass(c.DROPDOWN_ITEM) ? (i.closest(p.DROPDOWN).find(p.DROPDOWN_TOGGLE).addClass(c.ACTIVE), i.addClass(c.ACTIVE)) : (i.addClass(c.ACTIVE), i.parents(p.NAV_LIST_GROUP).prev(p.NAV_LINKS + ", " + p.LIST_ITEMS).addClass(c.ACTIVE)), t(this._scrollElement).trigger(u.ACTIVATE, {
						relatedTarget: e
					})
				}, o.prototype._clear = function () {
					t(this._selector).filter(p.ACTIVE).removeClass(c.ACTIVE)
				}, o._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this).data(i),
							r = "object" === (void 0 === e ? "undefined" : _typeof(e)) && e;
						if (n || (n = new o(this, r), t(this).data(i, n)), "string" == typeof e) {
							if (n[e] === undefined) throw new Error('No method named "' + e + '"');
							n[e]()
						}
					})
				}, _createClass(o, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return s
					}
				}]), o
			}();
		return t(window).on(u.LOAD_DATA_API, function () {
			for (var e = t.makeArray(t(p.DATA_SPY)), n = e.length; n--;) {
				var i = t(e[n]);
				f._jQueryInterface.call(i, i.data())
			}
		}), t.fn[e] = f._jQueryInterface, t.fn[e].Constructor = f, t.fn[e].noConflict = function () {
			return t.fn[e] = a, f._jQueryInterface
		}, f
	}(jQuery),
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Tab = function (t) {
		var e = "tab",
			n = "4.0.0-beta",
			i = "bs.tab",
			r = "." + i,
			o = ".data-api",
			a = t.fn[e],
			s = 150,
			l = {
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				CLICK_DATA_API: "click" + r + o
			},
			u = {
				DROPDOWN_MENU: "dropdown-menu",
				ACTIVE: "active",
				DISABLED: "disabled",
				FADE: "fade",
				SHOW: "show"
			},
			c = {
				DROPDOWN: ".dropdown",
				NAV_LIST_GROUP: ".nav, .list-group",
				ACTIVE: ".active",
				DATA_TOGGLE: '[data-toggle="tab"], [data-toggle="pill"], [data-toggle="list"]',
				DROPDOWN_TOGGLE: ".dropdown-toggle",
				DROPDOWN_ACTIVE_CHILD: "> .dropdown-menu .active"
			},
			p = function () {
				function e(t) {
					_classCallCheck(this, e), this._element = t
				}
				return e.prototype.show = function () {
					var e = this;
					if (!(this._element.parentNode && this._element.parentNode.nodeType === Node.ELEMENT_NODE && t(this._element).hasClass(u.ACTIVE) || t(this._element).hasClass(u.DISABLED))) {
						var n = void 0,
							i = void 0,
							r = t(this._element).closest(c.NAV_LIST_GROUP)[0],
							o = Util.getSelectorFromElement(this._element);
						r && (i = t.makeArray(t(r).find(c.ACTIVE)), i = i[i.length - 1]);
						var a = t.Event(l.HIDE, {
								relatedTarget: this._element
							}),
							s = t.Event(l.SHOW, {
								relatedTarget: i
							});
						if (i && t(i).trigger(a), t(this._element).trigger(s), !s.isDefaultPrevented() && !a.isDefaultPrevented()) {
							o && (n = t(o)[0]), this._activate(this._element, r);
							var p = function () {
								var n = t.Event(l.HIDDEN, {
										relatedTarget: e._element
									}),
									r = t.Event(l.SHOWN, {
										relatedTarget: i
									});
								t(i).trigger(n), t(e._element).trigger(r)
							};
							n ? this._activate(n, n.parentNode, p) : p()
						}
					}
				}, e.prototype.dispose = function () {
					t.removeData(this._element, i), this._element = null
				}, e.prototype._activate = function (e, n, i) {
					var r = this,
						o = t(n).find(c.ACTIVE)[0],
						a = i && Util.supportsTransitionEnd() && o && t(o).hasClass(u.FADE),
						l = function () {
							return r._transitionComplete(e, o, a, i)
						};
					o && a ? t(o).one(Util.TRANSITION_END, l).emulateTransitionEnd(s) : l(), o && t(o).removeClass(u.SHOW)
				}, e.prototype._transitionComplete = function (e, n, i, r) {
					if (n) {
						t(n).removeClass(u.ACTIVE);
						var o = t(n.parentNode).find(c.DROPDOWN_ACTIVE_CHILD)[0];
						o && t(o).removeClass(u.ACTIVE), n.setAttribute("aria-expanded", !1)
					}
					if (t(e).addClass(u.ACTIVE), e.setAttribute("aria-expanded", !0), i ? (Util.reflow(e), t(e).addClass(u.SHOW)) : t(e).removeClass(u.FADE), e.parentNode && t(e.parentNode).hasClass(u.DROPDOWN_MENU)) {
						var a = t(e).closest(c.DROPDOWN)[0];
						a && t(a).find(c.DROPDOWN_TOGGLE).addClass(u.ACTIVE), e.setAttribute("aria-expanded", !0)
					}
					r && r()
				}, e._jQueryInterface = function (n) {
					return this.each(function () {
						var r = t(this),
							o = r.data(i);
						if (o || (o = new e(this), r.data(i, o)), "string" == typeof n) {
							if (o[n] === undefined) throw new Error('No method named "' + n + '"');
							o[n]()
						}
					})
				}, _createClass(e, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}]), e
			}();
		return t(document).on(l.CLICK_DATA_API, c.DATA_TOGGLE, function (e) {
			e.preventDefault(), p._jQueryInterface.call(t(this), "show")
		}), t.fn[e] = p._jQueryInterface, t.fn[e].Constructor = p, t.fn[e].noConflict = function () {
			return t.fn[e] = a, p._jQueryInterface
		}, p
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Tooltip = function (t) {
		if ("undefined" == typeof Popper) throw new Error("Bootstrap tooltips require Popper.js (https://popper.js.org)");
		var e = "tooltip",
			n = "4.0.0-beta",
			i = "bs.tooltip",
			r = "." + i,
			o = t.fn[e],
			a = 150,
			s = "bs-tooltip",
			l = new RegExp("(^|\\s)" + s + "\\S+", "g"),
			u = {
				animation: "boolean",
				template: "string",
				title: "(string|element|function)",
				trigger: "string",
				delay: "(number|object)",
				html: "boolean",
				selector: "(string|boolean)",
				placement: "(string|function)",
				offset: "(number|string)",
				container: "(string|element|boolean)",
				fallbackPlacement: "(string|array)"
			},
			c = {
				AUTO: "auto",
				TOP: "top",
				RIGHT: "right",
				BOTTOM: "bottom",
				LEFT: "left"
			},
			p = {
				animation: !0,
				template: '<div class="tooltip" role="tooltip"><div class="arrow"></div><div class="tooltip-inner"></div></div>',
				trigger: "hover focus",
				title: "",
				delay: 0,
				html: !1,
				selector: !1,
				placement: "top",
				offset: 0,
				container: !1,
				fallbackPlacement: "flip"
			},
			d = {
				SHOW: "show",
				OUT: "out"
			},
			f = {
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				INSERTED: "inserted" + r,
				CLICK: "click" + r,
				FOCUSIN: "focusin" + r,
				FOCUSOUT: "focusout" + r,
				MOUSEENTER: "mouseenter" + r,
				MOUSELEAVE: "mouseleave" + r
			},
			h = {
				FADE: "fade",
				SHOW: "show"
			},
			m = {
				TOOLTIP: ".tooltip",
				TOOLTIP_INNER: ".tooltip-inner",
				ARROW: ".arrow"
			},
			g = {
				HOVER: "hover",
				FOCUS: "focus",
				CLICK: "click",
				MANUAL: "manual"
			},
			v = function () {
				function o(t, e) {
					_classCallCheck(this, o), this._isEnabled = !0, this._timeout = 0, this._hoverState = "", this._activeTrigger = {}, this._popper = null, this.element = t, this.config = this._getConfig(e), this.tip = null, this._setListeners()
				}
				return o.prototype.enable = function () {
					this._isEnabled = !0
				}, o.prototype.disable = function () {
					this._isEnabled = !1
				}, o.prototype.toggleEnabled = function () {
					this._isEnabled = !this._isEnabled
				}, o.prototype.toggle = function (e) {
					if (e) {
						var n = this.constructor.DATA_KEY,
							i = t(e.currentTarget).data(n);
						i || (i = new this.constructor(e.currentTarget, this._getDelegateConfig()), t(e.currentTarget).data(n, i)), i._activeTrigger.click = !i._activeTrigger.click, i._isWithActiveTrigger() ? i._enter(null, i) : i._leave(null, i)
					} else {
						if (t(this.getTipElement()).hasClass(h.SHOW)) return void this._leave(null, this);
						this._enter(null, this)
					}
				}, o.prototype.dispose = function () {
					clearTimeout(this._timeout), t.removeData(this.element, this.constructor.DATA_KEY), t(this.element).off(this.constructor.EVENT_KEY), t(this.element).closest(".modal").off("hide.bs.modal"), this.tip && t(this.tip).remove(), this._isEnabled = null, this._timeout = null, this._hoverState = null, this._activeTrigger = null, null !== this._popper && this._popper.destroy(), this._popper = null, this.element = null, this.config = null, this.tip = null
				}, o.prototype.show = function () {
					var e = this;
					if ("none" === t(this.element).css("display")) throw new Error("Please use show on visible elements");
					var n = t.Event(this.constructor.Event.SHOW);
					if (this.isWithContent() && this._isEnabled) {
						t(this.element).trigger(n);
						var i = t.contains(this.element.ownerDocument.documentElement, this.element);
						if (n.isDefaultPrevented() || !i) return;
						var r = this.getTipElement(),
							a = Util.getUID(this.constructor.NAME);
						r.setAttribute("id", a), this.element.setAttribute("aria-describedby", a), this.setContent(), this.config.animation && t(r).addClass(h.FADE);
						var s = "function" == typeof this.config.placement ? this.config.placement.call(this, r, this.element) : this.config.placement,
							l = this._getAttachment(s);
						this.addAttachmentClass(l);
						var u = !1 === this.config.container ? document.body : t(this.config.container);
						t(r).data(this.constructor.DATA_KEY, this), t.contains(this.element.ownerDocument.documentElement, this.tip) || t(r).appendTo(u), t(this.element).trigger(this.constructor.Event.INSERTED), this._popper = new Popper(this.element, r, {
							placement: l,
							modifiers: {
								offset: {
									offset: this.config.offset
								},
								flip: {
									behavior: this.config.fallbackPlacement
								},
								arrow: {
									element: m.ARROW
								}
							},
							onCreate: function (t) {
								t.originalPlacement !== t.placement && e._handlePopperPlacementChange(t)
							},
							onUpdate: function (t) {
								e._handlePopperPlacementChange(t)
							}
						}), t(r).addClass(h.SHOW), "ontouchstart" in document.documentElement && t("body").children().on("mouseover", null, t.noop);
						var c = function () {
							e.config.animation && e._fixTransition();
							var n = e._hoverState;
							e._hoverState = null, t(e.element).trigger(e.constructor.Event.SHOWN), n === d.OUT && e._leave(null, e)
						};
						Util.supportsTransitionEnd() && t(this.tip).hasClass(h.FADE) ? t(this.tip).one(Util.TRANSITION_END, c).emulateTransitionEnd(o._TRANSITION_DURATION) : c()
					}
				}, o.prototype.hide = function (e) {
					var n = this,
						i = this.getTipElement(),
						r = t.Event(this.constructor.Event.HIDE),
						o = function () {
							n._hoverState !== d.SHOW && i.parentNode && i.parentNode.removeChild(i), n._cleanTipClass(), n.element.removeAttribute("aria-describedby"), t(n.element).trigger(n.constructor.Event.HIDDEN), null !== n._popper && n._popper.destroy(), e && e()
						};
					t(this.element).trigger(r), r.isDefaultPrevented() || (t(i).removeClass(h.SHOW), "ontouchstart" in document.documentElement && t("body").children().off("mouseover", null, t.noop), this._activeTrigger[g.CLICK] = !1, this._activeTrigger[g.FOCUS] = !1, this._activeTrigger[g.HOVER] = !1, Util.supportsTransitionEnd() && t(this.tip).hasClass(h.FADE) ? t(i).one(Util.TRANSITION_END, o).emulateTransitionEnd(a) : o(), this._hoverState = "")
				}, o.prototype.update = function () {
					null !== this._popper && this._popper.scheduleUpdate()
				}, o.prototype.isWithContent = function () {
					return Boolean(this.getTitle())
				}, o.prototype.addAttachmentClass = function (e) {
					t(this.getTipElement()).addClass(s + "-" + e)
				}, o.prototype.getTipElement = function () {
					return this.tip = this.tip || t(this.config.template)[0]
				}, o.prototype.setContent = function () {
					var e = t(this.getTipElement());
					this.setElementContent(e.find(m.TOOLTIP_INNER), this.getTitle()), e.removeClass(h.FADE + " " + h.SHOW)
				}, o.prototype.setElementContent = function (e, n) {
					var i = this.config.html;
					"object" === (void 0 === n ? "undefined" : _typeof(n)) && (n.nodeType || n.jquery) ? i ? t(n).parent().is(e) || e.empty().append(n) : e.text(t(n).text()): e[i ? "html" : "text"](n)
				}, o.prototype.getTitle = function () {
					var t = this.element.getAttribute("data-original-title");
					return t || (t = "function" == typeof this.config.title ? this.config.title.call(this.element) : this.config.title), t
				}, o.prototype._getAttachment = function (t) {
					return c[t.toUpperCase()]
				}, o.prototype._setListeners = function () {
					var e = this;
					this.config.trigger.split(" ").forEach(function (n) {
						if ("click" === n) t(e.element).on(e.constructor.Event.CLICK, e.config.selector, function (t) {
							return e.toggle(t)
						});
						else if (n !== g.MANUAL) {
							var i = n === g.HOVER ? e.constructor.Event.MOUSEENTER : e.constructor.Event.FOCUSIN,
								r = n === g.HOVER ? e.constructor.Event.MOUSELEAVE : e.constructor.Event.FOCUSOUT;
							t(e.element).on(i, e.config.selector, function (t) {
								return e._enter(t)
							}).on(r, e.config.selector, function (t) {
								return e._leave(t)
							})
						}
						t(e.element).closest(".modal").on("hide.bs.modal", function () {
							return e.hide()
						})
					}), this.config.selector ? this.config = t.extend({}, this.config, {
						trigger: "manual",
						selector: ""
					}) : this._fixTitle()
				}, o.prototype._fixTitle = function () {
					var t = _typeof(this.element.getAttribute("data-original-title"));
					(this.element.getAttribute("title") || "string" !== t) && (this.element.setAttribute("data-original-title", this.element.getAttribute("title") || ""), this.element.setAttribute("title", ""))
				}, o.prototype._enter = function (e, n) {
					var i = this.constructor.DATA_KEY;
					return n = n || t(e.currentTarget).data(i), n || (n = new this.constructor(e.currentTarget, this._getDelegateConfig()), t(e.currentTarget).data(i, n)), e && (n._activeTrigger["focusin" === e.type ? g.FOCUS : g.HOVER] = !0), t(n.getTipElement()).hasClass(h.SHOW) || n._hoverState === d.SHOW ? void(n._hoverState = d.SHOW) : (clearTimeout(n._timeout), n._hoverState = d.SHOW, n.config.delay && n.config.delay.show ? void(n._timeout = setTimeout(function () {
						n._hoverState === d.SHOW && n.show()
					}, n.config.delay.show)) : void n.show())
				}, o.prototype._leave = function (e, n) {
					var i = this.constructor.DATA_KEY;
					if (n = n || t(e.currentTarget).data(i), n || (n = new this.constructor(e.currentTarget, this._getDelegateConfig()), t(e.currentTarget).data(i, n)), e && (n._activeTrigger["focusout" === e.type ? g.FOCUS : g.HOVER] = !1), !n._isWithActiveTrigger()) {
						if (clearTimeout(n._timeout), n._hoverState = d.OUT, !n.config.delay || !n.config.delay.hide) return void n.hide();
						n._timeout = setTimeout(function () {
							n._hoverState === d.OUT && n.hide()
						}, n.config.delay.hide)
					}
				}, o.prototype._isWithActiveTrigger = function () {
					for (var t in this._activeTrigger)
						if (this._activeTrigger[t]) return !0;
					return !1
				}, o.prototype._getConfig = function (n) {
					return n = t.extend({}, this.constructor.Default, t(this.element).data(), n), n.delay && "number" == typeof n.delay && (n.delay = {
						show: n.delay,
						hide: n.delay
					}), n.title && "number" == typeof n.title && (n.title = n.title.toString()), n.content && "number" == typeof n.content && (n.content = n.content.toString()), Util.typeCheckConfig(e, n, this.constructor.DefaultType), n
				}, o.prototype._getDelegateConfig = function () {
					var t = {};
					if (this.config)
						for (var e in this.config) this.constructor.Default[e] !== this.config[e] && (t[e] = this.config[e]);
					return t
				}, o.prototype._cleanTipClass = function () {
					var e = t(this.getTipElement()),
						n = e.attr("class").match(l);
					null !== n && n.length > 0 && e.removeClass(n.join(""))
				}, o.prototype._handlePopperPlacementChange = function (t) {
					this._cleanTipClass(), this.addAttachmentClass(this._getAttachment(t.placement))
				}, o.prototype._fixTransition = function () {
					var e = this.getTipElement(),
						n = this.config.animation;
					null === e.getAttribute("x-placement") && (t(e).removeClass(h.FADE), this.config.animation = !1, this.hide(), this.show(), this.config.animation = n)
				}, o._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this).data(i),
							r = "object" === (void 0 === e ? "undefined" : _typeof(e)) && e;
						if ((n || !/dispose|hide/.test(e)) && (n || (n = new o(this, r), t(this).data(i, n)), "string" == typeof e)) {
							if (n[e] === undefined) throw new Error('No method named "' + e + '"');
							n[e]()
						}
					})
				}, _createClass(o, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return p
					}
				}, {
					key: "NAME",
					get: function () {
						return e
					}
				}, {
					key: "DATA_KEY",
					get: function () {
						return i
					}
				}, {
					key: "Event",
					get: function () {
						return f
					}
				}, {
					key: "EVENT_KEY",
					get: function () {
						return r
					}
				}, {
					key: "DefaultType",
					get: function () {
						return u
					}
				}]), o
			}();
		return t.fn[e] = v._jQueryInterface, t.fn[e].Constructor = v, t.fn[e].noConflict = function () {
			return t.fn[e] = o, v._jQueryInterface
		}, v
	}(jQuery),
	_typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
		return typeof t
	} : function (t) {
		return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
	},
	_createClass = function () {
		function t(t, e) {
			for (var n = 0; n < e.length; n++) {
				var i = e[n];
				i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(t, i.key, i)
			}
		}
		return function (e, n, i) {
			return n && t(e.prototype, n), i && t(e, i), e
		}
	}(),
	Popover = function (t) {
		var e = "popover",
			n = "4.0.0-beta",
			i = "bs.popover",
			r = "." + i,
			o = t.fn[e],
			a = "bs-popover",
			s = new RegExp("(^|\\s)" + a + "\\S+", "g"),
			l = t.extend({}, Tooltip.Default, {
				placement: "right",
				trigger: "click",
				content: "",
				template: '<div class="popover" role="tooltip"><div class="arrow"></div><h3 class="popover-header"></h3><div class="popover-body"></div></div>'
			}),
			u = t.extend({}, Tooltip.DefaultType, {
				content: "(string|element|function)"
			}),
			c = {
				FADE: "fade",
				SHOW: "show"
			},
			p = {
				TITLE: ".popover-header",
				CONTENT: ".popover-body"
			},
			d = {
				HIDE: "hide" + r,
				HIDDEN: "hidden" + r,
				SHOW: "show" + r,
				SHOWN: "shown" + r,
				INSERTED: "inserted" + r,
				CLICK: "click" + r,
				FOCUSIN: "focusin" + r,
				FOCUSOUT: "focusout" + r,
				MOUSEENTER: "mouseenter" + r,
				MOUSELEAVE: "mouseleave" + r
			},
			f = function (o) {
				function f() {
					return _classCallCheck(this, f), _possibleConstructorReturn(this, o.apply(this, arguments))
				}
				return _inherits(f, o), f.prototype.isWithContent = function () {
					return this.getTitle() || this._getContent()
				}, f.prototype.addAttachmentClass = function (e) {
					t(this.getTipElement()).addClass(a + "-" + e)
				}, f.prototype.getTipElement = function () {
					return this.tip = this.tip || t(this.config.template)[0]
				}, f.prototype.setContent = function () {
					var e = t(this.getTipElement());
					this.setElementContent(e.find(p.TITLE), this.getTitle()), this.setElementContent(e.find(p.CONTENT), this._getContent()), e.removeClass(c.FADE + " " + c.SHOW)
				}, f.prototype._getContent = function () {
					return this.element.getAttribute("data-content") || ("function" == typeof this.config.content ? this.config.content.call(this.element) : this.config.content)
				}, f.prototype._cleanTipClass = function () {
					var e = t(this.getTipElement()),
						n = e.attr("class").match(s);
					null !== n && n.length > 0 && e.removeClass(n.join(""))
				}, f._jQueryInterface = function (e) {
					return this.each(function () {
						var n = t(this).data(i),
							r = "object" === (void 0 === e ? "undefined" : _typeof(e)) ? e : null;
						if ((n || !/destroy|hide/.test(e)) && (n || (n = new f(this, r), t(this).data(i, n)), "string" == typeof e)) {
							if (n[e] === undefined) throw new Error('No method named "' + e + '"');
							n[e]()
						}
					})
				}, _createClass(f, null, [{
					key: "VERSION",
					get: function () {
						return n
					}
				}, {
					key: "Default",
					get: function () {
						return l
					}
				}, {
					key: "NAME",
					get: function () {
						return e
					}
				}, {
					key: "DATA_KEY",
					get: function () {
						return i
					}
				}, {
					key: "Event",
					get: function () {
						return d
					}
				}, {
					key: "EVENT_KEY",
					get: function () {
						return r
					}
				}, {
					key: "DefaultType",
					get: function () {
						return u
					}
				}]), f
			}(Tooltip);
		return t.fn[e] = f._jQueryInterface, t.fn[e].Constructor = f, t.fn[e].noConflict = function () {
			return t.fn[e] = o, f._jQueryInterface
		}, f
	}(jQuery);
(function () {
	$(document).on("click", ".clear_fields", function () {
		$(".readonly").empty(), $("input.readonly:text").val(""), $(".users_form").hide(), $(".readonly").prop("readonly", !1)
	})
}).call(this),
	function () {
		$(document).on("click", ".load_details", function () {
			var t;
			t = $("#application_form_application_enterprise_attributes_acc_no").val(), $(".users_form").show(), jQuery.post("/admin/application_forms/load_account_details", {
				acc_no: t
			})
		}), $(document).on("blur", "#application_form_application_enterprise_attributes_pref_corp", function () {
			var t, e, n;
			n = $(this), t = $("#application_form_application_enterprise_attributes_id").val(), e = n.parent().find("div"), console.log(e), n.val().length > 2 && $.ajax("/admin/application_forms/validate_pref_corp", {
				type: "POST",
				dataType: "json",
				data: {
					pref_corp: n.val(),
					enterprise_id: t
				},
				error: function () {
					return console.log("...")
				},
				success: function (t) {
					var i, r;
					return t.error && "402" === t.error.code ? (r = t.error.message, i = document.createElement("label"), i.setAttribute("id", n.attr("id") + "-error"), i.className = "error", i.innerHTML = r, n.parent().append(i), n[0].setCustomValidity(r)) : (i = $("#" + n.attr("id") + "-error"), i.remove(), n[0].setCustomValidity(""), e.hide())
				}
			})
		})
	}.call(this),
	function () {
		$(document).on("click", ".close-icon", function () {
			var t, e, n, i;
			return n = $(this).closest(".user-form"), i = n.find("#application_form_application_enterprise_attributes_application_users_attributes__id").val(), /^\s*$/.test(i) || (t = $("#application_form_application_enterprise_attributes_id").val()), e = $(".user-form").length, window.originalLength = $(".user-form").length, 2 === e ? ($(".remove").hide(), void n.slideUp(function () {
				var t;
				return $(this).remove(), t = $(".user-form").length, $(".user_auth").prop("max", t - 1), $("#singleOrMultipleOptions").prop("readonly", !0), $("#singleOrMultipleOptions").empty().append('<option selected="selected" value="Single">Single</options)'), $("#disableRulesForAccountOperation1").prop("readonly", !0), $("#disableRulesForAccountOperation1").val("0"), $("#disableRulesForAccountOperation2").prop("readonly", !0), $("#disableRulesForAccountOperation2").val("0"), $("#disableRulesForAccountOperation3").prop("readonly", !0),$("#disableRulesForAccountOperation1").prop("min", 0),$("#disableRulesForAccountOperation2").prop("min", 0),$("#disableRulesForAccountOperation3").prop("min", 0), $("#disableRulesForAccountOperation3").val("0")
			})) : n.slideUp(function () {
				var t;
				$(this).remove(), t = $(".user-form").length, $(".user_auth").prop("max", t - 1), $("#singleOrMultipleOptions").prop("readonly") && $("#singleOrMultipleOptions").empty().append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>'), $("#singleOrMultipleOptions").prop("readonly", !1), $("#disableRulesForAccountOperation1").prop("readonly", !1), $("#disableRulesForAccountOperation2").prop("readonly", !1), $("#disableRulesForAccountOperation3").prop("readonly", !1)
			})
		}), $(document).on("click", ".auto_load_users", function () {
			var t, e;
			t = $("#application_form_application_enterprise_attributes_acc_no").val(), e = $(".related_parties").find("[id$=_cust_no]").map(function () {
				return $(this).val()
			}).get(), jQuery.post("/admin/application_users/user_auto_load", {
				acc_no: t,
				existing_users: e
			})
		})
	}.call(this),
	function () {
		(function () {
			(function () {
				var e = [].slice;
				this.ActionCable = {
					INTERNAL: {
						message_types: {
							welcome: "welcome",
							ping: "ping",
							confirmation: "confirm_subscription",
							rejection: "reject_subscription"
						},
						default_mount_path: "/cable",
						protocols: ["actioncable-v1-json", "actioncable-unsupported"]
					},
					createConsumer: function (e) {
						var n;
						return null == e && (e = null != (n = this.getConfig("url")) ? n : this.INTERNAL.default_mount_path), new t.Consumer(this.createWebSocketURL(e))
					},
					getConfig: function (t) {
						var e;
						return e = document.head.querySelector("meta[name='action-cable-" + t + "']"), null != e ? e.getAttribute("content") : void 0
					},
					createWebSocketURL: function (t) {
						var e;
						return t && !/^wss?:/i.test(t) ? (e = document.createElement("a"), e.href = t, e.href = e.href, e.protocol = e.protocol.replace("http", "ws"), e.href) : t
					},
					startDebugging: function () {
						return this.debugging = !0
					},
					stopDebugging: function () {
						return this.debugging = null
					},
					log: function () {
						var t;
						if (t = 1 <= arguments.length ? e.call(arguments, 0) : [], this.debugging) return t.push(Date.now()), console.log.apply(console, ["[ActionCable]"].concat(e.call(t)))
					}
				}
			}).call(this)
		}).call(this);
		var t = this.ActionCable;
		(function () {
			(function () {
				var e = function (t, e) {
					return function () {
						return t.apply(e, arguments)
					}
				};
				t.ConnectionMonitor = function () {
					function n(t) {
						this.connection = t, this.visibilityDidChange = e(this.visibilityDidChange, this), this.reconnectAttempts = 0
					}
					var i, r, o;
					return n.pollInterval = {
						min: 3,
						max: 30
					}, n.staleThreshold = 6, n.prototype.start = function () {
						if (!this.isRunning()) return this.startedAt = r(), delete this.stoppedAt, this.startPolling(), document.addEventListener("visibilitychange", this.visibilityDidChange), t.log("ConnectionMonitor started. pollInterval = " + this.getPollInterval() + " ms")
					}, n.prototype.stop = function () {
						if (this.isRunning()) return this.stoppedAt = r(), this.stopPolling(), document.removeEventListener("visibilitychange", this.visibilityDidChange), t.log("ConnectionMonitor stopped")
					}, n.prototype.isRunning = function () {
						return null != this.startedAt && null == this.stoppedAt
					}, n.prototype.recordPing = function () {
						return this.pingedAt = r()
					}, n.prototype.recordConnect = function () {
						return this.reconnectAttempts = 0, this.recordPing(), delete this.disconnectedAt, t.log("ConnectionMonitor recorded connect")
					}, n.prototype.recordDisconnect = function () {
						return this.disconnectedAt = r(), t.log("ConnectionMonitor recorded disconnect")
					}, n.prototype.startPolling = function () {
						return this.stopPolling(), this.poll()
					}, n.prototype.stopPolling = function () {
						return clearTimeout(this.pollTimeout)
					}, n.prototype.poll = function () {
						return this.pollTimeout = setTimeout(function (t) {
							return function () {
								return t.reconnectIfStale(), t.poll()
							}
						}(this), this.getPollInterval())
					}, n.prototype.getPollInterval = function () {
						var t, e, n, r;
						return r = this.constructor.pollInterval, n = r.min, e = r.max, t = 5 * Math.log(this.reconnectAttempts + 1), Math.round(1e3 * i(t, n, e))
					}, n.prototype.reconnectIfStale = function () {
						if (this.connectionIsStale()) return t.log("ConnectionMonitor detected stale connection. reconnectAttempts = " + this.reconnectAttempts + ", pollInterval = " + this.getPollInterval() + " ms, time disconnected = " + o(this.disconnectedAt) + " s, stale threshold = " + this.constructor.staleThreshold + " s"), this.reconnectAttempts++, this.disconnectedRecently() ? t.log("ConnectionMonitor skipping reopening recent disconnect") : (t.log("ConnectionMonitor reopening"), this.connection.reopen())
					}, n.prototype.connectionIsStale = function () {
						var t;
						return o(null != (t = this.pingedAt) ? t : this.startedAt) > this.constructor.staleThreshold
					}, n.prototype.disconnectedRecently = function () {
						return this.disconnectedAt && o(this.disconnectedAt) < this.constructor.staleThreshold
					}, n.prototype.visibilityDidChange = function () {
						if ("visible" === document.visibilityState) return setTimeout(function (e) {
							return function () {
								if (e.connectionIsStale() || !e.connection.isOpen()) return t.log("ConnectionMonitor reopening stale connection on visibilitychange. visbilityState = " + document.visibilityState), e.connection.reopen()
							}
						}(this), 200)
					}, r = function () {
						return (new Date).getTime()
					}, o = function (t) {
						return (r() - t) / 1e3
					}, i = function (t, e, n) {
						return Math.max(e, Math.min(n, t))
					}, n
				}()
			}).call(this),
				function () {
					var e, n, i, r, o, a = [].slice,
						s = function (t, e) {
							return function () {
								return t.apply(e, arguments)
							}
						},
						l = [].indexOf || function (t) {
							for (var e = 0, n = this.length; e < n; e++)
								if (e in this && this[e] === t) return e;
							return -1
						};
					r = t.INTERNAL, n = r.message_types, i = r.protocols, o = 2 <= i.length ? a.call(i, 0, e = i.length - 1) : (e = 0, []), i[e++], t.Connection = function () {
						function e(e) {
							this.consumer = e, this.open = s(this.open, this), this.subscriptions = this.consumer.subscriptions, this.monitor = new t.ConnectionMonitor(this), this.disconnected = !0
						}
						return e.reopenDelay = 500, e.prototype.send = function (t) {
							return !!this.isOpen() && (this.webSocket.send(JSON.stringify(t)), !0)
						}, e.prototype.open = function () {
							if (this.isActive()) throw t.log("Attempted to open WebSocket, but existing socket is " + this.getState()), new Error("Existing connection must be closed before opening");
							return t.log("Opening WebSocket, current state is " + this.getState() + ", subprotocols: " + i), null != this.webSocket && this.uninstallEventHandlers(), this.webSocket = new WebSocket(this.consumer.url, i), this.installEventHandlers(), this.monitor.start(), !0
						}, e.prototype.close = function (t) {
							var e, n;
							if (e = (null != t ? t : {
									allowReconnect: !0
								}).allowReconnect, e || this.monitor.stop(), this.isActive()) return null != (n = this.webSocket) ? n.close() : void 0
						}, e.prototype.reopen = function () {
							var e;
							if (t.log("Reopening WebSocket, current state is " + this.getState()), !this.isActive()) return this.open();
							try {
								return this.close()
							} catch (n) {
								return e = n, t.log("Failed to reopen WebSocket", e)
							} finally {
								t.log("Reopening WebSocket in " + this.constructor.reopenDelay + "ms"), setTimeout(this.open, this.constructor.reopenDelay)
							}
						}, e.prototype.getProtocol = function () {
							var t;
							return null != (t = this.webSocket) ? t.protocol : void 0
						}, e.prototype.isOpen = function () {
							return this.isState("open")
						}, e.prototype.isActive = function () {
							return this.isState("open", "connecting")
						}, e.prototype.isProtocolSupported = function () {
							var t;
							return t = this.getProtocol(), l.call(o, t) >= 0
						}, e.prototype.isState = function () {
							var t, e;
							return e = 1 <= arguments.length ? a.call(arguments, 0) : [], t = this.getState(), l.call(e, t) >= 0
						}, e.prototype.getState = function () {
							var t, e;
							for (e in WebSocket)
								if (WebSocket[e] === (null != (t = this.webSocket) ? t.readyState : void 0)) return e.toLowerCase();
							return null
						}, e.prototype.installEventHandlers = function () {
							var t, e;
							for (t in this.events) e = this.events[t].bind(this), this.webSocket["on" + t] = e
						}, e.prototype.uninstallEventHandlers = function () {
							var t;
							for (t in this.events) this.webSocket["on" + t] = function () {}
						}, e.prototype.events = {
							message: function (t) {
								var e, i, r, o;
								if (this.isProtocolSupported()) switch (r = JSON.parse(t.data), e = r.identifier, i = r.message, o = r.type, o) {
									case n.welcome:
										return this.monitor.recordConnect(), this.subscriptions.reload();
									case n.ping:
										return this.monitor.recordPing();
									case n.confirmation:
										return this.subscriptions.notify(e, "connected");
									case n.rejection:
										return this.subscriptions.reject(e);
									default:
										return this.subscriptions.notify(e, "received", i)
								}
							},
							open: function () {
								if (t.log("WebSocket onopen event, using '" + this.getProtocol() + "' subprotocol"), this.disconnected = !1, !this.isProtocolSupported()) return t.log("Protocol is unsupported. Stopping monitor and disconnecting."), this.close({
									allowReconnect: !1
								})
							},
							close: function () {
								if (t.log("WebSocket onclose event"), !this.disconnected) return this.disconnected = !0, this.monitor.recordDisconnect(), this.subscriptions.notifyAll("disconnected", {
									willAttemptReconnect: this.monitor.isRunning()
								})
							},
							error: function () {
								return t.log("WebSocket onerror event")
							}
						}, e
					}()
				}.call(this),
				function () {
					var e = [].slice;
					t.Subscriptions = function () {
						function n(t) {
							this.consumer = t, this.subscriptions = []
						}
						return n.prototype.create = function (e, n) {
							var i, r, o;
							return i = e, r = "object" == typeof i ? i : {
								channel: i
							}, o = new t.Subscription(this.consumer, r, n), this.add(o)
						}, n.prototype.add = function (t) {
							return this.subscriptions.push(t), this.consumer.ensureActiveConnection(), this.notify(t, "initialized"), this.sendCommand(t, "subscribe"), t
						}, n.prototype.remove = function (t) {
							return this.forget(t), this.findAll(t.identifier).length || this.sendCommand(t, "unsubscribe"), t
						}, n.prototype.reject = function (t) {
							var e, n, i, r, o;
							for (i = this.findAll(t), r = [], e = 0, n = i.length; e < n; e++) o = i[e], this.forget(o), this.notify(o, "rejected"), r.push(o);
							return r
						}, n.prototype.forget = function (t) {
							var e;
							return this.subscriptions = function () {
								var n, i, r, o;
								for (r = this.subscriptions, o = [], n = 0, i = r.length; n < i; n++)(e = r[n]) !== t && o.push(e);
								return o
							}.call(this), t
						}, n.prototype.findAll = function (t) {
							var e, n, i, r, o;
							for (i = this.subscriptions, r = [], e = 0, n = i.length; e < n; e++) o = i[e], o.identifier === t && r.push(o);
							return r
						}, n.prototype.reload = function () {
							var t, e, n, i, r;
							for (n = this.subscriptions, i = [], t = 0, e = n.length; t < e; t++) r = n[t], i.push(this.sendCommand(r, "subscribe"));
							return i
						}, n.prototype.notifyAll = function () {
							var t, n, i, r, o, a, s;
							for (n = arguments[0], t = 2 <= arguments.length ? e.call(arguments, 1) : [], o = this.subscriptions, a = [], i = 0, r = o.length; i < r; i++) s = o[i], a.push(this.notify.apply(this, [s, n].concat(e.call(t))));
							return a
						}, n.prototype.notify = function () {
							var t, n, i, r, o, a, s;
							for (a = arguments[0], n = arguments[1], t = 3 <= arguments.length ? e.call(arguments, 2) : [], s = "string" == typeof a ? this.findAll(a) : [a], o = [], i = 0, r = s.length; i < r; i++) a = s[i],
								o.push("function" == typeof a[n] ? a[n].apply(a, t) : void 0);
							return o
						}, n.prototype.sendCommand = function (t, e) {
							var n;
							return n = t.identifier, this.consumer.send({
								command: e,
								identifier: n
							})
						}, n
					}()
				}.call(this),
				function () {
					t.Subscription = function () {
						function t(t, n, i) {
							this.consumer = t, null == n && (n = {}), this.identifier = JSON.stringify(n), e(this, i)
						}
						var e;
						return t.prototype.perform = function (t, e) {
							return null == e && (e = {}), e.action = t, this.send(e)
						}, t.prototype.send = function (t) {
							return this.consumer.send({
								command: "message",
								identifier: this.identifier,
								data: JSON.stringify(t)
							})
						}, t.prototype.unsubscribe = function () {
							return this.consumer.subscriptions.remove(this)
						}, e = function (t, e) {
							var n, i;
							if (null != e)
								for (n in e) i = e[n], t[n] = i;
							return t
						}, t
					}()
				}.call(this),
				function () {
					t.Consumer = function () {
						function e(e) {
							this.url = e, this.subscriptions = new t.Subscriptions(this), this.connection = new t.Connection(this)
						}
						return e.prototype.send = function (t) {
							return this.connection.send(t)
						}, e.prototype.connect = function () {
							return this.connection.open()
						}, e.prototype.disconnect = function () {
							return this.connection.close({
								allowReconnect: !1
							})
						}, e.prototype.ensureActiveConnection = function () {
							if (!this.connection.isActive()) return this.connection.open()
						}, e
					}()
				}.call(this)
		}).call(this), "object" == typeof module && module.exports ? module.exports = t : "function" == typeof define && define.amd && define(t)
	}.call(this),
	function () {
		this.App || (this.App = {}), App.cable = ActionCable.createConsumer()
	}.call(this),
	function () {}.call(this),
	function (t) {
		function e(i) {
			if (n[i]) return n[i].exports;
			var r = n[i] = {
				i: i,
				l: !1,
				exports: {}
			};
			return t[i].call(r.exports, r, r.exports, e), r.l = !0, r.exports
		}
		var n = {};
		e.m = t, e.c = n, e.d = function (t, n, i) {
			e.o(t, n) || Object.defineProperty(t, n, {
				configurable: !1,
				enumerable: !0,
				get: i
			})
		}, e.n = function (t) {
			var n = t && t.__esModule ? function () {
				return t["default"]
			} : function () {
				return t
			};
			return e.d(n, "a", n), n
		}, e.o = function (t, e) {
			return Object.prototype.hasOwnProperty.call(t, e)
		}, e.p = "", e(e.s = 3)
	}([function (t, e, n) {
		"use strict";
		var i, r, o, a;
		"function" == typeof Symbol && Symbol.iterator, a = function (t) {
			return t
		}, r = [n(2)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a, s = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
			return typeof t
		} : function (t) {
			return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
		};
		a = function (t, e, n, i) {
			function r(e, n, a) {
				if (!(this instanceof r)) return new r(e, n, a);
				this.el = i, this.events = {}, this.maskset = i, this.refreshValue = !1, !0 !== a && (t.isPlainObject(e) ? n = e : (n = n || {}, e && (n.alias = e)), this.opts = t.extend(!0, {}, this.defaults, n), this.noMasksCache = n && n.definitions !== i, this.userOptions = n || {}, this.isRTL = this.opts.numericInput, o(this.opts.alias, n, this.opts))
			}

			function o(e, n, a) {
				var s = r.prototype.aliases[e];
				return s ? (s.alias && o(s.alias, i, a), t.extend(!0, a, s), t.extend(!0, a, n), !0) : (null === a.mask && (a.mask = e), !1)
			}

			function a(e, n) {
				function o(e, o, a) {
					var s = !1;
					if (null !== e && "" !== e || ((s = null !== a.regex) ? e = (e = a.regex).replace(/^(\^)(.*)(\$)$/, "$2") : (s = !0, e = ".*")), 1 === e.length && !1 === a.greedy && 0 !== a.repeat && (a.placeholder = ""), a.repeat > 0 || "*" === a.repeat || "+" === a.repeat) {
						var l = "*" === a.repeat ? 0 : "+" === a.repeat ? 1 : a.repeat;
						e = a.groupmarker[0] + e + a.groupmarker[1] + a.quantifiermarker[0] + l + "," + a.repeat + a.quantifiermarker[1]
					}
					var u, c = s ? "regex_" + a.regex : a.numericInput ? e.split("").reverse().join("") : e;
					return r.prototype.masksCache[c] === i || !0 === n ? (u = {
						mask: e,
						maskToken: r.prototype.analyseMask(e, s, a),
						validPositions: {},
						_buffer: i,
						buffer: i,
						tests: {},
						excludes: {},
						metadata: o,
						maskLength: i
					}, !0 !== n && (r.prototype.masksCache[c] = u, u = t.extend(!0, {}, r.prototype.masksCache[c]))) : u = t.extend(!0, {}, r.prototype.masksCache[c]), u
				}
				if (t.isFunction(e.mask) && (e.mask = e.mask(e)), t.isArray(e.mask)) {
					if (e.mask.length > 1) {
						if (null === e.keepStatic) {
							e.keepStatic = "auto";
							for (var a = 0; a < e.mask.length; a++)
								if (e.mask[a].charAt(0) !== e.mask[0].charAt(0)) {
									e.keepStatic = !0;
									break
								}
						}
						var s = e.groupmarker[0];
						return t.each(e.isRTL ? e.mask.reverse() : e.mask, function (n, r) {
							s.length > 1 && (s += e.groupmarker[1] + e.alternatormarker + e.groupmarker[0]), r.mask === i || t.isFunction(r.mask) ? s += r : s += r.mask
						}), o(s += e.groupmarker[1], e.mask, e)
					}
					e.mask = e.mask.pop()
				}
				return e.mask && e.mask.mask !== i && !t.isFunction(e.mask.mask) ? o(e.mask.mask, e.mask, e) : o(e.mask, e.mask, e)
			}

			function l(t) {
				var e = n.createElement("input"),
					i = "on" + t,
					r = i in e;
				return r || (e.setAttribute(i, "return;"), r = "function" == typeof e[i]), e = null, r
			}

			function u(o, a, c) {
				function h(t, e, n, r) {
					e = e || 0;
					var o, a, s, l = [],
						u = 0,
						p = v();
					do {
						if (!0 === t && m().validPositions[u]) a = (s = m().validPositions[u]).match, o = s.locator.slice(), l.push(!0 === n ? s.input : !1 === n ? a.nativeDef : j(u, a));
						else {
							a = (s = E(u, o, u - 1)).match, o = s.locator.slice();
							var d = !0 !== r && (!1 !== c.jitMasking ? c.jitMasking : a.jit);
							(!1 === d || d === i || u < p || "number" == typeof d && isFinite(d) && d > u) && l.push(!1 === n ? a.nativeDef : j(u, a))
						}
						"auto" === c.keepStatic && a.newBlockMarker && null !== a.fn && (c.keepStatic = u - 1), u++
					} while ((Y === i || u < Y) && (null !== a.fn || "" !== a.def) || e > u);
					return "" === l[l.length - 1] && l.pop(), !1 === n && m().maskLength !== i || (m().maskLength = u - 1), l
				}

				function m() {
					return a
				}

				function g(t) {
					var e = m();
					e.buffer = i, !0 !== t && (e.validPositions = {}, e.p = 0)
				}

				function v(t, e, n) {
					var r = -1,
						o = -1,
						a = n || m().validPositions;
					for (var s in t === i && (t = -1), a) {
						var l = parseInt(s);
						a[l] && (e || !0 !== a[l].generatedInput) && (l <= t && (r = l), l >= t && (o = l))
					}
					return -1 === r || r == t ? o : -1 == o ? r : t - r < o - t ? r : o
				}

				function y(t, e, n) {
					for (var r, o = k(t = t > 0 ? t - 1 : 0, e), a = o.alternation !== i ? o.locator[o.alternation].toString().split(",") : [], s = 0; s < e.length && (!((r = e[s]).match && (c.greedy && !0 !== r.match.optionalQuantifier || (!1 === r.match.optionality || !1 === r.match.newBlockMarker) && !0 !== r.match.optionalQuantifier) && (o.alternation === i || o.alternation !== r.alternation || r.locator[o.alternation] !== i && A(r.locator[o.alternation].toString().split(","), a))) || !0 === n && (null !== r.match.fn || /[0-9a-bA-Z]/.test(r.match.def))); s++);
					return r
				}

				function b(t) {
					var e = t.locator[t.alternation];
					return "string" == typeof e && e.length > 0 && (e = e.split(",")[0]), e !== i ? e.toString() : ""
				}

				function _(t, e) {
					for (var n = (t.alternation != i ? t.mloc[b(t)] : t.locator).join(""); n.length < e;) n += "0";
					return n
				}

				function E(t, e, n) {
					return m().validPositions[t] || y(t, C(t, e ? e.slice() : e, n))
				}

				function k(t, e) {
					return m().validPositions[t] ? m().validPositions[t] : (e || C(t))[0]
				}

				function w(t, e) {
					for (var n = !1, i = C(t), r = 0; r < i.length; r++)
						if (i[r].match && i[r].match.def === e) {
							n = !0;
							break
						}
					return n
				}

				function C(e, n, r) {
					function o(n, r, s, u) {
						function h(s, u, g) {
							function v(e, n) {
								var i = 0 === t.inArray(e, n.matches);
								return i || t.each(n.matches, function (t, r) {
									if (!0 === r.isQuantifier ? i = v(e, n.matches[t - 1]) : !0 === r.isOptional ? i = v(e, r) : !0 === r.isAlternate && (i = v(e, r)), i) return !1
								}), i
							}

							function y(e, n, r) {
								var o, a;
								if ((m().tests[e] || m().validPositions[e]) && t.each(m().tests[e] || [m().validPositions[e]], function (t, e) {
										if (e.mloc[n]) return o = e, !1;
										var s = r !== i ? r : e.alternation,
											l = e.locator[s] !== i ? e.locator[s].toString().indexOf(n) : -1;
										(a === i || l < a) && -1 !== l && (o = e, a = l)
									}), o) {
									var s = o.locator[o.alternation];
									return (o.mloc[n] || o.mloc[s] || o.locator).slice((r !== i ? r : o.alternation) + 1)
								}
								return r !== i ? y(e, n) : i
							}

							function b(t, e) {
								function n(t) {
									for (var e, n, i = [], r = 0, o = t.length; r < o; r++)
										if ("-" === t.charAt(r))
											for (n = t.charCodeAt(r + 1); ++e < n;) i.push(String.fromCharCode(e));
										else e = t.charCodeAt(r), i.push(t.charAt(r));
									return i.join("")
								}
								return c.regex && null !== t.match.fn && null !== e.match.fn ? -1 !== n(e.match.def.replace(/[\[\]]/g, "")).indexOf(n(t.match.def.replace(/[\[\]]/g, ""))) : t.match.def === e.match.nativeDef
							}

							function _(t, e) {
								if (e === i || t.alternation === e.alternation && -1 === t.locator[t.alternation].toString().indexOf(e.locator[e.alternation])) {
									t.mloc = t.mloc || {};
									var n = t.locator[t.alternation];
									if (n !== i) {
										if ("string" == typeof n && (n = n.split(",")[0]), t.mloc[n] === i && (t.mloc[n] = t.locator.slice()), e !== i) {
											for (var r in e.mloc) "string" == typeof r && (r = r.split(",")[0]), t.mloc[r] === i && (t.mloc[r] = e.mloc[r]);
											t.locator[t.alternation] = Object.keys(t.mloc).join(",")
										}
										return !0
									}
									t.alternation = i
								}
								return !1
							}
							if (l > 5e3) throw "Inputmask: There is probably an error in your mask definition or in the code. Create an issue on github with an example of the mask you are using. " + m().mask;
							if (l === e && s.matches === i) return p.push({
								match: s,
								locator: u.reverse(),
								cd: f,
								mloc: {}
							}), !0;
							if (s.matches !== i) {
								if (s.isGroup && g !== s) {
									if (s = h(n.matches[t.inArray(s, n.matches) + 1], u)) return !0
								} else if (s.isOptional) {
									var E = s;
									if (s = o(s, r, u, g)) {
										if (a = p[p.length - 1].match, g !== i || !v(a, E)) return !0;
										d = !0, l = e
									}
								} else if (s.isAlternator) {
									var k, w = s,
										C = [],
										x = p.slice(),
										S = u.length,
										T = r.length > 0 ? r.shift() : -1;
									if (-1 === T || "string" == typeof T) {
										var A, D = l,
											O = r.slice(),
											N = [];
										if ("string" == typeof T) N = T.split(",");
										else
											for (A = 0; A < w.matches.length; A++) N.push(A.toString());
										if (m().excludes[e]) {
											for (var I = N.slice(), P = 0, L = m().excludes[e].length; P < L; P++) N.splice(N.indexOf(m().excludes[e][P].toString()), 1);
											0 === N.length && (m().excludes[e] = i, N = I)
										}(!0 === c.keepStatic || isFinite(parseInt(c.keepStatic)) && D >= c.keepStatic) && (N = N.slice(0, 1));
										for (var R = 0; R < N.length; R++) {
											A = parseInt(N[R]), p = [], r = y(l, A, S) || O.slice(), w.matches[A] && h(w.matches[A], [A].concat(u), g) && (s = !0), k = p.slice(), l = D, p = [];
											for (var M = 0; M < k.length; M++) {
												var j = k[M],
													H = !1;
												j.alternation = j.alternation || S, _(j);
												for (var F = 0; F < C.length; F++) {
													var q = C[F];
													if ("string" != typeof T || j.alternation !== i && -1 !== t.inArray(j.locator[j.alternation].toString(), N)) {
														if (j.match.nativeDef === q.match.nativeDef) {
															H = !0, _(q, j);
															break
														}
														if (b(j, q)) {
															_(j, q) && (H = !0, C.splice(C.indexOf(q), 0, j));
															break
														}
														if (b(q, j)) {
															_(q, j);
															break
														}
														if (G = q, null === (V = j).match.fn && null !== G.match.fn && G.match.fn.test(V.match.def, m(), e, !1, c, !1)) {
															_(j, q) && (H = !0, C.splice(C.indexOf(q), 0, j));
															break
														}
													}
												}
												H || C.push(j)
											}
										}
										p = x.concat(C), l = e, d = p.length > 0, s = C.length > 0, r = O.slice()
									} else s = h(w.matches[T] || n.matches[T], [T].concat(u), g);
									if (s) return !0
								} else if (s.isQuantifier && g !== n.matches[t.inArray(s, n.matches) - 1])
									for (var B = s, W = r.length > 0 ? r.shift() : 0; W < (isNaN(B.quantifier.max) ? W + 1 : B.quantifier.max) && l <= e; W++) {
										var U = n.matches[t.inArray(B, n.matches) - 1];
										if (s = h(U, [W].concat(u), U)) {
											if ((a = p[p.length - 1].match).optionalQuantifier = W > B.quantifier.min - 1, a.jit = W + U.matches.indexOf(a) >= B.quantifier.jit, v(a, U) && W > B.quantifier.min - 1) {
												d = !0, l = e;
												break
											}
											if (B.quantifier.jit !== i && isNaN(B.quantifier.max) && a.optionalQuantifier && m().validPositions[e - 1] === i) {
												p.pop(), d = !0, l = e, f = i;
												break
											}
											return !0
										}
									} else if (s = o(s, r, u, g)) return !0
							} else l++;
							var V, G
						}
						for (var g = r.length > 0 ? r.shift() : 0; g < n.matches.length; g++)
							if (!0 !== n.matches[g].isQuantifier) {
								var v = h(n.matches[g], [g].concat(s), u);
								if (v && l === e) return v;
								if (l > e) break
							}
					}
					var a, s = m().maskToken,
						l = n ? r : 0,
						u = n ? n.slice() : [0],
						p = [],
						d = !1,
						f = n ? n.join("") : "";
					if (e > -1) {
						if (n === i) {
							for (var h, g = e - 1;
								(h = m().validPositions[g] || m().tests[g]) === i && g > -1;) g--;
							h !== i && g > -1 && (u = function (e, n) {
								var r = [];
								return t.isArray(n) || (n = [n]), n.length > 0 && (n[0].alternation === i ? 0 === (r = y(e, n.slice()).locator.slice()).length && (r = n[0].locator.slice()) : t.each(n, function (t, e) {
									if ("" !== e.def)
										if (0 === r.length) r = e.locator.slice();
										else
											for (var n = 0; n < r.length; n++) e.locator[n] && -1 === r[n].toString().indexOf(e.locator[n]) && (r[n] += "," + e.locator[n])
								})), r
							}(g, h), f = u.join(""), l = g)
						}
						if (m().tests[e] && m().tests[e][0].cd === f) return m().tests[e];
						for (var v = u.shift(); v < s.length && !(o(s[v], u, [v]) && l === e || l > e); v++);
					}
					return (0 === p.length || d) && p.push({
						match: {
							fn: null,
							optionality: !0,
							casing: null,
							def: "",
							placeholder: ""
						},
						locator: [],
						mloc: {},
						cd: f
					}), n !== i && m().tests[e] ? t.extend(!0, [], p) : (m().tests[e] = t.extend(!0, [], p), m().tests[e])
				}

				function x() {
					return m()._buffer === i && (m()._buffer = h(!1, 1), m().buffer === i && (m().buffer = m()._buffer.slice())), m()._buffer
				}

				function S(t) {
					return m().buffer !== i && !0 !== t || (m().buffer = h(!0, v(), !0)), m().buffer
				}

				function T(t, e, n) {
					var r, o;
					if (!0 === t) g(), t = 0, e = n.length;
					else
						for (r = t; r < e; r++) delete m().validPositions[r];
					for (o = t, r = t; r < e; r++)
						if (g(!0), n[r] !== c.skipOptionalPartCharacter) {
							var a = O(o, n[r], !0, !0);
							!1 !== a && (g(!0), o = a.caret !== i ? a.caret : a.pos + 1)
						}
				}

				function A(e, n, r) {
					for (var o, a = c.greedy ? n : n.slice(0, 1), s = !1, l = r !== i ? r.split(",") : [], u = 0; u < l.length; u++) - 1 !== (o = e.indexOf(l[u])) && e.splice(o, 1);
					for (var p = 0; p < e.length; p++)
						if (-1 !== t.inArray(e[p], a)) {
							s = !0;
							break
						}
					return s
				}

				function D(e, n, r, o, a) {
					var s, l, u, p, d, f, h, y = t.extend(!0, {}, m().validPositions),
						_ = !1,
						E = a !== i ? a : v();
					if (-1 === E && a === i) l = (p = k(s = 0)).alternation;
					else
						for (; E >= 0; E--)
							if ((u = m().validPositions[E]) && u.alternation !== i) {
								if (p && p.locator[u.alternation] !== u.locator[u.alternation]) break;
								s = E, l = m().validPositions[s].alternation, p = u
							} if (l !== i) {
						h = parseInt(s), m().excludes[h] = m().excludes[h] || [], !0 !== e && m().excludes[h].push(b(p));
						var w = [],
							C = 0;
						for (d = h; d < v(i, !0) + 1; d++)(f = m().validPositions[d]) && !0 !== f.generatedInput && /[0-9a-bA-Z]/.test(f.input) ? w.push(f.input) : d < e && C++, delete m().validPositions[d];
						for (; m().excludes[h] && m().excludes[h].length < 10;) {
							var x = -1 * C,
								S = w.slice();
							for (m().tests[h] = i, g(!0), _ = !0; S.length > 0;) {
								var T = S.shift();
								if (T !== c.skipOptionalPartCharacter && !(_ = O(v(i, !0) + 1, T, !1, o, !0))) break
							}
							if (_ && n !== i) {
								var A = v(e) + 1;
								for (d = h; d < v() + 1; d++)((f = m().validPositions[d]) === i || null == f.match.fn) && d < e + x && x++;
								_ = O((e += x) > A ? A : e, n, r, o, !0)
							}
							if (_) break;
							if (g(), p = k(h), m().validPositions = t.extend(!0, {}, y), !m().excludes[h]) {
								_ = D(e, n, r, o, h - 1);
								break
							}
							var N = b(p);
							if (-1 !== m().excludes[h].indexOf(N)) {
								_ = D(e, n, r, o, h - 1);
								break
							}
							for (m().excludes[h].push(N), d = h; d < v(i, !0) + 1; d++) delete m().validPositions[d]
						}
					}
					return m().excludes[h] = i, _
				}

				function O(e, n, o, a, s, l) {
					function u(t) {
						return et ? t.begin - t.end > 1 || t.begin - t.end == 1 : t.end - t.begin > 1 || t.end - t.begin == 1
					}

					function p(n, o, s) {
						var l = !1;
						return t.each(C(n), function (p, d) {
							var f = d.match;
							if (S(!0), !1 !== (l = null != f.fn ? f.fn.test(o, m(), n, s, c, u(e)) : (o === f.def || o === c.skipOptionalPartCharacter) && "" !== f.def && {
									c: j(n, f, !0) || f.def,
									pos: n
								})) {
								var h = l.c !== i ? l.c : o,
									g = n;
								return h = h === c.skipOptionalPartCharacter && null === f.fn ? j(n, f, !0) || f.def : h, l.remove !== i && (t.isArray(l.remove) || (l.remove = [l.remove]), t.each(l.remove.sort(function (t, e) {
									return e - t
								}), function (t, e) {
									I({
										begin: e,
										end: e + 1
									})
								})), l.insert !== i && (t.isArray(l.insert) || (l.insert = [l.insert]), t.each(l.insert.sort(function (t, e) {
									return t - e
								}), function (t, e) {
									O(e.pos, e.c, !0, a)
								})), !0 !== l && l.pos !== i && l.pos !== n && (g = l.pos), (!0 === l || l.pos !== i || l.c !== i) && (I(e, t.extend({}, d, {
									input: function (e, n, i) {
										switch (c.casing || n.casing) {
											case "upper":
												e = e.toUpperCase();
												break;
											case "lower":
												e = e.toLowerCase();
												break;
											case "title":
												var o = m().validPositions[i - 1];
												e = 0 === i || o && o.input === String.fromCharCode(r.keyCode.SPACE) ? e.toUpperCase() : e.toLowerCase();
												break;
											default:
												if (t.isFunction(c.casing)) {
													var a = Array.prototype.slice.call(arguments);
													a.push(m().validPositions), e = c.casing.apply(this, a)
												}
										}
										return e
									}(h, f, g)
								}), a, g) || (l = !1), !1)
							}
						}), l
					}
					o = !0 === o;
					var d = e;
					e.begin !== i && (d = et ? e.end : e.begin);
					var f = !0,
						h = t.extend(!0, {}, m().validPositions);
					if (t.isFunction(c.preValidation) && !o && !0 !== a && !0 !== l && (f = c.preValidation(S(), d, n, u(e), c, m())), !0 === f) {
						if (N(i, d, !0), (Y === i || d < Y) && (f = p(d, n, o), (!o || !0 === a) && !1 === f && !0 !== l)) {
							var v = m().validPositions[d];
							if (!v || null !== v.match.fn || v.match.def !== n && n !== c.skipOptionalPartCharacter) {
								if ((c.insertMode || m().validPositions[L(d)] === i) && !P(d, !0))
									for (var y = d + 1, b = L(d); y <= b; y++)
										if (!1 !== (f = p(y, n, o))) {
											f = N(d, f.pos !== i ? f.pos : y) || f, d = y;
											break
										}
							} else f = {
								caret: L(d)
							}
						}!1 !== f || null === c.keepStatic || !1 === c.keepStatic || o || !0 === s || (f = D(d, n, o, a)), !0 === f && (f = {
							pos: d
						})
					}
					if (t.isFunction(c.postValidation) && !1 !== f && !o && !0 !== a && !0 !== l) {
						var _ = c.postValidation(S(!0), f, c);
						if (_ !== i) {
							if (_.refreshFromBuffer && _.buffer) {
								var E = _.refreshFromBuffer;
								T(!0 === E ? E : E.start, E.end, _.buffer)
							}
							f = !0 === _ ? f : _
						}
					}
					return f && f.pos === i && (f.pos = d), !1 !== f && !0 !== l || (g(!0), m().validPositions = t.extend(!0, {}, h)), f
				}

				function N(e, n, r) {
					var o;
					if (e === i)
						for (e = n - 1; e > 0 && !m().validPositions[e]; e--);
					for (var a = e; a < n; a++)
						if (m().validPositions[a] === i && !P(a, !0)) {
							var s = 0 == a ? k(a) : m().validPositions[a - 1];
							if (s) {
								var l, u = _(s),
									c = C(a).slice(),
									p = i,
									d = k(a);
								if ("" === c[c.length - 1].match.def && c.pop(), t.each(c, function (t, e) {
										l = _(e, u.length);
										var n = Math.abs(l - u);
										(p === i || n < p) && null === e.match.fn && !0 !== e.match.optionality && !0 !== e.match.optionalQuantifier && (p = n, d = e)
									}), (d = t.extend({}, d, {
										input: j(a, d.match, !0) || d.match.def
									})).generatedInput = !0, I(a, d, !0), !0 !== r) {
									var f = m().validPositions[n].input;
									m().validPositions[n] = i, o = O(n, f, !0, !0)
								}
							}
						}
					return o
				}

				function I(e, n, r, o) {
					function a(t, e, n) {
						var r = e[t];
						if (r !== i && (null === r.match.fn && !0 !== r.match.optionality || r.input === c.radixPoint)) {
							var o = n.begin <= t - 1 ? e[t - 1] && null === e[t - 1].match.fn && e[t - 1] : e[t - 1],
								a = n.end > t + 1 ? e[t + 1] && null === e[t + 1].match.fn && e[t + 1] : e[t + 1];
							return o && a
						}
						return !1
					}
					var s = e.begin !== i ? e.begin : e,
						l = e.end !== i ? e.end : e;
					if (e.begin > e.end && (s = e.end, l = e.begin), o = o !== i ? o : s, s !== l || c.insertMode && m().validPositions[o] !== i && r === i) {
						var u = t.extend(!0, {}, m().validPositions),
							p = v(i, !0);
						for (m().p = s, b = p; b >= s; b--) m().validPositions[b] && "+" === m().validPositions[b].match.nativeDef && (c.isNegative = !1), delete m().validPositions[b];
						var d = !0,
							f = o,
							h = (m().validPositions, !1),
							y = f,
							b = f;
						for (n && (m().validPositions[o] = t.extend(!0, {}, n), y++, f++, s < l && b++); b <= p; b++) {
							var _ = u[b];
							if (_ !== i && (b >= l || b >= s && !0 !== _.generatedInput && a(b, u, {
									begin: s,
									end: l
								}))) {
								for (;
									"" !== k(y).match.def;) {
									if (!1 === h && u[y] && u[y].match.nativeDef === _.match.nativeDef) m().validPositions[y] = t.extend(!0, {}, u[y]), m().validPositions[y].input = _.input, N(i, y, !0), f = y + 1, d = !0;
									else if (w(y, _.match.def)) {
										var E = O(y, _.input, !0, !0);
										d = !1 !== E, f = E.caret || E.insert ? v() : y + 1, h = !0
									} else if (!(d = !0 === _.generatedInput || _.input === c.radixPoint && !0 === c.numericInput) && "" === k(y).match.def) break;
									if (d) break;
									y++
								}
								"" == k(y).match.def && (d = !1), y = f
							}
							if (!d) break
						}
						if (!d) return m().validPositions = t.extend(!0, {}, u), g(!0), !1
					} else n && (m().validPositions[o] = t.extend(!0, {}, n));
					return g(!0), !0
				}

				function P(t, e) {
					var n = E(t).match;
					if ("" === n.def && (n = k(t).match), null != n.fn) return n.fn;
					if (!0 !== e && t > -1) {
						var i = C(t);
						return i.length > 1 + ("" === i[i.length - 1].match.def ? 1 : 0)
					}
					return !1
				}

				function L(t, e) {
					for (var n = t + 1;
						"" !== k(n).match.def && (!0 === e && (!0 !== k(n).match.newBlockMarker || !P(n)) || !0 !== e && !P(n));) n++;
					return n
				}

				function R(t, e) {
					var n, i = t;
					if (i <= 0) return 0;
					for (; --i > 0 && (!0 === e && !0 !== k(i).match.newBlockMarker || !0 !== e && !P(i) && ((n = C(i)).length < 2 || 2 === n.length && "" === n[1].match.def)););
					return i
				}

				function M(e, n, r, o, a) {
					if (o && t.isFunction(c.onBeforeWrite)) {
						var s = c.onBeforeWrite.call(Z, o, n, r, c);
						if (s) {
							if (s.refreshFromBuffer) {
								var l = s.refreshFromBuffer;
								T(!0 === l ? l : l.start, l.end, s.buffer || n), n = S(!0)
							}
							r !== i && (r = s.caret !== i ? s.caret : r)
						}
					}
					e !== i && (e.inputmask._valueSet(n.join("")), r === i || o !== i && "blur" === o.type ? z(e, r, 0 === n.length) : B(e, r), !0 === a && (it = !0, t(e).trigger("input")))
				}

				function j(e, n, r) {
					if ((n = n || k(e).match).placeholder !== i || !0 === r) return t.isFunction(n.placeholder) ? n.placeholder(c) : n.placeholder;
					if (null === n.fn) {
						if (e > -1 && m().validPositions[e] === i) {
							var o, a = C(e),
								s = [];
							if (a.length > 1 + ("" === a[a.length - 1].match.def ? 1 : 0))
								for (var l = 0; l < a.length; l++)
									if (!0 !== a[l].match.optionality && !0 !== a[l].match.optionalQuantifier && (null === a[l].match.fn || o === i || !1 !== a[l].match.fn.test(o.match.def, m(), e, !0, c)) && (s.push(a[l]), null === a[l].match.fn && (o = a[l]), s.length > 1 && /[0-9a-bA-Z]/.test(s[0].match.def))) return c.placeholder.charAt(e % c.placeholder.length)
						}
						return n.def
					}
					return c.placeholder.charAt(e % c.placeholder.length)
				}

				function H(e, n, o, a, s) {
					var l = a.slice(),
						u = "",
						p = -1,
						d = i;
					if (g(), o || !0 === c.autoUnmask) p = L(p);
					else {
						var f = x().slice(0, L(-1)).join(""),
							y = l.join("").match(new RegExp("^" + r.escapeRegex(f), "g"));
						y && y.length > 0 && (l.splice(0, y.length * f.length), p = L(p))
					} - 1 === p ? (m().p = L(p), p = 0) : m().p = p, t.each(l, function (n, r) {
						if (r !== i)
							if (m().validPositions[n] === i && l[n] === j(n) && P(n, !0) && !1 === O(n, l[n], !0, i, i, !0)) m().p++;
							else {
								var a = new t.Event("_checkval");
								a.which = r.charCodeAt(0), u += r;
								var s = v(i, !0),
									f = k(s),
									g = E(s + 1, f ? f.locator.slice() : i, s);
								if (! function (t, e) {
										return -1 !== h(!0, 0, !1).slice(t, L(t)).join("").indexOf(e) && !P(t) && (k(t).match.nativeDef === e.charAt(0) || " " === k(t).match.nativeDef && k(t + 1).match.nativeDef === e.charAt(0))
									}(p, u) || o || c.autoUnmask) {
									var y = o ? n : null == g.match.fn && g.match.optionality && s + 1 < m().p ? s + 1 : m().p;
									(d = lt.keypressEvent.call(e, a, !0, !1, o, y)) && (p = y + 1, u = "")
								} else d = lt.keypressEvent.call(e, a, !0, !1, !0, s + 1);
								M(i, S(), d.forwardPosition, a, !1)
							}
					}), n && M(e, S(), d ? d.forwardPosition : i, s || new t.Event("checkval"), s && "input" === s.type)
				}

				function F(e) {
					if (e) {
						if (e.inputmask === i) return e.value;
						e.inputmask && e.inputmask.refreshValue && lt.setValueEvent.call(e)
					}
					var n = [],
						r = m().validPositions;
					for (var o in r) r[o].match && null != r[o].match.fn && n.push(r[o].input);
					var a = 0 === n.length ? "" : (et ? n.reverse() : n).join("");
					if (t.isFunction(c.onUnMask)) {
						var s = (et ? S().slice().reverse() : S()).join("");
						a = c.onUnMask.call(Z, s, a, c)
					}
					return a
				}

				function q(t) {
					return !et || "number" != typeof t || c.greedy && "" === c.placeholder || (t = tt.inputmask._valueGet().length - t), t
				}

				function B(r, o, a, s) {
					var l;
					if (o === i) return r.setSelectionRange ? (o = r.selectionStart, a = r.selectionEnd) : e.getSelection ? (l = e.getSelection().getRangeAt(0)).commonAncestorContainer.parentNode !== r && l.commonAncestorContainer !== r || (o = l.startOffset, a = l.endOffset) : n.selection && n.selection.createRange && (a = (o = 0 - (l = n.selection.createRange()).duplicate().moveStart("character", -r.inputmask._valueGet().length)) + l.text.length), {
						begin: s ? o : q(o),
						end: s ? a : q(a)
					};
					if (t.isArray(o) && (a = et ? o[0] : o[1], o = et ? o[1] : o[0]), o.begin !== i && (a = et ? o.begin : o.end, o = et ? o.end : o.begin), "number" == typeof o) {
						o = s ? o : q(o), a = "number" == typeof (a = s ? a : q(a)) ? a : o;
						var u = parseInt(((r.ownerDocument.defaultView || e).getComputedStyle ? (r.ownerDocument.defaultView || e).getComputedStyle(r, null) : r.currentStyle).fontSize) * a;
						if (r.scrollLeft = u > r.scrollWidth ? u : 0, f || !1 !== c.insertMode || o !== a || a++, r.inputmask.caretPos = {
								begin: o,
								end: a
							}, r.setSelectionRange) r.selectionStart = o, r.selectionEnd = a;
						else if (e.getSelection) {
							if (l = n.createRange(), r.firstChild === i || null === r.firstChild) {
								var p = n.createTextNode("");
								r.appendChild(p)
							}
							l.setStart(r.firstChild, o < r.inputmask._valueGet().length ? o : r.inputmask._valueGet().length), l.setEnd(r.firstChild, a < r.inputmask._valueGet().length ? a : r.inputmask._valueGet().length), l.collapse(!0);
							var d = e.getSelection();
							d.removeAllRanges(), d.addRange(l)
						} else r.createTextRange && ((l = r.createTextRange()).collapse(!0), l.moveEnd("character", a), l.moveStart("character", o), l.select());
						z(r, {
							begin: o,
							end: a
						})
					}
				}

				function W(e) {
					var n, r, o = h(!0, v(), !0, !0),
						a = o.length,
						s = v(),
						l = {},
						u = m().validPositions[s],
						c = u !== i ? u.locator.slice() : i;
					for (n = s + 1; n < o.length; n++) c = (r = E(n, c, n - 1)).locator.slice(), l[n] = t.extend(!0, {}, r);
					var p = u && u.alternation !== i ? u.locator[u.alternation] : i;
					for (n = a - 1; n > s && ((r = l[n]).match.optionality || r.match.optionalQuantifier && r.match.newBlockMarker || p && (p !== l[n].locator[u.alternation] && null != r.match.fn || null === r.match.fn && r.locator[u.alternation] && A(r.locator[u.alternation].toString().split(","), p.toString().split(",")) && "" !== C(n)[0].def)) && o[n] === j(n, r.match); n--) a--;
					return e ? {
						l: a,
						def: l[a] ? l[a].match : i
					} : a
				}

				function U(t) {
					for (var e, n = W(), r = t.length, o = m().validPositions[v()]; n < r && !P(n, !0) && (e = o !== i ? E(n, o.locator.slice(""), o) : k(n)) && !0 !== e.match.optionality && (!0 !== e.match.optionalQuantifier && !0 !== e.match.newBlockMarker || n + 1 === r && "" === (o !== i ? E(n + 1, o.locator.slice(""), o) : k(n + 1)).match.def);) n++;
					for (;
						(e = m().validPositions[n - 1]) && e && e.match.optionality && e.input === c.skipOptionalPartCharacter;) n--;
					return t.splice(n), t
				}

				function V(e) {
					if (t.isFunction(c.isComplete)) return c.isComplete(e, c);
					if ("*" === c.repeat) return i;
					var n = !1,
						r = W(!0),
						o = R(r.l);
					if (r.def === i || r.def.newBlockMarker || r.def.optionality || r.def.optionalQuantifier) {
						n = !0;
						for (var a = 0; a <= o; a++) {
							var s = E(a).match;
							if (null !== s.fn && m().validPositions[a] === i && !0 !== s.optionality && !0 !== s.optionalQuantifier || null === s.fn && e[a] !== j(a, s)) {
								n = !1;
								break
							}
						}
					}
					return n
				}

				function G(t, e, n, o, a) {
					if ((c.numericInput || et) && (e === r.keyCode.BACKSPACE ? e = r.keyCode.DELETE : e === r.keyCode.DELETE && (e = r.keyCode.BACKSPACE), et)) {
						var s = n.end;
						n.end = n.begin, n.begin = s
					}
					if (e === r.keyCode.BACKSPACE && (n.end - n.begin < 1 || !1 === c.insertMode) ? (n.begin = R(n.begin), m().validPositions[n.begin] !== i && m().validPositions[n.begin].input === c.groupSeparator && n.begin--, !1 === c.insertMode && n.end !== m().maskLength && n.end--) : e === r.keyCode.DELETE && n.begin === n.end && (n.end = P(n.end, !0) && m().validPositions[n.end] && m().validPositions[n.end].input !== c.radixPoint ? n.end + 1 : L(n.end) + 1, m().validPositions[n.begin] !== i && m().validPositions[n.begin].input === c.groupSeparator && n.end++), I(n), !0 !== o && null !== c.keepStatic && !1 !== c.keepStatic) {
						var l = D(!0);
						l && (n.begin = l.caret !== i ? l.caret : l.pos ? L(l.pos.begin ? l.pos.begin : l.pos) : v(-1, !0))
					}
					var u = v(n.begin, !0);
					if (u < n.begin || -1 === n.begin) m().p = L(u);
					else if (!0 !== o && (m().p = n.begin, !0 !== a))
						for (; m().p < u && m().validPositions[m().p] === i;) m().p++
				}

				function $(i) {
					var r = (i.ownerDocument.defaultView || e).getComputedStyle(i, null),
						o = n.createElement("div");
					o.style.width = r.width, o.style.textAlign = r.textAlign, X = n.createElement("div"), i.inputmask.colorMask = X, X.className = "im-colormask", i.parentNode.insertBefore(X, i), i.parentNode.removeChild(i), X.appendChild(i), X.appendChild(o), i.style.left = o.offsetLeft + "px", t(X).on("mouseleave", function (t) {
						return lt.mouseleaveEvent.call(i, [t])
					}), t(X).on("mouseenter", function (t) {
						return lt.mouseenterEvent.call(i, [t])
					}), t(X).on("click", function (t) {
						return B(i, function (t) {
							var e, o = n.createElement("span");
							for (var a in r) isNaN(a) && -1 !== a.indexOf("font") && (o.style[a] = r[a]);
							o.style.textTransform = r.textTransform, o.style.letterSpacing = r.letterSpacing, o.style.position = "absolute", o.style.height = "auto", o.style.width = "auto", o.style.visibility = "hidden", o.style.whiteSpace = "nowrap", n.body.appendChild(o);
							var s, l = i.inputmask._valueGet(),
								u = 0;
							for (e = 0, s = l.length; e <= s; e++) {
								if (o.innerHTML += l.charAt(e) || "_", o.offsetWidth >= t) {
									var c = t - u,
										p = o.offsetWidth - t;
									o.innerHTML = l.charAt(e), e = (c -= o.offsetWidth / 3) < p ? e - 1 : e;
									break
								}
								u = o.offsetWidth
							}
							return n.body.removeChild(o), e
						}(t.clientX)), lt.clickEvent.call(i, [t])
					}), t(i).on("keydown", function (t) {
						t.shiftKey || !1 === c.insertMode || setTimeout(function () {
							z(i)
						}, 0)
					})
				}

				function z(t, e, r) {
					function o(t) {
						if (t === i && (t = ""), p || null !== a.fn && s.input !== i)
							if (p && (null !== a.fn && s.input !== i || "" === a.def)) {
								p = !1;
								var e = u.length;
								u[e - 1] = u[e - 1] + "</span>", u.push(t)
							} else u.push(t);
						else p = !0, u.push("<span class='im-static'>" + t)
					}
					var a, s, l, u = [],
						p = !1,
						d = 0;
					if (X !== i) {
						var f = S();
						if (e === i ? e = B(t) : e.begin === i && (e = {
								begin: e,
								end: e
							}), !0 !== r) {
							var h = v();
							do {
								m().validPositions[d] ? (s = m().validPositions[d], a = s.match, l = s.locator.slice(), o(f[d])) : (s = E(d, l, d - 1), a = s.match, l = s.locator.slice(), (!1 === c.jitMasking || d < h || "number" == typeof c.jitMasking && isFinite(c.jitMasking) && c.jitMasking > d) && o(j(d, a))), d++
							} while ((Y === i || d < Y) && (null !== a.fn || "" !== a.def) || h > d || p);
							p && o(), n.activeElement === t && (u.splice(e.begin, 0, e.begin === e.end || e.end > m().maskLength ? '<mark class="im-caret" style="border-right-width: 1px;border-right-style: solid;">' : '<mark class="im-caret-select">'), u.splice(e.end + 1, 0, "</mark>"))
						}
						var g = X.getElementsByTagName("div")[0];
						g.innerHTML = u.join(""), t.inputmask.positionColorMask(t, g)
					}
				}
				a = a || this.maskset, c = c || this.opts;
				var K, Q, Y, X, J, Z = this,
					tt = this.el,
					et = this.isRTL,
					nt = !1,
					it = !1,
					rt = !1,
					ot = !1,
					at = !1,
					st = {
						on: function (e, n, o) {
							var a = function (e) {
								var n = this;
								if (n.inputmask === i && "FORM" !== this.nodeName) {
									var a = t.data(n, "_inputmask_opts");
									a ? new r(a).mask(n) : st.off(n)
								} else {
									if ("setvalue" === e.type || "FORM" === this.nodeName || !(n.disabled || n.readOnly && !("keydown" === e.type && e.ctrlKey && 67 === e.keyCode || !1 === c.tabThrough && e.keyCode === r.keyCode.TAB))) {
										switch (e.type) {
											case "input":
												if (!0 === it) return it = !1, e.preventDefault();
												p && (at = !0);
												break;
											case "keydown":
												nt = !1, it = !1;
												break;
											case "keypress":
												if (!0 === nt) return e.preventDefault();
												nt = !0;
												break;
											case "click":
												if (d || f) {
													var s = arguments;
													return setTimeout(function () {
														o.apply(n, s)
													}, 0), !1
												}
										}
										var l = o.apply(n, arguments);
										return at && (at = !1, setTimeout(function () {
											B(n, n.inputmask.caretPos, i, !0)
										})), !1 === l && (e.preventDefault(), e.stopPropagation()), l
									}
									e.preventDefault()
								}
							};
							e.inputmask.events[n] = e.inputmask.events[n] || [], e.inputmask.events[n].push(a), -1 !== t.inArray(n, ["submit", "reset"]) ? null !== e.form && t(e.form).on(n, a) : t(e).on(n, a)
						},
						off: function (e, n) {
							var i;
							e.inputmask && e.inputmask.events && (n ? (i = [])[n] = e.inputmask.events[n] : i = e.inputmask.events, t.each(i, function (n, i) {
								for (; i.length > 0;) {
									var r = i.pop(); - 1 !== t.inArray(n, ["submit", "reset"]) ? null !== e.form && t(e.form).off(n, r) : t(e).off(n, r)
								}
								delete e.inputmask.events[n]
							}))
						}
					},
					lt = {
						keydownEvent: function (e) {
							var n = this,
								i = t(n),
								o = e.keyCode,
								a = B(n);
							if (o === r.keyCode.BACKSPACE || o === r.keyCode.DELETE || f && o === r.keyCode.BACKSPACE_SAFARI || e.ctrlKey && o === r.keyCode.X && !l("cut")) e.preventDefault(), G(n, o, a), M(n, S(!0), m().p, e, n.inputmask._valueGet() !== S().join("")), n.inputmask._valueGet() === x().join("") ? i.trigger("cleared") : !0 === V(S()) && i.trigger("complete");
							else if (o === r.keyCode.END || o === r.keyCode.PAGE_DOWN) {
								e.preventDefault();
								var s = L(v());
								c.insertMode || s !== m().maskLength || e.shiftKey || s--, B(n, e.shiftKey ? a.begin : s, s, !0)
							} else o === r.keyCode.HOME && !e.shiftKey || o === r.keyCode.PAGE_UP ? (e.preventDefault(), B(n, 0, e.shiftKey ? a.begin : 0, !0)) : (c.undoOnEscape && o === r.keyCode.ESCAPE || 90 === o && e.ctrlKey) && !0 !== e.altKey ? (H(n, !0, !1, K.split("")), i.trigger("click")) : o !== r.keyCode.INSERT || e.shiftKey || e.ctrlKey ? !0 === c.tabThrough && o === r.keyCode.TAB ? (!0 === e.shiftKey ? (null === k(a.begin).match.fn && (a.begin = L(a.begin)), a.end = R(a.begin, !0), a.begin = R(a.end, !0)) : (a.begin = L(a.begin, !0), a.end = L(a.begin, !0), a.end < m().maskLength && a.end--), a.begin < m().maskLength && (e.preventDefault(), B(n, a.begin, a.end))) : e.shiftKey || !1 === c.insertMode && (o === r.keyCode.RIGHT ? setTimeout(function () {
								var t = B(n);
								B(n, t.begin)
							}, 0) : o === r.keyCode.LEFT && setTimeout(function () {
								var t = B(n);
								B(n, et ? t.begin + 1 : t.begin - 1)
							}, 0)) : (c.insertMode = !c.insertMode, B(n, c.insertMode || a.begin !== m().maskLength ? a.begin : a.begin - 1));
							c.onKeyDown.call(this, e, S(), B(n).begin, c), rt = -1 !== t.inArray(o, c.ignorables)
						},
						keypressEvent: function (e, n, o, a, s) {
							var l = this,
								u = t(l),
								p = e.which || e.charCode || e.keyCode;
							if (!(!0 === n || e.ctrlKey && e.altKey) && (e.ctrlKey || e.metaKey || rt)) return p === r.keyCode.ENTER && K !== S().join("") && (K = S().join(""), setTimeout(function () {
								u.trigger("change")
							}, 0)), !0;
							if (p) {
								46 === p && !1 === e.shiftKey && "" !== c.radixPoint && (p = c.radixPoint.charCodeAt(0));
								var d, f = n ? {
										begin: s,
										end: s
									} : B(l),
									h = String.fromCharCode(p),
									v = 0;
								if (c._radixDance && c.numericInput) {
									var y = S().indexOf(c.radixPoint.charAt(0)) + 1;
									f.begin <= y && (p === c.radixPoint.charCodeAt(0) && (v = 1), f.begin -= 1, f.end -= 1)
								}
								m().writeOutBuffer = !0;
								var b = O(f, h, a);
								if (!1 !== b && (g(!0), d = b.caret !== i ? b.caret : L(b.pos.begin ? b.pos.begin : b.pos), m().p = d), d = (c.numericInput && b.caret === i ? R(d) : d) + v, !1 !== o && (setTimeout(function () {
										c.onKeyValidation.call(l, p, b, c)
									}, 0), m().writeOutBuffer && !1 !== b)) {
									var _ = S();
									M(l, _, d, e, !0 !== n), !0 !== n && setTimeout(function () {
										!0 === V(_) && u.trigger("complete")
									}, 0)
								}
								if (e.preventDefault(), n) return !1 !== b && (b.forwardPosition = d), b
							}
						},
						pasteEvent: function (n) {
							var i, r = n.originalEvent || n,
								o = t(this),
								a = this.inputmask._valueGet(!0),
								s = B(this);
							et && (i = s.end, s.end = s.begin, s.begin = i);
							var l = a.substr(0, s.begin),
								u = a.substr(s.end, a.length);
							if (l === (et ? x().reverse() : x()).slice(0, s.begin).join("") && (l = ""), u === (et ? x().reverse() : x()).slice(s.end).join("") && (u = ""), et && (i = l, l = u, u = i), e.clipboardData && e.clipboardData.getData) a = l + e.clipboardData.getData("Text") + u;
							else {
								if (!r.clipboardData || !r.clipboardData.getData) return !0;
								a = l + r.clipboardData.getData("text/plain") + u
							}
							var p = a;
							if (t.isFunction(c.onBeforePaste)) {
								if (!1 === (p = c.onBeforePaste.call(Z, a, c))) return n.preventDefault();
								p || (p = a)
							}
							return H(this, !1, !1, et ? p.split("").reverse() : p.toString().split("")), M(this, S(), L(v()), n, K !== S().join("")), !0 === V(S()) && o.trigger("complete"), n.preventDefault()
						},
						inputFallBackEvent: function (e) {
							var n = this,
								i = n.inputmask._valueGet();
							if (S().join("") !== i) {
								var o = B(n);
								if (i = function (t, e, n) {
										if (d) {
											var i = e.replace(S().join(""), "");
											if (1 === i.length) {
												var r = e.split("");
												r.splice(n.begin, 0, i), e = r.join("")
											}
										}
										return e
									}(0, i = function (t, e, n) {
										return "." === e.charAt(n.begin - 1) && "" !== c.radixPoint && ((e = e.split(""))[n.begin - 1] = c.radixPoint.charAt(0), e = e.join("")), e
									}(0, i, o), o), S().join("") !== i) {
									var a = S().join(""),
										s = !c.numericInput && i.length > a.length ? -1 : 0,
										l = i.substr(0, o.begin),
										u = i.substr(o.begin),
										p = a.substr(0, o.begin + s),
										f = a.substr(o.begin + s),
										h = o,
										m = "",
										g = !1;
									if (l !== p) {
										for (var v = (g = l.length >= p.length) ? l.length : p.length, y = 0; l.charAt(y) === p.charAt(y) && y < v; y++);
										g && (0 === s && (h.begin = y), m += l.slice(y, h.end))
									}
									if (u !== f && (u.length > f.length ? m += u.slice(0, 1) : u.length < f.length && (h.end += f.length - u.length, g || "" === c.radixPoint || "" !== u || l.charAt(h.begin + s - 1) !== c.radixPoint || (h.begin--, m = c.radixPoint))), M(n, S(), {
											begin: h.begin + s,
											end: h.end + s
										}), m.length > 0) t.each(m.split(""), function (e, i) {
										var r = new t.Event("keypress");
										r.which = i.charCodeAt(0), rt = !1, lt.keypressEvent.call(n, r)
									});
									else {
										h.begin === h.end - 1 && (h.begin = R(h.begin + 1), h.begin === h.end - 1 ? B(n, h.begin) : B(n, h.begin, h.end));
										var b = new t.Event("keydown");
										b.keyCode = c.numericInput ? r.keyCode.BACKSPACE : r.keyCode.DELETE, lt.keydownEvent.call(n, b), !1 === c.insertMode && B(n, B(n).begin - 1)
									}
									e.preventDefault()
								}
							}
						},
						setValueEvent: function (e) {
							this.inputmask.refreshValue = !1;
							var n = (n = e && e.detail ? e.detail[0] : arguments[1]) || this.inputmask._valueGet(!0);
							t.isFunction(c.onBeforeMask) && (n = c.onBeforeMask.call(Z, n, c) || n), n = n.split(""), H(this, !0, !1, et ? n.reverse() : n), K = S().join(""), (c.clearMaskOnLostFocus || c.clearIncomplete) && this.inputmask._valueGet() === x().join("") && this.inputmask._valueSet("")
						},
						focusEvent: function (t) {
							var e = this.inputmask._valueGet();
							c.showMaskOnFocus && (!c.showMaskOnHover || c.showMaskOnHover && "" === e) && (this.inputmask._valueGet() !== S().join("") ? M(this, S(), L(v())) : !1 === ot && B(this, L(v()))), !0 === c.positionCaretOnTab && !1 === ot && lt.clickEvent.apply(this, [t, !0]), K = S().join("")
						},
						mouseleaveEvent: function () {
							if (ot = !1, c.clearMaskOnLostFocus && n.activeElement !== this) {
								var t = S().slice(),
									e = this.inputmask._valueGet();
								e !== this.getAttribute("placeholder") && "" !== e && (-1 === v() && e === x().join("") ? t = [] : U(t), M(this, t))
							}
						},
						clickEvent: function (e, r) {
							var o = this;
							setTimeout(function () {
								if (n.activeElement === o) {
									var e = B(o);
									if (r && (et ? e.end = e.begin : e.begin = e.end), e.begin === e.end) switch (c.positionCaretOnClick) {
										case "none":
											break;
										case "select":
											B(o, 0, S().length);
											break;
										case "radixFocus":
											if (function (e) {
													if ("" !== c.radixPoint) {
														var n = m().validPositions;
														if (n[e] === i || n[e].input === j(e)) {
															if (e < L(-1)) return !0;
															var r = t.inArray(c.radixPoint, S());
															if (-1 !== r) {
																for (var o in n)
																	if (r < o && n[o].input !== j(o)) return !1;
																return !0
															}
														}
													}
													return !1
												}(e.begin)) {
												var a = S().join("").indexOf(c.radixPoint);
												B(o, c.numericInput ? L(a) : a);
												break
											}
										default:
											var s = e.begin,
												l = v(s, !0),
												u = L(l);
											if (s < u) B(o, P(s, !0) || P(s - 1, !0) ? s : L(s));
											else {
												var p = m().validPositions[l],
													d = E(u, p ? p.match.locator : i, p),
													f = j(u, d.match);
												if ("" !== f && S()[u] !== f && !0 !== d.match.optionalQuantifier && !0 !== d.match.newBlockMarker || !P(u, c.keepStatic) && d.match.def === f) {
													var h = L(u);
													(s >= h || s === u) && (u = h)
												}
												B(o, u)
											}
									}
								}
							}, 0)
						},
						dblclickEvent: function () {
							var t = this;
							setTimeout(function () {
								B(t, 0, L(v()))
							}, 0)
						},
						cutEvent: function (i) {
							var o = t(this),
								a = B(this),
								s = i.originalEvent || i,
								l = e.clipboardData || s.clipboardData,
								u = et ? S().slice(a.end, a.begin) : S().slice(a.begin, a.end);
							l.setData("text", et ? u.reverse().join("") : u.join("")), n.execCommand && n.execCommand("copy"), G(this, r.keyCode.DELETE, a), M(this, S(), m().p, i, K !== S().join("")), this.inputmask._valueGet() === x().join("") && o.trigger("cleared")
						},
						blurEvent: function (e) {
							var n = t(this);
							if (this.inputmask) {
								var r = this.inputmask._valueGet(),
									o = S().slice();
								"" === r && X === i || (c.clearMaskOnLostFocus && (-1 === v() && r === x().join("") ? o = [] : U(o)), !1 === V(o) && (setTimeout(function () {
									n.trigger("incomplete")
								}, 0), c.clearIncomplete && (g(), o = c.clearMaskOnLostFocus ? [] : x().slice())), M(this, o, i, e)), K !== S().join("") && (K = o.join(""), n.trigger("change"))
							}
						},
						mouseenterEvent: function () {
							ot = !0, n.activeElement !== this && c.showMaskOnHover && this.inputmask._valueGet() !== S().join("") && M(this, S())
						},
						submitEvent: function () {
							K !== S().join("") && Q.trigger("change"), c.clearMaskOnLostFocus && -1 === v() && tt.inputmask._valueGet && tt.inputmask._valueGet() === x().join("") && tt.inputmask._valueSet(""), c.clearIncomplete && !1 === V(S()) && tt.inputmask._valueSet(""), c.removeMaskOnSubmit && (tt.inputmask._valueSet(tt.inputmask.unmaskedvalue(), !0), setTimeout(function () {
								M(tt, S())
							}, 0))
						},
						resetEvent: function () {
							tt.inputmask.refreshValue = !0, setTimeout(function () {
								Q.trigger("setvalue")
							}, 0)
						}
					};
				if (r.prototype.positionColorMask = function (t, e) {
						t.style.left = e.offsetLeft + "px"
					}, o !== i) switch (o.action) {
					case "isComplete":
						return tt = o.el, V(S());
					case "unmaskedvalue":
						return tt !== i && o.value === i || (J = o.value, J = (t.isFunction(c.onBeforeMask) && c.onBeforeMask.call(Z, J, c) || J).split(""), H(i, !1, !1, et ? J.reverse() : J), t.isFunction(c.onBeforeWrite) && c.onBeforeWrite.call(Z, i, S(), 0, c)), F(tt);
					case "mask":
						! function (e) {
							st.off(e);
							var r = function (e, r) {
								var o = e.getAttribute("type"),
									a = "INPUT" === e.tagName && -1 !== t.inArray(o, r.supportsInputType) || e.isContentEditable || "TEXTAREA" === e.tagName;
								if (!a)
									if ("INPUT" === e.tagName) {
										var l = n.createElement("input");
										l.setAttribute("type", o), a = "text" === l.type, l = null
									} else a = "partial";
								return !1 !== a ? function (e) {
									function o() {
										return this.inputmask ? this.inputmask.opts.autoUnmask ? this.inputmask.unmaskedvalue() : -1 !== v() || !0 !== r.nullable ? n.activeElement === this && r.clearMaskOnLostFocus ? (et ? U(S().slice()).reverse() : U(S().slice())).join("") : l.call(this) : "" : l.call(this)
									}

									function a(e) {
										u.call(this, e), this.inputmask && t(this).trigger("setvalue", [e])
									}
									var l, u;
									if (!e.inputmask.__valueGet) {
										if (!0 !== r.noValuePatching) {
											if (Object.getOwnPropertyDescriptor) {
												"function" != typeof Object.getPrototypeOf && (Object.getPrototypeOf = "object" === s("test".__proto__) ? function (t) {
													return t.__proto__
												} : function (t) {
													return t.constructor.prototype
												});
												var c = Object.getPrototypeOf ? Object.getOwnPropertyDescriptor(Object.getPrototypeOf(e), "value") : i;
												c && c.get && c.set ? (l = c.get, u = c.set, Object.defineProperty(e, "value", {
													get: o,
													set: a,
													configurable: !0
												})) : "INPUT" !== e.tagName && (l = function () {
													return this.textContent
												}, u = function (t) {
													this.textContent = t
												}, Object.defineProperty(e, "value", {
													get: o,
													set: a,
													configurable: !0
												}))
											} else n.__lookupGetter__ && e.__lookupGetter__("value") && (l = e.__lookupGetter__("value"), u = e.__lookupSetter__("value"), e.__defineGetter__("value", o), e.__defineSetter__("value", a));
											e.inputmask.__valueGet = l, e.inputmask.__valueSet = u
										}
										e.inputmask._valueGet = function (t) {
											return et && !0 !== t ? l.call(this.el).split("").reverse().join("") : l.call(this.el)
										}, e.inputmask._valueSet = function (t, e) {
											u.call(this.el, null === t || t === i ? "" : !0 !== e && et ? t.split("").reverse().join("") : t)
										}, l === i && (l = function () {
											return this.value
										}, u = function (t) {
											this.value = t
										}, function (e) {
											if (t.valHooks && (t.valHooks[e] === i || !0 !== t.valHooks[e].inputmaskpatch)) {
												var n = t.valHooks[e] && t.valHooks[e].get ? t.valHooks[e].get : function (t) {
														return t.value
													},
													o = t.valHooks[e] && t.valHooks[e].set ? t.valHooks[e].set : function (t, e) {
														return t.value = e, t
													};
												t.valHooks[e] = {
													get: function (t) {
														if (t.inputmask) {
															if (t.inputmask.opts.autoUnmask) return t.inputmask.unmaskedvalue();
															var e = n(t);
															return -1 !== v(i, i, t.inputmask.maskset.validPositions) || !0 !== r.nullable ? e : ""
														}
														return n(t)
													},
													set: function (e, n) {
														var i, r = t(e);
														return i = o(e, n), e.inputmask && r.trigger("setvalue", [n]), i
													},
													inputmaskpatch: !0
												}
											}
										}(e.type), function (e) {
											st.on(e, "mouseenter", function () {
												var e = t(this);
												this.inputmask._valueGet() !== S().join("") && e.trigger("setvalue")
											})
										}(e))
									}
								}(e) : e.inputmask = i, a
							}(e, c);
							if (!1 !== r && (Q = t(tt = e), -1 === (Y = tt !== i ? tt.maxLength : i) && (Y = i), !0 === c.colorMask && $(tt), p && ("inputmode" in tt && (tt.inputmode = c.inputmode, tt.setAttribute("inputmode", c.inputmode)), !0 === c.disablePredictiveText && ("autocorrect" in tt ? tt.autocorrect = !1 : (!0 !== c.colorMask && $(tt), tt.type = "password"))), !0 === r && (st.on(tt, "submit", lt.submitEvent), st.on(tt, "reset", lt.resetEvent), st.on(tt, "blur", lt.blurEvent), st.on(tt, "focus", lt.focusEvent), !0 !== c.colorMask && (st.on(tt, "click", lt.clickEvent), st.on(tt, "mouseleave", lt.mouseleaveEvent), st.on(tt, "mouseenter", lt.mouseenterEvent)), st.on(tt, "dblclick", lt.dblclickEvent), st.on(tt, "paste", lt.pasteEvent), st.on(tt, "dragdrop", lt.pasteEvent), st.on(tt, "drop", lt.pasteEvent), st.on(tt, "cut", lt.cutEvent), st.on(tt, "complete", c.oncomplete), st.on(tt, "incomplete", c.onincomplete), st.on(tt, "cleared", c.oncleared), p || !0 === c.inputEventOnly ? tt.removeAttribute("maxLength") : (st.on(tt, "keydown", lt.keydownEvent), st.on(tt, "keypress", lt.keypressEvent)), st.on(tt, "compositionstart", t.noop), st.on(tt, "compositionupdate", t.noop), st.on(tt, "compositionend", t.noop), st.on(tt, "keyup", t.noop), st.on(tt, "input", lt.inputFallBackEvent), st.on(tt, "beforeinput", t.noop)), st.on(tt, "setvalue", lt.setValueEvent), K = x().join(""), "" !== tt.inputmask._valueGet(!0) || !1 === c.clearMaskOnLostFocus || n.activeElement === tt)) {
								var o = t.isFunction(c.onBeforeMask) && c.onBeforeMask.call(Z, tt.inputmask._valueGet(!0), c) || tt.inputmask._valueGet(!0);
								"" !== o && H(tt, !0, !1, et ? o.split("").reverse() : o.split(""));
								var a = S().slice();
								K = a.join(""), !1 === V(a) && c.clearIncomplete && g(), c.clearMaskOnLostFocus && n.activeElement !== tt && (-1 === v() ? a = [] : U(a)), M(tt, a), n.activeElement === tt && B(tt, L(v()))
							}
						}(tt);
						break;
					case "format":
						return J = (t.isFunction(c.onBeforeMask) && c.onBeforeMask.call(Z, o.value, c) || o.value).split(""), H(i, !0, !1, et ? J.reverse() : J), o.metadata ? {
							value: et ? S().slice().reverse().join("") : S().join(""),
							metadata: u.call(this, {
								action: "getmetadata"
							}, a, c)
						} : et ? S().slice().reverse().join("") : S().join("");
					case "isValid":
						o.value ? (J = o.value.split(""), H(i, !0, !0, et ? J.reverse() : J)) : o.value = S().join("");
						for (var ut = S(), ct = W(), pt = ut.length - 1; pt > ct && !P(pt); pt--);
						return ut.splice(ct, pt + 1 - ct), V(ut) && o.value === S().join("");
					case "getemptymask":
						return x().join("");
					case "remove":
						return tt && tt.inputmask && (t.data(tt, "_inputmask_opts", null), Q = t(tt), tt.inputmask._valueSet(c.autoUnmask ? F(tt) : tt.inputmask._valueGet(!0)), st.off(tt), tt.inputmask.colorMask && ((X = tt.inputmask.colorMask).removeChild(tt), X.parentNode.insertBefore(tt, X), X.parentNode.removeChild(X)), Object.getOwnPropertyDescriptor && Object.getPrototypeOf ? Object.getOwnPropertyDescriptor(Object.getPrototypeOf(tt), "value") && tt.inputmask.__valueGet && Object.defineProperty(tt, "value", {
							get: tt.inputmask.__valueGet,
							set: tt.inputmask.__valueSet,
							configurable: !0
						}) : n.__lookupGetter__ && tt.__lookupGetter__("value") && tt.inputmask.__valueGet && (tt.__defineGetter__("value", tt.inputmask.__valueGet), tt.__defineSetter__("value", tt.inputmask.__valueSet)), tt.inputmask = i), tt;
					case "getmetadata":
						if (t.isArray(a.metadata)) {
							var dt = h(!0, 0, !1).join("");
							return t.each(a.metadata, function (t, e) {
								if (e.mask === dt) return dt = e, !1
							}), dt
						}
						return a.metadata
				}
			}
			var c = navigator.userAgent,
				p = l("touchstart"),
				d = /iemobile/i.test(c),
				f = /iphone/i.test(c) && !d;
			return r.prototype = {
				dataAttribute: "data-inputmask",
				defaults: {
					placeholder: "_",
					optionalmarker: ["[", "]"],
					quantifiermarker: ["{", "}"],
					groupmarker: ["(", ")"],
					alternatormarker: "|",
					escapeChar: "\\",
					mask: null,
					regex: null,
					oncomplete: t.noop,
					onincomplete: t.noop,
					oncleared: t.noop,
					repeat: 0,
					greedy: !0,
					autoUnmask: !1,
					removeMaskOnSubmit: !1,
					clearMaskOnLostFocus: !0,
					insertMode: !0,
					clearIncomplete: !1,
					alias: null,
					onKeyDown: t.noop,
					onBeforeMask: null,
					onBeforePaste: function (e, n) {
						return t.isFunction(n.onBeforeMask) ? n.onBeforeMask.call(this, e, n) : e
					},
					onBeforeWrite: null,
					onUnMask: null,
					showMaskOnFocus: !0,
					showMaskOnHover: !0,
					onKeyValidation: t.noop,
					skipOptionalPartCharacter: " ",
					numericInput: !1,
					rightAlign: !1,
					undoOnEscape: !0,
					radixPoint: "",
					_radixDance: !1,
					groupSeparator: "",
					keepStatic: null,
					positionCaretOnTab: !0,
					tabThrough: !1,
					supportsInputType: ["text", "tel", "password", "search"],
					ignorables: [8, 9, 13, 19, 27, 33, 34, 35, 36, 37, 38, 39, 40, 45, 46, 93, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 0, 229],
					isComplete: null,
					preValidation: null,
					postValidation: null,
					staticDefinitionSymbol: i,
					jitMasking: !1,
					nullable: !0,
					inputEventOnly: !1,
					noValuePatching: !1,
					positionCaretOnClick: "lvp",
					casing: null,
					inputmode: "verbatim",
					colorMask: !1,
					disablePredictiveText: !1,
					importDataAttributes: !0
				},
				definitions: {
					9: {
						validator: "[0-9\uff11-\uff19]",
						definitionSymbol: "*"
					},
					a: {
						validator: "[A-Za-z\u0410-\u044f\u0401\u0451\xc0-\xff\xb5]",
						definitionSymbol: "*"
					},
					"*": {
						validator: "[0-9\uff11-\uff19A-Za-z\u0410-\u044f\u0401\u0451\xc0-\xff\xb5]"
					}
				},
				aliases: {},
				masksCache: {},
				mask: function (s) {
					var l = this;
					return "string" == typeof s && (s = n.getElementById(s) || n.querySelectorAll(s)), s = s.nodeName ? [s] : s, t.each(s, function (n, s) {
						var c = t.extend(!0, {}, l.opts);
						if (function (n, r, a, s) {
								if (!0 === r.importDataAttributes) {
									var l, u, c, p, d = function (t, r) {
											null !== (r = r !== i ? r : n.getAttribute(s + "-" + t)) && ("string" == typeof r && (0 === t.indexOf("on") ? r = e[r] : "false" === r ? r = !1 : "true" === r && (r = !0)), a[t] = r)
										},
										f = n.getAttribute(s);
									if (f && "" !== f && (f = f.replace(/'/g, '"'), u = JSON.parse("{" + f + "}")), u)
										for (p in c = i, u)
											if ("alias" === p.toLowerCase()) {
												c = u[p];
												break
											}
									for (l in d("alias", c), a.alias && o(a.alias, a, r), r) {
										if (u)
											for (p in c = i, u)
												if (p.toLowerCase() === l.toLowerCase()) {
													c = u[p];
													break
												}
										d(l, c)
									}
								}
								return t.extend(!0, r, a), ("rtl" === n.dir || r.rightAlign) && (n.style.textAlign = "right"), ("rtl" === n.dir || r.numericInput) && (n.dir = "ltr", n.removeAttribute("dir"), r.isRTL = !0), Object.keys(a).length
							}(s, c, t.extend(!0, {}, l.userOptions), l.dataAttribute)) {
							var p = a(c, l.noMasksCache);
							p !== i && (s.inputmask !== i && (s.inputmask.opts.autoUnmask = !0, s.inputmask.remove()), s.inputmask = new r(i, i, !0), s.inputmask.opts = c, s.inputmask.noMasksCache = l.noMasksCache, s.inputmask.userOptions = t.extend(!0, {}, l.userOptions), s.inputmask.isRTL = c.isRTL || c.numericInput, s.inputmask.el = s, s.inputmask.maskset = p, t.data(s, "_inputmask_opts", c), u.call(s.inputmask, {
								action: "mask"
							}))
						}
					}), s && s[0] && s[0].inputmask || this
				},
				option: function (e, n) {
					return "string" == typeof e ? this.opts[e] : "object" === (void 0 === e ? "undefined" : s(e)) ? (t.extend(this.userOptions, e), this.el && !0 !== n && this.mask(this.el), this) : void 0
				},
				unmaskedvalue: function (t) {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "unmaskedvalue",
						value: t
					})
				},
				remove: function () {
					return u.call(this, {
						action: "remove"
					})
				},
				getemptymask: function () {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "getemptymask"
					})
				},
				hasMaskedValue: function () {
					return !this.opts.autoUnmask
				},
				isComplete: function () {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "isComplete"
					})
				},
				getmetadata: function () {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "getmetadata"
					})
				},
				isValid: function (t) {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "isValid",
						value: t
					})
				},
				format: function (t, e) {
					return this.maskset = this.maskset || a(this.opts, this.noMasksCache), u.call(this, {
						action: "format",
						value: t,
						metadata: e
					})
				},
				setValue: function (e) {
					this.el && t(this.el).trigger("setvalue", [e])
				},
				analyseMask: function (e, n, o) {
					function a(t, e, n, i) {
						this.matches = [], this.openGroup = t || !1, this.alternatorGroup = !1, this.isGroup = t || !1, this.isOptional = e || !1, this.isQuantifier = n || !1, this.isAlternator = i || !1, this.quantifier = {
							min: 1,
							max: 1
						}
					}

					function s(e, a, s) {
						s = s !== i ? s : e.matches.length;
						var l = e.matches[s - 1];
						if (n) 0 === a.indexOf("[") || y && /\\d|\\s|\\w]/i.test(a) || "." === a ? e.matches.splice(s++, 0, {
							fn: new RegExp(a, o.casing ? "i" : ""),
							optionality: e.isOptional,
							newBlockMarker: l === i || l.def !== a,
							casing: null,
							def: a,
							placeholder: i,
							nativeDef: a
						}) : (y && (a = a[a.length - 1]), t.each(a.split(""), function (t, n) {
							l = e.matches[s - 1], e.matches.splice(s++, 0, {
								fn: null,
								optionality: e.isOptional,
								newBlockMarker: l === i || l.def !== n && null !== l.fn,
								casing: null,
								def: o.staticDefinitionSymbol || n,
								placeholder: o.staticDefinitionSymbol !== i ? n : i,
								nativeDef: n
							})
						})), y = !1;
						else {
							var u = (o.definitions ? o.definitions[a] : i) || r.prototype.definitions[a];
							u && !y ? e.matches.splice(s++, 0, {
								fn: u.validator ? "string" == typeof u.validator ? new RegExp(u.validator, o.casing ? "i" : "") : new function () {
									this.test = u.validator
								} : new RegExp("."),
								optionality: e.isOptional,
								newBlockMarker: l === i || l.def !== (u.definitionSymbol || a),
								casing: u.casing,
								def: u.definitionSymbol || a,
								placeholder: u.placeholder,
								nativeDef: a
							}) : (e.matches.splice(s++, 0, {
								fn: null,
								optionality: e.isOptional,
								newBlockMarker: l === i || l.def !== a && null !== l.fn,
								casing: null,
								def: o.staticDefinitionSymbol || a,
								placeholder: o.staticDefinitionSymbol !== i ? a : i,
								nativeDef: a
							}), y = !1)
						}
					}

					function l() {
						if (_.length > 0) {
							if (s(f = _[_.length - 1], p), f.isAlternator) {
								h = _.pop();
								for (var t = 0; t < h.matches.length; t++) h.matches[t].isGroup && (h.matches[t].isGroup = !1);
								_.length > 0 ? (f = _[_.length - 1]).matches.push(h) : b.matches.push(h)
							}
						} else s(b, p)
					}

					function u(t) {
						var e = new a(!0);
						return e.openGroup = !1, e.matches = t, e
					}
					var c, p, d, f, h, m, g = /(?:[?*+]|\{[0-9\+\*]+(?:,[0-9\+\*]*)?(?:\|[0-9\+\*]*)?\})|[^.?*+^${[]()|\\]+|./g,
						v = /\[\^?]?(?:[^\\\]]+|\\[\S\s]?)*]?|\\(?:0(?:[0-3][0-7]{0,2}|[4-7][0-7]?)?|[1-9][0-9]*|x[0-9A-Fa-f]{2}|u[0-9A-Fa-f]{4}|c[A-Za-z]|[\S\s]?)|\((?:\?[:=!]?)?|(?:[?*+]|\{[0-9]+(?:,[0-9]*)?\})\??|[^.?*+^${[()|\\]+|./g,
						y = !1,
						b = new a,
						_ = [],
						E = [];
					for (n && (o.optionalmarker[0] = i, o.optionalmarker[1] = i); c = n ? v.exec(e) : g.exec(e);) {
						if (p = c[0], n) switch (p.charAt(0)) {
							case "?":
								p = "{0,1}";
								break;
							case "+":
							case "*":
								p = "{" + p + "}"
						}
						if (y) l();
						else switch (p.charAt(0)) {
							case o.escapeChar:
								y = !0, n && l();
								break;
							case o.optionalmarker[1]:
							case o.groupmarker[1]:
								if ((d = _.pop()).openGroup = !1, d !== i)
									if (_.length > 0) {
										if ((f = _[_.length - 1]).matches.push(d), f.isAlternator) {
											h = _.pop();
											for (var k = 0; k < h.matches.length; k++) h.matches[k].isGroup = !1, h.matches[k].alternatorGroup = !1;
											_.length > 0 ? (f = _[_.length - 1]).matches.push(h) : b.matches.push(h)
										}
									} else b.matches.push(d);
								else l();
								break;
							case o.optionalmarker[0]:
								_.push(new a(!1, !0));
								break;
							case o.groupmarker[0]:
								_.push(new a(!0));
								break;
							case o.quantifiermarker[0]:
								var w = new a(!1, !1, !0),
									C = (p = p.replace(/[{}]/g, "")).split("|"),
									x = C[0].split(","),
									S = isNaN(x[0]) ? x[0] : parseInt(x[0]),
									T = 1 === x.length ? S : isNaN(x[1]) ? x[1] : parseInt(x[1]);
								"*" !== T && "+" !== T || (S = "*" === T ? 0 : 1), w.quantifier = {
									min: S,
									max: T,
									jit: C[1]
								};
								var A = _.length > 0 ? _[_.length - 1].matches : b.matches;
								if ((c = A.pop()).isAlternator) {
									A.push(c), A = c.matches;
									var D = new a(!0),
										O = A.pop();
									A.push(D), A = D.matches, c = O
								}
								c.isGroup || (n && null === c.fn && "." === c.def && (c.fn = new RegExp(c.def, o.casing ? "i" : "")), c = u([c])), A.push(c), A.push(w);
								break;
							case o.alternatormarker:
								var N = function (t) {
									var e = t.pop();
									return e.isQuantifier && (e = u([t.pop(), e])), e
								};
								if (_.length > 0) {
									var I = (f = _[_.length - 1]).matches[f.matches.length - 1];
									m = f.openGroup && (I.matches === i || !1 === I.isGroup && !1 === I.isAlternator) ? _.pop() : N(f.matches)
								} else m = N(b.matches);
								if (m.isAlternator) _.push(m);
								else if (m.alternatorGroup ? (h = _.pop(), m.alternatorGroup = !1) : h = new a(!1, !1, !1, !0), h.matches.push(m), _.push(h), m.openGroup) {
									m.openGroup = !1;
									var P = new a(!0);
									P.alternatorGroup = !0, _.push(P)
								}
								break;
							default:
								l()
						}
					}
					for (; _.length > 0;) d = _.pop(), b.matches.push(d);
					return b.matches.length > 0 && (function e(r) {
						r && r.matches && t.each(r.matches, function (t, a) {
							var l = r.matches[t + 1];
							(l === i || l.matches === i || !1 === l.isQuantifier) && a && a.isGroup && (a.isGroup = !1, n || (s(a, o.groupmarker[0], 0), !0 !== a.openGroup && s(a, o.groupmarker[1]))), e(a)
						})
					}(b), E.push(b)), (o.numericInput || o.isRTL) && function t(e) {
						for (var n in e.matches = e.matches.reverse(), e.matches)
							if (e.matches.hasOwnProperty(n)) {
								var r = parseInt(n);
								if (e.matches[n].isQuantifier && e.matches[r + 1] && e.matches[r + 1].isGroup) {
									var a = e.matches[n];
									e.matches.splice(n, 1), e.matches.splice(r + 1, 0, a)
								}
								e.matches[n].matches !== i ? e.matches[n] = t(e.matches[n]) : e.matches[n] = ((s = e.matches[n]) === o.optionalmarker[0] ? s = o.optionalmarker[1] : s === o.optionalmarker[1] ? s = o.optionalmarker[0] : s === o.groupmarker[0] ? s = o.groupmarker[1] : s === o.groupmarker[1] && (s = o.groupmarker[0]), s)
							}
						var s;
						return e
					}(E[0]), E
				}
			}, r.extendDefaults = function (e) {
				t.extend(!0, r.prototype.defaults, e)
			}, r.extendDefinitions = function (e) {
				t.extend(!0, r.prototype.definitions, e)
			}, r.extendAliases = function (e) {
				t.extend(!0, r.prototype.aliases, e)
			}, r.format = function (t, e, n) {
				return r(e).format(t, n)
			}, r.unmask = function (t, e) {
				return r(e).unmaskedvalue(t)
			}, r.isValid = function (t, e) {
				return r(e).isValid(t)
			}, r.remove = function (e) {
				"string" == typeof e && (e = n.getElementById(e) || n.querySelectorAll(e)), e = e.nodeName ? [e] : e, t.each(e, function (t, e) {
					e.inputmask && e.inputmask.remove()
				})
			}, r.setValue = function (e, i) {
				"string" == typeof e && (e = n.getElementById(e) || n.querySelectorAll(e)), e = e.nodeName ? [e] : e, t.each(e, function (e, n) {
					n.inputmask ? n.inputmask.setValue(i) : t(n).trigger("setvalue", [i])
				})
			}, r.escapeRegex = function (t) {
				return t.replace(new RegExp("(\\" + ["/", ".", "*", "+", "?", "|", "(", ")", "[", "]", "{", "}", "\\", "$", "^"].join("|\\") + ")", "gim"), "\\$1")
			}, r.keyCode = {
				BACKSPACE: 8,
				BACKSPACE_SAFARI: 127,
				DELETE: 46,
				DOWN: 40,
				END: 35,
				ENTER: 13,
				ESCAPE: 27,
				HOME: 36,
				INSERT: 45,
				LEFT: 37,
				PAGE_DOWN: 34,
				PAGE_UP: 33,
				RIGHT: 39,
				SPACE: 32,
				TAB: 9,
				UP: 38,
				X: 88,
				CONTROL: 17
			}, r
		}, r = [n(0), n(5), n(6)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t) {
		t.exports = jQuery
	}, function (t, e, n) {
		"use strict";

		function i(t) {
			return t && t.__esModule ? t : {
				"default": t
			}
		}
		n(4), n(7), n(8), n(9);
		var r = i(n(1)),
			o = i(n(0)),
			a = i(n(2));
		o["default"] === a["default"] && n(10), window.Inputmask = r["default"]
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a;
		"function" == typeof Symbol && Symbol.iterator, a = function (t, e) {
			function n(t) {
				if (!t.tokenizer) {
					var e = [];
					for (var n in a) - 1 === e.indexOf(n[0]) && e.push(n[0]);
					t.tokenizer = "(" + e.join("+|") + ")+?|.", t.tokenizer = new RegExp(t.tokenizer, "g")
				}
				return t.tokenizer
			}

			function i(t, i, r) {
				for (var o, s = ""; o = n(r).exec(t);) void 0 === i ? s += a[o[0]] ? "(" + a[o[0]][0] + ")" : e.escapeRegex(o[0]) : a[o[0]] ? s += a[o[0]][3].call(i.date) : s += o[0];
				return s
			}

			function r(t, e) {
				for (t = String(t), e = e || 2; t.length < e;) t = "0" + t;
				return t
			}

			function o(t, e, i) {
				function r(t) {
					var e = 4 === t.length ? t : (new Date).getFullYear().toString().substr(0, 4 - t.length) + t;
					return i.min && i.min.year && i.max && i.max.year ? (e = e.replace(/[^0-9]/g, ""), e += i.min.year == i.max.year ? i.min.year.substr(e.length) : ("" !== e && 0 == i.max.year.indexOf(e) ? parseInt(i.max.year) - 1 : parseInt(i.min.year) + 1).toString().substr(e.length)) : e = e.replace(/[^0-9]/g, "0"), e
				}

				function o(t, e, n) {
					"year" === s ? (t[s] = r(e), t["raw" + s] = e) : t[s] = n.min && e.match(/[^0-9]/) ? n.min[s] : e, void 0 !== u && u.call(t.date, "month" == s ? parseInt(t[s]) - 1 : t[s])
				}
				var s, l, u, c = {
						date: new Date(1, 0, 1)
					},
					p = t;
				if ("string" == typeof p) {
					for (; l = n(i).exec(e);) {
						var d = p.slice(0, l[0].length);
						a.hasOwnProperty(l[0]) && (s = a[l[0]][2], u = a[l[0]][1], o(c, d, i)), p = p.slice(d.length)
					}
					return c
				}
			}
			var a = {
					d: ["[1-9]|[12][0-9]|3[01]", Date.prototype.setDate, "day", Date.prototype.getDate],
					dd: ["0[1-9]|[12][0-9]|3[01]", Date.prototype.setDate, "day", function () {
						return r(Date.prototype.getDate.call(this), 2)
					}],
					ddd: [""],
					dddd: [""],
					m: ["[1-9]|1[012]", Date.prototype.setMonth, "month", function () {
						return Date.prototype.getMonth.call(this) + 1
					}],
					mm: ["0[1-9]|1[012]", Date.prototype.setMonth, "month", function () {
						return r(Date.prototype.getMonth.call(this) + 1, 2)
					}],
					mmm: [""],
					mmmm: [""],
					yy: ["[0-9]{2}", Date.prototype.setFullYear, "year", function () {
						return r(Date.prototype.getFullYear.call(this), 2)
					}],
					yyyy: ["[0-9]{4}", Date.prototype.setFullYear, "year", function () {
						return r(Date.prototype.getFullYear.call(this), 4)
					}],
					h: ["[1-9]|1[0-2]", Date.prototype.setHours, "hours", Date.prototype.getHours],
					hh: ["0[1-9]|1[0-2]", Date.prototype.setHours, "hours", function () {
						return r(Date.prototype.getHours.call(this), 2)
					}],
					hhh: ["[0-9]+", Date.prototype.setHours, "hours", Date.prototype.getHours],
					H: ["1?[0-9]|2[0-3]", Date.prototype.setHours, "hours", Date.prototype.getHours],
					HH: ["[01][0-9]|2[0-3]", Date.prototype.setHours, "hours", function () {
						return r(Date.prototype.getHours.call(this), 2)
					}],
					HHH: ["[0-9]+", Date.prototype.setHours, "hours", Date.prototype.getHours],
					M: ["[1-5]?[0-9]", Date.prototype.setMinutes, "minutes", Date.prototype.getMinutes],
					MM: ["[0-5][0-9]", Date.prototype.setMinutes, "minutes", function () {
						return r(Date.prototype.getMinutes.call(this), 2)
					}],
					s: ["[1-5]?[0-9]", Date.prototype.setSeconds, "seconds", Date.prototype.getSeconds],
					ss: ["[0-5][0-9]", Date.prototype.setSeconds, "seconds", function () {
						return r(Date.prototype.getSeconds.call(this), 2)
					}],
					l: ["[0-9]{3}", Date.prototype.setMilliseconds, "milliseconds", function () {
						return r(Date.prototype.getMilliseconds.call(this), 3)
					}],
					L: ["[0-9]{2}", Date.prototype.setMilliseconds, "milliseconds", function () {
						return r(Date.prototype.getMilliseconds.call(this), 2)
					}],
					t: ["[ap]"],
					tt: ["[ap]m"],
					T: ["[AP]"],
					TT: ["[AP]M"],
					Z: [""],
					o: [""],
					S: [""]
				},
				s = {
					isoDate: "yyyy-mm-dd",
					isoTime: "HH:MM:ss",
					isoDateTime: "yyyy-mm-dd'T'HH:MM:ss",
					isoUtcDateTime: "UTC:yyyy-mm-dd'T'HH:MM:ss'Z'"
				};
			return e.extendAliases({
				datetime: {
					mask: function (t) {
						return a.S = t.i18n.ordinalSuffix.join("|"), t.inputFormat = s[t.inputFormat] || t.inputFormat, t.displayFormat = s[t.displayFormat] || t.displayFormat || t.inputFormat, t.outputFormat = s[t.outputFormat] || t.outputFormat || t.inputFormat, t.placeholder = "" !== t.placeholder ? t.placeholder : t.inputFormat, t.min = o(t.min, t.inputFormat, t), t.max = o(t.max, t.inputFormat, t), t.regex = i(t.inputFormat, void 0, t), null
					},
					placeholder: "",
					inputFormat: "isoDateTime",
					displayFormat: void 0,
					outputFormat: void 0,
					min: null,
					max: null,
					i18n: {
						dayNames: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
						monthNames: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
						ordinalSuffix: ["st", "nd", "rd", "th"]
					},
					postValidation: function (t, e, n) {
						var i = e,
							r = o(t.join(""), n.inputFormat, n);
						return i && r.date.getTime() == r.date.getTime() && (i = (i = function (t, e) {
							return (!isFinite(t.day) || "29" == t.day && !isFinite(t.rawyear) || new Date(t.date.getFullYear(), isFinite(t.month) ? t.month : t.date.getMonth() + 1, 0).getDate() >= t.day) && e
						}(r, i)) && function (t, e) {
							var n = !0;
							return e.min && e.min.date.getTime() == e.min.date.getTime() && (n = e.min.date.getTime() <= t.date.getTime()), n && e.max && e.max.date.getTime() == e.max.date.getTime() && (n = e.max.date.getTime() >= t.date.getTime()), n
						}(r, n)), i
					},
					onKeyDown: function (i, o, a, s) {
						if (i.ctrlKey && i.keyCode === e.keyCode.RIGHT) {
							for (var l, u = new Date, c = ""; l = n(s).exec(s.inputFormat);) "d" === l[0].charAt(0) ? c += r(u.getDate(), l[0].length) : "m" === l[0].charAt(0) ? c += r(u.getMonth() + 1, l[0].length) : "yyyy" === l[0] ? c += u.getFullYear().toString() : "y" === l[0].charAt(0) && (c += r(u.getYear(), l[0].length));
							this.inputmask._valueSet(c), t(this).trigger("setvalue")
						}
					},
					onUnMask: function (t, e, n) {
						return i(n.outputFormat, o(t, n.inputFormat, n), n)
					},
					casing: function (t, e) {
						return 0 == e.nativeDef.indexOf("[ap]") ? t.toLowerCase() : 0 == e.nativeDef.indexOf("[AP]") ? t.toUpperCase() : t
					},
					insertMode: !1
				}
			}), e
		}, r = [n(0), n(1)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t, e, n) {
		"use strict";
		var i;
		"function" == typeof Symbol && Symbol.iterator, void 0 === (i = function () {
			return window
		}.call(e, n, e, t)) || (t.exports = i)
	}, function (t, e, n) {
		"use strict";
		var i;
		"function" == typeof Symbol && Symbol.iterator, void 0 === (i = function () {
			return document
		}.call(e, n, e, t)) || (t.exports = i)
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a;
		"function" == typeof Symbol && Symbol.iterator, a = function (t, e) {
			return e.extendDefinitions({
				A: {
					validator: "[A-Za-z\u0410-\u044f\u0401\u0451\xc0-\xff\xb5]",
					casing: "upper"
				},
				"&": {
					validator: "[0-9A-Za-z\u0410-\u044f\u0401\u0451\xc0-\xff\xb5]",
					casing: "upper"
				},
				"#": {
					validator: "[0-9A-Fa-f]",
					casing: "upper"
				}
			}), e.extendAliases({
				cssunit: {
					regex: "[+-]?[0-9]+.?([0-9]+)?(px|em|rem|ex|%|in|cm|mm|pt|pc)"
				},
				url: {
					regex: "(https?|ftp)//.*",
					autoUnmask: !1
				},
				ip: {
					mask: "i[i[i]].i[i[i]].i[i[i]].i[i[i]]",
					definitions: {
						i: {
							validator: function (t, e, n) {
								return n - 1 > -1 && "." !== e.buffer[n - 1] ? (t = e.buffer[n - 1] + t, t = n - 2 > -1 && "." !== e.buffer[n - 2] ? e.buffer[n - 2] + t : "0" + t) : t = "00" + t, new RegExp("25[0-5]|2[0-4][0-9]|[01][0-9][0-9]").test(t)
							}
						}
					},
					onUnMask: function (t) {
						return t
					},
					inputmode: "numeric"
				},
				email: {
					mask: "*{1,64}[.*{1,64}][.*{1,64}][.*{1,63}]@-{1,63}.-{1,63}[.-{1,63}][.-{1,63}]",
					greedy: !1,
					casing: "lower",
					onBeforePaste: function (t) {
						return (t = t.toLowerCase()).replace("mailto:", "")
					},
					definitions: {
						"*": {
							validator: "[0-9\uff11-\uff19A-Za-z\u0410-\u044f\u0401\u0451\xc0-\xff\xb5!#$%&'*+/=?^_`{|}~-]"
						},
						"-": {
							validator: "[0-9A-Za-z-]"
						}
					},
					onUnMask: function (t) {
						return t
					},
					inputmode: "email"
				},
				mac: {
					mask: "##:##:##:##:##:##"
				},
				vin: {
					mask: "V{13}9{4}",
					definitions: {
						V: {
							validator: "[A-HJ-NPR-Za-hj-npr-z\\d]",
							casing: "upper"
						}
					},
					clearIncomplete: !0,
					autoUnmask: !0
				}
			}), e
		}, r = [n(0), n(1)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a;
		"function" == typeof Symbol && Symbol.iterator, a = function (t, e, n) {
			function i(t, n) {
				for (var i = "", r = 0; r < t.length; r++) e.prototype.definitions[t.charAt(r)] || n.definitions[t.charAt(r)] || n.optionalmarker.start === t.charAt(r) || n.optionalmarker.end === t.charAt(r) || n.quantifiermarker.start === t.charAt(r) || n.quantifiermarker.end === t.charAt(r) || n.groupmarker.start === t.charAt(r) || n.groupmarker.end === t.charAt(r) || n.alternatormarker === t.charAt(r) ? i += "\\" + t.charAt(r) : i += t.charAt(r);
				return i
			}
			return e.extendAliases({
				numeric: {
					mask: function (t) {
						if (0 !== t.repeat && isNaN(t.integerDigits) && (t.integerDigits = t.repeat), t.repeat = 0, t.groupSeparator === t.radixPoint && t.digits && "0" !== t.digits && ("." === t.radixPoint ? t.groupSeparator = "," : "," === t.radixPoint ? t.groupSeparator = "." : t.groupSeparator = ""), " " === t.groupSeparator && (t.skipOptionalPartCharacter = n), t.autoGroup = t.autoGroup && "" !== t.groupSeparator, t.autoGroup && ("string" == typeof t.groupSize && isFinite(t.groupSize) && (t.groupSize = parseInt(t.groupSize)), isFinite(t.integerDigits))) {
							var e = Math.floor(t.integerDigits / t.groupSize),
								r = t.integerDigits % t.groupSize;
							t.integerDigits = parseInt(t.integerDigits) + (0 === r ? e - 1 : e), t.integerDigits < 1 && (t.integerDigits = "*")
						}
						t.placeholder.length > 1 && (t.placeholder = t.placeholder.charAt(0)), "radixFocus" === t.positionCaretOnClick && "" === t.placeholder && !1 === t.integerOptional && (t.positionCaretOnClick = "lvp"), t.definitions[";"] = t.definitions["~"], t.definitions[";"].definitionSymbol = "~", !0 === t.numericInput && (t.positionCaretOnClick = "radixFocus" === t.positionCaretOnClick ? "lvp" : t.positionCaretOnClick, t.digitsOptional = !1, isNaN(t.digits) && (t.digits = 2), t.decimalProtect = !1);
						var o = "[+]";
						if (o += i(t.prefix, t), !0 === t.integerOptional ? o += "~{1," + t.integerDigits + "}" : o += "~{" + t.integerDigits + "}", t.digits !== n) {
							var a = t.decimalProtect ? ":" : t.radixPoint,
								s = t.digits.toString().split(",");
							isFinite(s[0]) && s[1] && isFinite(s[1]) ? o += a + ";{" + t.digits + "}" : (isNaN(t.digits) || parseInt(t.digits) > 0) && (t.digitsOptional ? o += "[" + a + ";{1," + t.digits + "}]" : o += a + ";{" + t.digits + "}")
						}
						return o += i(t.suffix, t), o += "[-]", t.greedy = !1, o
					},
					placeholder: "",
					greedy: !1,
					digits: "*",
					digitsOptional: !0,
					enforceDigitsOnBlur: !1,
					radixPoint: ".",
					positionCaretOnClick: "radixFocus",
					groupSize: 3,
					groupSeparator: "",
					autoGroup: !1,
					allowMinus: !0,
					negationSymbol: {
						front: "-",
						back: ""
					},
					integerDigits: "+",
					integerOptional: !0,
					prefix: "",
					suffix: "",
					rightAlign: !0,
					decimalProtect: !0,
					min: null,
					max: null,
					step: 1,
					insertMode: !0,
					autoUnmask: !1,
					unmaskAsNumber: !1,
					inputmode: "numeric",
					preValidation: function (e, i, r, o, a, s) {
						if ("-" === r || r === a.negationSymbol.front) return !0 === a.allowMinus && (a.isNegative = a.isNegative === n || !a.isNegative, "" === e.join("") || {
							caret: i,
							dopost: !0
						});
						if (!1 === o && r === a.radixPoint && a.digits !== n && (isNaN(a.digits) || parseInt(a.digits) > 0)) {
							var l = t.inArray(a.radixPoint, e);
							if (-1 !== l && s.validPositions[l] !== n) return !0 === a.numericInput ? i === l : {
								caret: l + 1
							}
						}
						return !0
					},
					postValidation: function (i, r, o) {
						var a = o.suffix.split(""),
							s = o.prefix.split("");
						if (r.pos === n && r.caret !== n && !0 !== r.dopost) return r;
						var l = r.caret !== n ? r.caret : r.pos,
							u = i.slice();
						o.numericInput && (l = u.length - l - 1, u = u.reverse());
						var c = u[l];
						if (c === o.groupSeparator && (c = u[l += 1]), l === u.length - o.suffix.length - 1 && c === o.radixPoint) return r;
						c !== n && c !== o.radixPoint && c !== o.negationSymbol.front && c !== o.negationSymbol.back && (u[l] = "?", o.prefix.length > 0 && l >= (!1 === o.isNegative ? 1 : 0) && l < o.prefix.length - 1 + (!1 === o.isNegative ? 1 : 0) ? s[l - (!1 === o.isNegative ? 1 : 0)] = "?" : o.suffix.length > 0 && l >= u.length - o.suffix.length - (!1 === o.isNegative ? 1 : 0) && (a[l - (u.length - o.suffix.length - (!1 === o.isNegative ? 1 : 0))] = "?")), s = s.join(""), a = a.join("");
						var p = u.join("").replace(s, "");
						if (p = (p = (p = (p = p.replace(a, "")).replace(new RegExp(e.escapeRegex(o.groupSeparator), "g"), "")).replace(new RegExp("[-" + e.escapeRegex(o.negationSymbol.front) + "]", "g"), "")).replace(new RegExp(e.escapeRegex(o.negationSymbol.back) + "$"), ""), isNaN(o.placeholder) && (p = p.replace(new RegExp(e.escapeRegex(o.placeholder), "g"), "")), p.length > 1 && 1 !== p.indexOf(o.radixPoint) && ("0" === c && (p = p.replace(/^\?/g, "")), p = p.replace(/^0/g, "")), p.charAt(0) === o.radixPoint && "" !== o.radixPoint && !0 !== o.numericInput && (p = "0" + p), "" !== p) {
							if (p = p.split(""), (!o.digitsOptional || o.enforceDigitsOnBlur && "blur" === r.event) && isFinite(o.digits)) {
								var d = t.inArray(o.radixPoint, p),
									f = t.inArray(o.radixPoint, u); - 1 === d && (p.push(o.radixPoint), d = p.length - 1);
								for (var h = 1; h <= o.digits; h++) o.digitsOptional && (!o.enforceDigitsOnBlur || "blur" !== r.event) || p[d + h] !== n && p[d + h] !== o.placeholder.charAt(0) ? -1 !== f && u[f + h] !== n && (p[d + h] = p[d + h] || u[f + h]) : p[d + h] = r.placeholder || o.placeholder.charAt(0)
							}
							if (!0 !== o.autoGroup || "" === o.groupSeparator || c === o.radixPoint && r.pos === n && !r.dopost) p = p.join("");
							else {
								var m = p[p.length - 1] === o.radixPoint && r.c === o.radixPoint;
								p = e(function (t, e) {
									var n = "";
									if (n += "(" + e.groupSeparator + "*{" + e.groupSize + "}){*}", "" !== e.radixPoint) {
										var i = t.join("").split(e.radixPoint);
										i[1] && (n += e.radixPoint + "*{" + i[1].match(/^\d*\??\d*/)[0].length + "}")
									}
									return n
								}(p, o), {
									numericInput: !0,
									jitMasking: !0,
									definitions: {
										"*": {
											validator: "[0-9?]",
											cardinality: 1
										}
									}
								}).format(p.join("")), m && (p += o.radixPoint), p.charAt(0) === o.groupSeparator && p.substr(1)
							}
						}
						if (o.isNegative && "blur" === r.event && (o.isNegative = "0" !== p), p = s + p, p += a, o.isNegative && (p = o.negationSymbol.front + p, p += o.negationSymbol.back), p = p.split(""), c !== n)
							if (c !== o.radixPoint && c !== o.negationSymbol.front && c !== o.negationSymbol.back)(l = t.inArray("?", p)) > -1 ? p[l] = c : l = r.caret || 0;
							else if (c === o.radixPoint || c === o.negationSymbol.front || c === o.negationSymbol.back) {
							var g = t.inArray(c, p); - 1 !== g && (l = g)
						}
						o.numericInput && (l = p.length - l - 1, p = p.reverse());
						var v = {
							caret: c === n || r.pos !== n ? l + (o.numericInput ? -1 : 1) : l,
							buffer: p,
							refreshFromBuffer: r.dopost || i.join("") !== p.join("")
						};
						return v.refreshFromBuffer ? v : r
					},
					onBeforeWrite: function (i, r, o, a) {
						if (i) switch (i.type) {
							case "keydown":
								return a.postValidation(r, {
									caret: o,
									dopost: !0
								}, a);
							case "blur":
							case "checkval":
								var s;
								if (function (t) {
										t.parseMinMaxOptions === n && (null !== t.min && (t.min = t.min.toString().replace(new RegExp(e.escapeRegex(t.groupSeparator), "g"), ""), "," === t.radixPoint && (t.min = t.min.replace(t.radixPoint, ".")), t.min = isFinite(t.min) ? parseFloat(t.min) : NaN, isNaN(t.min) && (t.min = Number.MIN_VALUE)), null !== t.max && (t.max = t.max.toString().replace(new RegExp(e.escapeRegex(t.groupSeparator), "g"), ""), "," === t.radixPoint && (t.max = t.max.replace(t.radixPoint, ".")), t.max = isFinite(t.max) ? parseFloat(t.max) : NaN, isNaN(t.max) && (t.max = Number.MAX_VALUE)), t.parseMinMaxOptions = "done")
									}(a), null !== a.min || null !== a.max) {
									if (s = a.onUnMask(r.join(""), n, t.extend({}, a, {
											unmaskAsNumber: !0
										})), null !== a.min && s < a.min) return a.isNegative = a.min < 0, a.postValidation(a.min.toString().replace(".", a.radixPoint).split(""), {
										caret: o,
										dopost: !0,
										placeholder: "0"
									}, a);
									if (null !== a.max && s > a.max) return a.isNegative = a.max < 0, a.postValidation(a.max.toString().replace(".", a.radixPoint).split(""), {
										caret: o,
										dopost: !0,
										placeholder: "0"
									}, a)
								}
								return a.postValidation(r, {
									caret: o,
									placeholder: "0",
									event: "blur"
								}, a);
							case "_checkval":
								return {
									caret: o
								}
						}
					},
					regex: {
						integerPart: function (t, n) {
							return n ? new RegExp("[" + e.escapeRegex(t.negationSymbol.front) + "+]?") : new RegExp("[" + e.escapeRegex(t.negationSymbol.front) + "+]?\\d+")
						},
						integerNPart: function (t) {
							return new RegExp("[\\d" + e.escapeRegex(t.groupSeparator) + e.escapeRegex(t.placeholder.charAt(0)) + "]+")
						}
					},
					definitions: {
						"~": {
							validator: function (t, i, r, o, a, s) {
								var l;
								if ("k" === t || "m" === t) {
									l = {
										insert: [],
										c: 0
									};
									for (var u = 0, c = "k" === t ? 2 : 5; u < c; u++) l.insert.push({
										pos: r + u,
										c: 0
									});
									return l.pos = r + c, l
								}
								if (!0 === (l = o ? new RegExp("[0-9" + e.escapeRegex(a.groupSeparator) + "]").test(t) : new RegExp("[0-9]").test(t))) {
									if (!0 !== a.numericInput && i.validPositions[r] !== n && "~" === i.validPositions[r].match.def && !s) {
										var p = i.buffer.join(""),
											d = (p = (p = p.replace(new RegExp("[-" + e.escapeRegex(a.negationSymbol.front) + "]", "g"), "")).replace(new RegExp(e.escapeRegex(a.negationSymbol.back) + "$"), "")).split(a.radixPoint);
										d.length > 1 && (d[1] = d[1].replace(/0/g, a.placeholder.charAt(0))), "0" === d[0] && (d[0] = d[0].replace(/0/g, a.placeholder.charAt(0))), p = d[0] + a.radixPoint + d[1] || "";
										var f = i._buffer.join("");
										for (p === a.radixPoint && (p = f); null === p.match(e.escapeRegex(f) + "$");) f = f.slice(1);
										l = (p = (p = p.replace(f, "")).split(""))[r] === n ? {
											pos: r,
											remove: r
										} : {
											pos: r
										}
									}
								} else o || t !== a.radixPoint || i.validPositions[r - 1] !== n || (l = {
									insert: {
										pos: r,
										c: 0
									},
									pos: r + 1
								});
								return l
							},
							cardinality: 1
						},
						"+": {
							validator: function (t, e, n, i, r) {
								return r.allowMinus && ("-" === t || t === r.negationSymbol.front)
							},
							cardinality: 1,
							placeholder: ""
						},
						"-": {
							validator: function (t, e, n, i, r) {
								return r.allowMinus && t === r.negationSymbol.back
							},
							cardinality: 1,
							placeholder: ""
						},
						":": {
							validator: function (t, n, i, r, o) {
								var a = "[" + e.escapeRegex(o.radixPoint) + "]",
									s = new RegExp(a).test(t);
								return s && n.validPositions[i] && n.validPositions[i].match.placeholder === o.radixPoint && (s = {
									caret: i + 1
								}), s
							},
							cardinality: 1,
							placeholder: function (t) {
								return t.radixPoint
							}
						}
					},
					onUnMask: function (t, n, i) {
						if ("" === n && !0 === i.nullable) return n;
						var r = t.replace(i.prefix, "");
						return r = (r = r.replace(i.suffix, "")).replace(new RegExp(e.escapeRegex(i.groupSeparator), "g"), ""), "" !== i.placeholder.charAt(0) && (r = r.replace(new RegExp(i.placeholder.charAt(0), "g"), "0")), i.unmaskAsNumber ? ("" !== i.radixPoint && -1 !== r.indexOf(i.radixPoint) && (r = r.replace(e.escapeRegex.call(this, i.radixPoint), ".")), r = (r = r.replace(new RegExp("^" + e.escapeRegex(i.negationSymbol.front)), "-")).replace(new RegExp(e.escapeRegex(i.negationSymbol.back) + "$"), ""), Number(r)) : r
					},
					isComplete: function (t, n) {
						var i = t.join("");
						if (t.slice().join("") !== i) return !1;
						var r = i.replace(new RegExp("^" + e.escapeRegex(n.negationSymbol.front)), "-");
						return r = (r = (r = (r = r.replace(new RegExp(e.escapeRegex(n.negationSymbol.back) + "$"), "")).replace(n.prefix, "")).replace(n.suffix, "")).replace(new RegExp(e.escapeRegex(n.groupSeparator) + "([0-9]{3})", "g"), "$1"), "," === n.radixPoint && (r = r.replace(e.escapeRegex(n.radixPoint), ".")), isFinite(r)
					},
					onBeforeMask: function (t, i) {
						if (i.isNegative = n, "number" == typeof t && "" !== i.radixPoint && (t = t.toString().replace(".", i.radixPoint)), t = t.toString().charAt(t.length - 1) === i.radixPoint ? t.toString().substr(0, t.length - 1) : t.toString(), "" !== i.radixPoint && isFinite(t)) {
							var r = t.split("."),
								o = "" !== i.groupSeparator ? parseInt(i.groupSize) : 0;
							2 === r.length && (r[0].length > o || r[1].length > o || r[0].length <= o && r[1].length < o) && (t = t.replace(".", i.radixPoint))
						}
						var a = t.match(/,/g),
							s = t.match(/\./g);
						if (t = s && a ? s.length > a.length ? (t = t.replace(/\./g, "")).replace(",", i.radixPoint) : a.length > s.length ? (t = t.replace(/,/g, "")).replace(".", i.radixPoint) : t.indexOf(".") < t.indexOf(",") ? t.replace(/\./g, "") : t.replace(/,/g, "") : t.replace(new RegExp(e.escapeRegex(i.groupSeparator), "g"), ""), 0 === i.digits && (-1 !== t.indexOf(".") ? t = t.substring(0, t.indexOf(".")) : -1 !== t.indexOf(",") && (t = t.substring(0, t.indexOf(",")))), "" !== i.radixPoint && isFinite(i.digits) && -1 !== t.indexOf(i.radixPoint)) {
							var l = t.split(i.radixPoint)[1].match(new RegExp("\\d*"))[0];
							if (parseInt(i.digits) < l.toString().length) {
								var u = Math.pow(10, parseInt(i.digits));
								t = t.replace(e.escapeRegex(i.radixPoint), "."), t = (t = Math.round(parseFloat(t) * u) / u).toString().replace(".", i.radixPoint)
							}
						}
						return t
					},
					onKeyDown: function (n, i, r, o) {
						var a = t(this);
						if (n.ctrlKey) switch (n.keyCode) {
							case e.keyCode.UP:
								a.val(parseFloat(this.inputmask.unmaskedvalue()) + parseInt(o.step)), a.trigger("setvalue");
								break;
							case e.keyCode.DOWN:
								a.val(parseFloat(this.inputmask.unmaskedvalue()) - parseInt(o.step)), a.trigger("setvalue")
						}
					}
				},
				currency: {
					prefix: "$ ",
					groupSeparator: ",",
					alias: "numeric",
					placeholder: "0",
					autoGroup: !0,
					digits: 2,
					digitsOptional: !1,
					clearMaskOnLostFocus: !1
				},
				decimal: {
					alias: "numeric"
				},
				integer: {
					alias: "numeric",
					digits: 0,
					radixPoint: ""
				},
				percentage: {
					alias: "numeric",
					digits: 2,
					digitsOptional: !0,
					radixPoint: ".",
					placeholder: "0",
					autoGroup: !1,
					min: 0,
					max: 100,
					suffix: " %",
					allowMinus: !1
				}
			}), e
		}, r = [n(0), n(1)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a;
		"function" == typeof Symbol && Symbol.iterator, a = function (t, e) {
			function n(t, e) {
				var n = (t.mask || t).replace(/#/g, "0").replace(/\)/, "0").replace(/[+()#-]/g, ""),
					i = (e.mask || e).replace(/#/g, "0").replace(/\)/, "0").replace(/[+()#-]/g, "");
				return n.localeCompare(i)
			}
			var i = e.prototype.analyseMask;
			return e.prototype.analyseMask = function (e, n, r) {
				var o = {};
				return r.phoneCodes && (r.phoneCodes && r.phoneCodes.length > 1e3 && (function t(n, i, r) {
					i = i || "", r = r || o, "" !== i && (r[i] = {});
					for (var a = "", s = r[i] || r, l = n.length - 1; l >= 0; l--) s[a = (e = n[l].mask || n[l]).substr(0, 1)] = s[a] || [], s[a].unshift(e.substr(1)), n.splice(l, 1);
					for (var u in s) s[u].length > 500 && t(s[u].slice(), u, s)
				}((e = e.substr(1, e.length - 2)).split(r.groupmarker[1] + r.alternatormarker + r.groupmarker[0])), e = function e(n) {
					var i = "",
						o = [];
					for (var a in n) t.isArray(n[a]) ? 1 === n[a].length ? o.push(a + n[a]) : o.push(a + r.groupmarker[0] + n[a].join(r.groupmarker[1] + r.alternatormarker + r.groupmarker[0]) + r.groupmarker[1]) : o.push(a + e(n[a]));
					return 1 === o.length ? i += o[0] : i += r.groupmarker[0] + o.join(r.groupmarker[1] + r.alternatormarker + r.groupmarker[0]) + r.groupmarker[1], i
				}(o)), e = e.replace(/9/g, "\\9")), i.call(this, e, n, r)
			}, e.extendAliases({
				abstractphone: {
					groupmarker: ["<", ">"],
					countrycode: "",
					phoneCodes: [],
					keepStatic: "auto",
					mask: function (t) {
						return t.definitions = {
							"#": e.prototype.definitions[9]
						}, t.phoneCodes.sort(n)
					},
					onBeforeMask: function (t, e) {
						var n = t.replace(/^0{1,2}/, "").replace(/[\s]/g, "");
						return (n.indexOf(e.countrycode) > 1 || -1 === n.indexOf(e.countrycode)) && (n = "+" + e.countrycode + n), n
					},
					onUnMask: function (t) {
						return t.replace(/[()#-]/g, "")
					},
					inputmode: "tel"
				}
			}), e
		}, r = [n(0), n(1)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}, function (t, e, n) {
		"use strict";
		var i, r, o, a, s = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (t) {
			return typeof t
		} : function (t) {
			return t && "function" == typeof Symbol && t.constructor === Symbol && t !== Symbol.prototype ? "symbol" : typeof t
		};
		a = function (t, e) {
			return void 0 === t.fn.inputmask && (t.fn.inputmask = function (n, i) {
				var r, o = this[0];
				if (void 0 === i && (i = {}), "string" == typeof n) switch (n) {
					case "unmaskedvalue":
						return o && o.inputmask ? o.inputmask.unmaskedvalue() : t(o).val();
					case "remove":
						return this.each(function () {
							this.inputmask && this.inputmask.remove()
						});
					case "getemptymask":
						return o && o.inputmask ? o.inputmask.getemptymask() : "";
					case "hasMaskedValue":
						return !(!o || !o.inputmask) && o.inputmask.hasMaskedValue();
					case "isComplete":
						return !o || !o.inputmask || o.inputmask.isComplete();
					case "getmetadata":
						return o && o.inputmask ? o.inputmask.getmetadata() : void 0;
					case "setvalue":
						e.setValue(o, i);
						break;
					case "option":
						if ("string" != typeof i) return this.each(function () {
							if (void 0 !== this.inputmask) return this.inputmask.option(i)
						});
						if (o && void 0 !== o.inputmask) return o.inputmask.option(i);
						break;
					default:
						return i.alias = n, r = new e(i), this.each(function () {
							r.mask(this)
						})
				} else {
					if ("object" == (void 0 === n ? "undefined" : s(n))) return r = new e(n), void 0 === n.mask && void 0 === n.alias ? this.each(function () {
						if (void 0 !== this.inputmask) return this.inputmask.option(n);
						r.mask(this)
					}) : this.each(function () {
						r.mask(this)
					});
					if (void 0 === n) return this.each(function () {
						(r = new e(i)).mask(this)
					})
				}
			}), t.fn.inputmask
		}, r = [n(2), n(1)], void 0 === (o = "function" == typeof (i = a) ? i.apply(e, r) : i) || (t.exports = o)
	}]),
	function (t) {
		"function" == typeof define && define.amd ? define(["jquery"], t) : "object" == typeof module && module.exports ? module.exports = t(require("jquery")) : t(jQuery)
	}(function (t) {
		t.extend(t.fn, {
			validate: function (e) {
				if (!this.length) return void(e && e.debug && window.console && console.warn("Nothing selected, can't validate, returning nothing."));
				var n = t.data(this[0], "validator");
				return n || (this.attr("novalidate", "novalidate"), n = new t.validator(e, this[0]), t.data(this[0], "validator", n), n.settings.onsubmit && (this.on("click.validate", ":submit", function (e) {
					n.submitButton = e.currentTarget, t(this).hasClass("cancel") && (n.cancelSubmit = !0), t(this).attr("formnovalidate") !== undefined && (n.cancelSubmit = !0)
				}), this.on("submit.validate", function (e) {
					function i() {
						var i, r;
						return n.submitButton && (n.settings.submitHandler || n.formSubmitted) && (i = t("<input type='hidden'/>").attr("name", n.submitButton.name).val(t(n.submitButton).val()).appendTo(n.currentForm)), !n.settings.submitHandler || (r = n.settings.submitHandler.call(n, n.currentForm, e), i && i.remove(), r !== undefined && r)
					}
					return n.settings.debug && e.preventDefault(), n.cancelSubmit ? (n.cancelSubmit = !1, i()) : n.form() ? n.pendingRequest ? (n.formSubmitted = !0, !1) : i() : (n.focusInvalid(), !1)
				})), n)
			},
			valid: function () {
				var e, n, i;
				return t(this[0]).is("form") ? e = this.validate().form() : (i = [], e = !0, n = t(this[0].form).validate(), this.each(function () {
					(e = n.element(this) && e) || (i = i.concat(n.errorList))
				}), n.errorList = i), e
			},
			rules: function (e, n) {
				var i, r, o, a, s, l, u = this[0];
				if (null != u && (!u.form && u.hasAttribute("contenteditable") && (u.form = this.closest("form")[0], u.name = this.attr("name")), null != u.form)) {
					if (e) switch (i = t.data(u.form, "validator").settings, r = i.rules, o = t.validator.staticRules(u), e) {
						case "add":
							t.extend(o, t.validator.normalizeRule(n)), delete o.messages, r[u.name] = o, n.messages && (i.messages[u.name] = t.extend(i.messages[u.name], n.messages));
							break;
						case "remove":
							return n ? (l = {}, t.each(n.split(/\s/), function (t, e) {
								l[e] = o[e], delete o[e]
							}), l) : (delete r[u.name], o)
					}
					return a = t.validator.normalizeRules(t.extend({}, t.validator.classRules(u), t.validator.attributeRules(u), t.validator.dataRules(u), t.validator.staticRules(u)), u), a.required && (s = a.required, delete a.required, a = t.extend({
						required: s
					}, a)), a.remote && (s = a.remote, delete a.remote, a = t.extend(a, {
						remote: s
					})), a
				}
			}
		}), t.extend(t.expr.pseudos || t.expr[":"], {
			blank: function (e) {
				return !t.trim("" + t(e).val())
			},
			filled: function (e) {
				var n = t(e).val();
				return null !== n && !!t.trim("" + n)
			},
			unchecked: function (e) {
				return !t(e).prop("checked")
			}
		}), t.validator = function (e, n) {
			this.settings = t.extend(!0, {}, t.validator.defaults, e), this.currentForm = n, this.init()
		}, t.validator.format = function (e, n) {
			return 1 === arguments.length ? function () {
				var n = t.makeArray(arguments);
				return n.unshift(e), t.validator.format.apply(this, n)
			} : n === undefined ? e : (arguments.length > 2 && n.constructor !== Array && (n = t.makeArray(arguments).slice(1)), n.constructor !== Array && (n = [n]), t.each(n, function (t, n) {
				e = e.replace(new RegExp("\\{" + t + "\\}", "g"), function () {
					return n
				})
			}), e)
		}, t.extend(t.validator, {
			defaults: {
				messages: {},
				groups: {},
				rules: {},
				errorClass: "error",
				pendingClass: "pending",
				validClass: "valid",
				errorElement: "label",
				focusCleanup: !1,
				focusInvalid: !0,
				errorContainer: t([]),
				errorLabelContainer: t([]),
				onsubmit: !0,
				ignore: ":hidden",
				ignoreTitle: !1,
				onfocusin: function (t) {
					this.lastActive = t, this.settings.focusCleanup && (this.settings.unhighlight && this.settings.unhighlight.call(this, t, this.settings.errorClass, this.settings.validClass), this.hideThese(this.errorsFor(t)))
				},
				onfocusout: function (t) {
					this.checkable(t) || !(t.name in this.submitted) && this.optional(t) || this.element(t)
				},
				onkeyup: function (e, n) {
					var i = [16, 17, 18, 20, 35, 36, 37, 38, 39, 40, 45, 144, 225];
					9 === n.which && "" === this.elementValue(e) || -1 !== t.inArray(n.keyCode, i) || (e.name in this.submitted || e.name in this.invalid) && this.element(e)
				},
				onclick: function (t) {
					t.name in this.submitted ? this.element(t) : t.parentNode.name in this.submitted && this.element(t.parentNode)
				},
				highlight: function (e, n, i) {
					"radio" === e.type ? this.findByName(e.name).addClass(n).removeClass(i) : t(e).addClass(n).removeClass(i)
				},
				unhighlight: function (e, n, i) {
					"radio" === e.type ? this.findByName(e.name).removeClass(n).addClass(i) : t(e).removeClass(n).addClass(i)
				}
			},
			setDefaults: function (e) {
				t.extend(t.validator.defaults, e)
			},
			messages: {
				required: "This field is required.",
				remote: "Please fix this field.",
				email: "Please enter a valid email address.",
				url: "Please enter a valid URL.",
				date: "Please enter a valid date.",
				dateISO: "Please enter a valid date (ISO).",
				number: "Please enter a valid number.",
				digits: "Please enter only digits.",
				equalTo: "Please enter the same value again.",
				maxlength: t.validator.format("Please enter no more than {0} characters."),
				minlength: t.validator.format("Please enter at least {0} characters."),
				rangelength: t.validator.format("Please enter a value between {0} and {1} characters long."),
				range: t.validator.format("Please enter a value between {0} and {1}."),
				max: t.validator.format("Please enter a value less than or equal to {0}."),
				min: t.validator.format("Please enter a value greater than or equal to {0}."),
				step: t.validator.format("Please enter a multiple of {0}.")
			},
			autoCreateRanges: !1,
			prototype: {
				init: function () {
					function e(e) {
						!this.form && this.hasAttribute("contenteditable") && (this.form = t(this).closest("form")[0], this.name = t(this).attr("name"));
						var n = t.data(this.form, "validator"),
							i = "on" + e.type.replace(/^validate/, ""),
							r = n.settings;
						r[i] && !t(this).is(r.ignore) && r[i].call(n, this, e)
					}
					this.labelContainer = t(this.settings.errorLabelContainer), this.errorContext = this.labelContainer.length && this.labelContainer || t(this.currentForm), this.containers = t(this.settings.errorContainer).add(this.settings.errorLabelContainer), this.submitted = {}, this.valueCache = {}, this.pendingRequest = 0, this.pending = {}, this.invalid = {}, this.reset();
					var n, i = this.groups = {};
					t.each(this.settings.groups, function (e, n) {
						"string" == typeof n && (n = n.split(/\s/)), t.each(n, function (t, n) {
							i[n] = e
						})
					}), n = this.settings.rules, t.each(n, function (e, i) {
						n[e] = t.validator.normalizeRule(i)
					}), t(this.currentForm).on("focusin.validate focusout.validate keyup.validate", ":text, [type='password'], [type='file'], select, textarea, [type='number'], [type='search'], [type='tel'], [type='url'], [type='email'], [type='datetime'], [type='date'], [type='month'], [type='week'], [type='time'], [type='datetime-local'], [type='range'], [type='color'], [type='radio'], [type='checkbox'], [contenteditable], [type='button']", e).on("click.validate", "select, option, [type='radio'], [type='checkbox']", e), this.settings.invalidHandler && t(this.currentForm).on("invalid-form.validate", this.settings.invalidHandler)
				},
				form: function () {
					return this.checkForm(), t.extend(this.submitted, this.errorMap), this.invalid = t.extend({}, this.errorMap), this.valid() || t(this.currentForm).triggerHandler("invalid-form", [this]), this.showErrors(), this.valid()
				},
				checkForm: function () {
					this.prepareForm();
					for (var t = 0, e = this.currentElements = this.elements(); e[t]; t++) this.check(e[t]);
					return this.valid()
				},
				element: function (e) {
					var n, i, r = this.clean(e),
						o = this.validationTargetFor(r),
						a = this,
						s = !0;
					return o === undefined ? delete this.invalid[r.name] : (this.prepareElement(o), this.currentElements = t(o), i = this.groups[o.name], i && t.each(this.groups, function (t, e) {
						e === i && t !== o.name && (r = a.validationTargetFor(a.clean(a.findByName(t)))) && r.name in a.invalid && (a.currentElements.push(r), s = a.check(r) && s)
					}), n = !1 !== this.check(o), s = s && n, this.invalid[o.name] = !n, this.numberOfInvalids() || (this.toHide = this.toHide.add(this.containers)), this.showErrors(), t(e).attr("aria-invalid", !n)), s
				},
				showErrors: function (e) {
					if (e) {
						var n = this;
						t.extend(this.errorMap, e), this.errorList = t.map(this.errorMap, function (t, e) {
							return {
								message: t,
								element: n.findByName(e)[0]
							}
						}), this.successList = t.grep(this.successList, function (t) {
							return !(t.name in e)
						})
					}
					this.settings.showErrors ? this.settings.showErrors.call(this, this.errorMap, this.errorList) : this.defaultShowErrors()
				},
				resetForm: function () {
					t.fn.resetForm && t(this.currentForm).resetForm(), this.invalid = {}, this.submitted = {}, this.prepareForm(), this.hideErrors();
					var e = this.elements().removeData("previousValue").removeAttr("aria-invalid");
					this.resetElements(e)
				},
				resetElements: function (t) {
					var e;
					if (this.settings.unhighlight)
						for (e = 0; t[e]; e++) this.settings.unhighlight.call(this, t[e], this.settings.errorClass, ""), this.findByName(t[e].name).removeClass(this.settings.validClass);
					else t.removeClass(this.settings.errorClass).removeClass(this.settings.validClass)
				},
				numberOfInvalids: function () {
					return this.objectLength(this.invalid)
				},
				objectLength: function (t) {
					var e, n = 0;
					for (e in t) t[e] !== undefined && null !== t[e] && !1 !== t[e] && n++;
					return n
				},
				hideErrors: function () {
					this.hideThese(this.toHide)
				},
				hideThese: function (t) {
					t.not(this.containers).text(""), this.addWrapper(t).hide()
				},
				valid: function () {
					return 0 === this.size()
				},
				size: function () {
					return this.errorList.length
				},
				focusInvalid: function () {
					if (this.settings.focusInvalid) try {
						t(this.findLastActive() || this.errorList.length && this.errorList[0].element || []).filter(":visible").focus().trigger("focusin")
					} catch (t) {}
				},
				findLastActive: function () {
					var e = this.lastActive;
					return e && 1 === t.grep(this.errorList, function (t) {
						return t.element.name === e.name
					}).length && e
				},
				elements: function () {
					var e = this,
						n = {};
					return t(this.currentForm).find("input, select, textarea, [contenteditable]").not(":submit, :reset, :image, :disabled").not(this.settings.ignore).filter(function () {
						var i = this.name || t(this).attr("name");
						return !i && e.settings.debug && window.console && console.error("%o has no name assigned", this), this.hasAttribute("contenteditable") && (this.form = t(this).closest("form")[0], this.name = i), !(i in n || !e.objectLength(t(this).rules())) && (n[i] = !0, !0)
					})
				},
				clean: function (e) {
					return t(e)[0]
				},
				errors: function () {
					var e = this.settings.errorClass.split(" ").join(".");
					return t(this.settings.errorElement + "." + e, this.errorContext)
				},
				resetInternals: function () {
					this.successList = [], this.errorList = [], this.errorMap = {}, this.toShow = t([]), this.toHide = t([])
				},
				reset: function () {
					this.resetInternals(), this.currentElements = t([])
				},
				prepareForm: function () {
					this.reset(), this.toHide = this.errors().add(this.containers)
				},
				prepareElement: function (t) {
					this.reset(), this.toHide = this.errorsFor(t)
				},
				elementValue: function (e) {
					var n, i, r = t(e),
						o = e.type;
					return "radio" === o || "checkbox" === o ? this.findByName(e.name).filter(":checked").val() : "number" === o && "undefined" != typeof e.validity ? e.validity.badInput ? "NaN" : r.val() : (n = e.hasAttribute("contenteditable") ? r.text() : r.val(), "file" === o ? "C:\\fakepath\\" === n.substr(0, 12) ? n.substr(12) : (i = n.lastIndexOf("/")) >= 0 ? n.substr(i + 1) : (i = n.lastIndexOf("\\"), i >= 0 ? n.substr(i + 1) : n) : "string" == typeof n ? n.replace(/\r/g, "") : n)
				},
				check: function (e) {
					e = this.validationTargetFor(this.clean(e));
					var n, i, r, o, a = t(e).rules(),
						s = t.map(a, function (t, e) {
							return e
						}).length,
						l = !1,
						u = this.elementValue(e);
					if ("function" == typeof a.normalizer ? o = a.normalizer : "function" == typeof this.settings.normalizer && (o = this.settings.normalizer), o) {
						if ("string" != typeof (u = o.call(e, u))) throw new TypeError("The normalizer should return a string value.");
						delete a.normalizer
					}
					for (i in a) {
						r = {
							method: i,
							parameters: a[i]
						};
						try {
							if ("dependency-mismatch" === (n = t.validator.methods[i].call(this, u, e, r.parameters)) && 1 === s) {
								l = !0;
								continue
							}
							if (l = !1, "pending" === n) return void(this.toHide = this.toHide.not(this.errorsFor(e)));
							if (!n) return this.formatAndAdd(e, r), !1
						} catch (t) {
							throw this.settings.debug && window.console && console.log("Exception occurred when checking element " + e.id + ", check the '" + r.method + "' method.", t), t instanceof TypeError && (t.message += ".  Exception occurred when checking element " + e.id + ", check the '" + r.method + "' method."), t
						}
					}
					if (!l) return this.objectLength(a) && this.successList.push(e), !0
				},
				customDataMessage: function (e, n) {
					return t(e).data("msg" + n.charAt(0).toUpperCase() + n.substring(1).toLowerCase()) || t(e).data("msg")
				},
				customMessage: function (t, e) {
					var n = this.settings.messages[t];
					return n && (n.constructor === String ? n : n[e])
				},
				findDefined: function () {
					for (var t = 0; t < arguments.length; t++)
						if (arguments[t] !== undefined) return arguments[t];
					return undefined
				},
				defaultMessage: function (e, n) {
					"string" == typeof n && (n = {
						method: n
					});
					var i = this.findDefined(this.customMessage(e.name, n.method), this.customDataMessage(e, n.method), !this.settings.ignoreTitle && e.title || undefined, t.validator.messages[n.method], "<strong>Warning: No message defined for " + e.name + "</strong>"),
						r = /\$?\{(\d+)\}/g;
					return "function" == typeof i ? i = i.call(this, n.parameters, e) : r.test(i) && (i = t.validator.format(i.replace(r, "{$1}"), n.parameters)), i
				},
				formatAndAdd: function (t, e) {
					var n = this.defaultMessage(t, e);
					this.errorList.push({
						message: n,
						element: t,
						method: e.method
					}), this.errorMap[t.name] = n, this.submitted[t.name] = n
				},
				addWrapper: function (t) {
					return this.settings.wrapper && (t = t.add(t.parent(this.settings.wrapper))), t
				},
				defaultShowErrors: function () {
					var t, e, n;
					for (t = 0; this.errorList[t]; t++) n = this.errorList[t], this.settings.highlight && this.settings.highlight.call(this, n.element, this.settings.errorClass, this.settings.validClass), this.showLabel(n.element, n.message);
					if (this.errorList.length && (this.toShow = this.toShow.add(this.containers)), this.settings.success)
						for (t = 0; this.successList[t]; t++) this.showLabel(this.successList[t]);
					if (this.settings.unhighlight)
						for (t = 0, e = this.validElements(); e[t]; t++) this.settings.unhighlight.call(this, e[t], this.settings.errorClass, this.settings.validClass);
					this.toHide = this.toHide.not(this.toShow), this.hideErrors(), this.addWrapper(this.toShow).show()
				},
				validElements: function () {
					return this.currentElements.not(this.invalidElements())
				},
				invalidElements: function () {
					return t(this.errorList).map(function () {
						return this.element
					})
				},
				showLabel: function (e, n) {
					var i, r, o, a, s = this.errorsFor(e),
						l = this.idOrName(e),
						u = t(e).attr("aria-describedby");
					s.length ? (s.removeClass(this.settings.validClass).addClass(this.settings.errorClass), s.html(n)) : (s = t("<" + this.settings.errorElement + ">").attr("id", l + "-error").addClass(this.settings.errorClass).html(n || ""), i = s, this.settings.wrapper && (i = s.hide().show().wrap("<" + this.settings.wrapper + "/>").parent()), this.labelContainer.length ? this.labelContainer.append(i) : this.settings.errorPlacement ? this.settings.errorPlacement.call(this, i, t(e)) : i.insertAfter(e), s.is("label") ? s.attr("for", l) : 0 === s.parents("label[for='" + this.escapeCssMeta(l) + "']").length && (o = s.attr("id"), u ? u.match(new RegExp("\\b" + this.escapeCssMeta(o) + "\\b")) || (u += " " + o) : u = o, t(e).attr("aria-describedby", u), (r = this.groups[e.name]) && (a = this, t.each(a.groups, function (e, n) {
						n === r && t("[name='" + a.escapeCssMeta(e) + "']", a.currentForm).attr("aria-describedby", s.attr("id"))
					})))), !n && this.settings.success && (s.text(""), "string" == typeof this.settings.success ? s.addClass(this.settings.success) : this.settings.success(s, e)), this.toShow = this.toShow.add(s)
				},
				errorsFor: function (e) {
					var n = this.escapeCssMeta(this.idOrName(e)),
						i = t(e).attr("aria-describedby"),
						r = "label[for='" + n + "'], label[for='" + n + "'] *";
					return i && (r = r + ", #" + this.escapeCssMeta(i).replace(/\s+/g, ", #")), this.errors().filter(r)
				},
				escapeCssMeta: function (t) {
					return t.replace(/([\\!"#$%&'()*+,./:;<=>?@\[\]^`{|}~])/g, "\\$1")
				},
				idOrName: function (t) {
					return this.groups[t.name] || (this.checkable(t) ? t.name : t.id || t.name)
				},
				validationTargetFor: function (e) {
					return this.checkable(e) && (e = this.findByName(e.name)), t(e).not(this.settings.ignore)[0]
				},
				checkable: function (t) {
					return /radio|checkbox/i.test(t.type)
				},
				findByName: function (e) {
					return t(this.currentForm).find("[name='" + this.escapeCssMeta(e) + "']")
				},
				getLength: function (e, n) {
					switch (n.nodeName.toLowerCase()) {
						case "select":
							return t("option:selected", n).length;
						case "input":
							if (this.checkable(n)) return this.findByName(n.name).filter(":checked").length
					}
					return e.length
				},
				depend: function (t, e) {
					return !this.dependTypes[typeof t] || this.dependTypes[typeof t](t, e)
				},
				dependTypes: {
					"boolean": function (t) {
						return t
					},
					string: function (e, n) {
						return !!t(e, n.form).length
					},
					"function": function (t, e) {
						return t(e)
					}
				},
				optional: function (e) {
					var n = this.elementValue(e);
					return !t.validator.methods.required.call(this, n, e) && "dependency-mismatch"
				},
				startRequest: function (e) {
					this.pending[e.name] || (this.pendingRequest++, t(e).addClass(this.settings.pendingClass), this.pending[e.name] = !0)
				},
				stopRequest: function (e, n) {
					this.pendingRequest--, this.pendingRequest < 0 && (this.pendingRequest = 0), delete this.pending[e.name], t(e).removeClass(this.settings.pendingClass), n && 0 === this.pendingRequest && this.formSubmitted && this.form() ? (t(this.currentForm).submit(), this.submitButton && t("input:hidden[name='" + this.submitButton.name + "']", this.currentForm).remove(), this.formSubmitted = !1) : !n && 0 === this.pendingRequest && this.formSubmitted && (t(this.currentForm).triggerHandler("invalid-form", [this]), this.formSubmitted = !1)
				},
				previousValue: function (e, n) {
					return n = "string" == typeof n && n || "remote", t.data(e, "previousValue") || t.data(e, "previousValue", {
						old: null,
						valid: !0,
						message: this.defaultMessage(e, {
							method: n
						})
					})
				},
				destroy: function () {
					this.resetForm(), t(this.currentForm).off(".validate").removeData("validator").find(".validate-equalTo-blur").off(".validate-equalTo").removeClass("validate-equalTo-blur")
				}
			},
			classRuleSettings: {
				required: {
					required: !0
				},
				email: {
					email: !0
				},
				url: {
					url: !0
				},
				date: {
					date: !0
				},
				dateISO: {
					dateISO: !0
				},
				number: {
					number: !0
				},
				digits: {
					digits: !0
				},
				creditcard: {
					creditcard: !0
				}
			},
			addClassRules: function (e, n) {
				e.constructor === String ? this.classRuleSettings[e] = n : t.extend(this.classRuleSettings, e)
			},
			classRules: function (e) {
				var n = {},
					i = t(e).attr("class");
				return i && t.each(i.split(" "), function () {
					this in t.validator.classRuleSettings && t.extend(n, t.validator.classRuleSettings[this])
				}), n
			},
			normalizeAttributeRule: function (t, e, n, i) {
				/min|max|step/.test(n) && (null === e || /number|range|text/.test(e)) && (i = Number(i), isNaN(i) && (i = undefined)), i || 0 === i ? t[n] = i : e === n && "range" !== e && (t[n] = !0)
			},
			attributeRules: function (e) {
				var n, i, r = {},
					o = t(e),
					a = e.getAttribute("type");
				for (n in t.validator.methods) "required" === n ? (i = e.getAttribute(n), "" === i && (i = !0), i = !!i) : i = o.attr(n), this.normalizeAttributeRule(r, a, n, i);
				return r.maxlength && /-1|2147483647|524288/.test(r.maxlength) && delete r.maxlength, r
			},
			dataRules: function (e) {
				var n, i, r = {},
					o = t(e),
					a = e.getAttribute("type");
				for (n in t.validator.methods) i = o.data("rule" + n.charAt(0).toUpperCase() + n.substring(1).toLowerCase()), this.normalizeAttributeRule(r, a, n, i);
				return r
			},
			staticRules: function (e) {
				var n = {},
					i = t.data(e.form, "validator");
				return i.settings.rules && (n = t.validator.normalizeRule(i.settings.rules[e.name]) || {}), n
			},
			normalizeRules: function (e, n) {
				return t.each(e, function (i, r) {
					if (!1 === r) return void delete e[i];
					if (r.param || r.depends) {
						var o = !0;
						switch (typeof r.depends) {
							case "string":
								o = !!t(r.depends, n.form).length;
								break;
							case "function":
								o = r.depends.call(n, n)
						}
						o ? e[i] = r.param === undefined || r.param : (t.data(n.form, "validator").resetElements(t(n)), delete e[i])
					}
				}), t.each(e, function (i, r) {
					e[i] = t.isFunction(r) && "normalizer" !== i ? r(n) : r
				}), t.each(["minlength", "maxlength"], function () {
					e[this] && (e[this] = Number(e[this]))
				}), t.each(["rangelength", "range"], function () {
					var n;
					e[this] && (t.isArray(e[this]) ? e[this] = [Number(e[this][0]), Number(e[this][1])] : "string" == typeof e[this] && (n = e[this].replace(/[\[\]]/g, "").split(/[\s,]+/), e[this] = [Number(n[0]), Number(n[1])]))
				}), t.validator.autoCreateRanges && (null != e.min && null != e.max && (e.range = [e.min, e.max], delete e.min, delete e.max), null != e.minlength && null != e.maxlength && (e.rangelength = [e.minlength, e.maxlength], delete e.minlength, delete e.maxlength)), e
			},
			normalizeRule: function (e) {
				if ("string" == typeof e) {
					var n = {};
					t.each(e.split(/\s/), function () {
						n[this] = !0
					}), e = n
				}
				return e
			},
			addMethod: function (e, n, i) {
				t.validator.methods[e] = n, t.validator.messages[e] = i !== undefined ? i : t.validator.messages[e], n.length < 3 && t.validator.addClassRules(e, t.validator.normalizeRule(e))
			},
			methods: {
				required: function (e, n, i) {
					if (!this.depend(i, n)) return "dependency-mismatch";
					if ("select" === n.nodeName.toLowerCase()) {
						var r = t(n).val();
						return r && r.length > 0
					}
					return this.checkable(n) ? this.getLength(e, n) > 0 : e.length > 0
				},
				email: function (t, e) {
					return this.optional(e) || /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(t)
				},
				url: function (t, e) {
					return this.optional(e) || /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})).?)(?::\d{2,5})?(?:[/?#]\S*)?$/i.test(t)
				},
				date: function (t, e) {
					return this.optional(e) || !/Invalid|NaN/.test(new Date(t).toString())
				},
				dateISO: function (t, e) {
					return this.optional(e) || /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/.test(t)
				},
				number: function (t, e) {
					return this.optional(e) || /^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/.test(t)
				},
				digits: function (t, e) {
					return this.optional(e) || /^\d+$/.test(t)
				},
				minlength: function (e, n, i) {
					var r = t.isArray(e) ? e.length : this.getLength(e, n);
					return this.optional(n) || r >= i
				},
				maxlength: function (e, n, i) {
					var r = t.isArray(e) ? e.length : this.getLength(e, n);
					return this.optional(n) || r <= i
				},
				rangelength: function (e, n, i) {
					var r = t.isArray(e) ? e.length : this.getLength(e, n);
					return this.optional(n) || r >= i[0] && r <= i[1]
				},
				min: function (t, e, n) {
					return this.optional(e) || t >= n
				},
				max: function (t, e, n) {
					return this.optional(e) || t <= n
				},
				range: function (t, e, n) {
					return this.optional(e) || t >= n[0] && t <= n[1]
				},
				step: function (e, n, i) {
					var r, o = t(n).attr("type"),
						a = "Step attribute on input type " + o + " is not supported.",
						s = ["text", "number", "range"],
						l = new RegExp("\\b" + o + "\\b"),
						u = o && !l.test(s.join()),
						c = function (t) {
							var e = ("" + t).match(/(?:\.(\d+))?$/);
							return e && e[1] ? e[1].length : 0
						},
						p = function (t) {
							return Math.round(t * Math.pow(10, r))
						},
						d = !0;
					if (u) throw new Error(a);
					return r = c(i), (c(e) > r || p(e) % p(i) != 0) && (d = !1), this.optional(n) || d
				},
				equalTo: function (e, n, i) {
					var r = t(i);
					return this.settings.onfocusout && r.not(".validate-equalTo-blur").length && r.addClass("validate-equalTo-blur").on("blur.validate-equalTo", function () {
						t(n).valid()
					}), e === r.val()
				},
				remote: function (e, n, i, r) {
					if (this.optional(n)) return "dependency-mismatch";
					r = "string" == typeof r && r || "remote";
					var o, a, s, l = this.previousValue(n, r);
					return this.settings.messages[n.name] || (this.settings.messages[n.name] = {}), l.originalMessage = l.originalMessage || this.settings.messages[n.name][r], this.settings.messages[n.name][r] = l.message, i = "string" == typeof i && {
						url: i
					} || i, s = t.param(t.extend({
						data: e
					}, i.data)), l.old === s ? l.valid : (l.old = s, o = this, this.startRequest(n), a = {}, a[n.name] = e, t.ajax(t.extend(!0, {
						mode: "abort",
						port: "validate" + n.name,
						dataType: "json",
						data: a,
						context: o.currentForm,
						success: function (t) {
							var i, a, s, u = !0 === t || "true" === t;
							o.settings.messages[n.name][r] = l.originalMessage, u ? (s = o.formSubmitted, o.resetInternals(), o.toHide = o.errorsFor(n), o.formSubmitted = s, o.successList.push(n), o.invalid[n.name] = !1, o.showErrors()) : (i = {}, a = t || o.defaultMessage(n, {
								method: r,
								parameters: e
							}), i[n.name] = l.message = a, o.invalid[n.name] = !0, o.showErrors(i)), l.valid = u, o.stopRequest(n, u)
						}
					}, i)), "pending")
				}
			}
		});
		var e, n = {};
		return t.ajaxPrefilter ? t.ajaxPrefilter(function (t, e, i) {
			var r = t.port;
			"abort" === t.mode && (n[r] && n[r].abort(), n[r] = i)
		}) : (e = t.ajax, t.ajax = function (i) {
			var r = ("mode" in i ? i : t.ajaxSettings).mode,
				o = ("port" in i ? i : t.ajaxSettings).port;
			return "abort" === r ? (n[o] && n[o].abort(), n[o] = e.apply(this, arguments), n[o]) : e.apply(this, arguments)
		}), t
	}),
	function () {
		var t = this;
		(function () {
			(function () {
				var t = [].slice;
				this.LocalTime = {
					config: {},
					run: function () {
						return this.getController().processElements()
					},
					process: function () {
						var e, n, i, r;
						for (n = 1 <= arguments.length ? t.call(arguments, 0) : [], i = 0, r = n.length; i < r; i++) e = n[i], this.getController().processElement(e);
						return n.length
					},
					getController: function () {
						return null != this.controller ? this.controller : this.controller = new e.Controller
					}
				}
			}).call(this)
		}).call(t);
		var e = t.LocalTime;
		(function () {
			(function () {
				e.config.i18n = {
					en: {
						date: {
							dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
							abbrDayNames: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
							monthNames: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
							abbrMonthNames: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
							yesterday: "yesterday",
							today: "today",
							tomorrow: "tomorrow",
							on: "on {date}",
							formats: {
								"default": "%b %e, %Y",
								thisYear: "%b %e"
							}
						},
						time: {
							am: "am",
							pm: "pm",
							singular: "a {time}",
							singularAn: "an {time}",
							elapsed: "{time} ago",
							second: "second",
							seconds: "seconds",
							minute: "minute",
							minutes: "minutes",
							hour: "hour",
							hours: "hours",
							formats: {
								"default": "%l:%M%P"
							}
						},
						datetime: {
							at: "{date} at {time}",
							formats: {
								"default": "%B %e, %Y at %l:%M%P %Z"
							}
						}
					}
				}
			}).call(this),
				function () {
					e.config.locale = "en", e.config.defaultLocale = "en"
				}.call(this),
				function () {
					e.config.timerInterval = 6e4
				}.call(this),
				function () {
					var t, n, i;
					i = !isNaN(Date.parse("2011-01-01T12:00:00-05:00")), e.parseDate = function (t) {
						return t = t.toString(), i || (t = n(t)), new Date(Date.parse(t))
					}, t = /^(\d{4})-(\d{2})-(\d{2})T(\d{2}):(\d{2}):(\d{2})(Z|[-+]?[\d:]+)$/, n = function (e) {
						var n, i, r, o, a, s, l, u, c;
						if (r = e.match(t)) return r[0], u = r[1], a = r[2], n = r[3], i = r[4], o = r[5], l = r[6], c = r[7], "Z" !== c && (s = c.replace(":", "")), u + "/" + a + "/" + n + " " + i + ":" + o + ":" + l + " GMT" + [s]
					}
				}.call(this),
				function () {
					e.elementMatchesSelector = function () {
						var t, e, n, i, r, o;
						return t = document.documentElement, e = null != (n = null != (i = null != (r = null != (o = t.matches) ? o : t.matchesSelector) ? r : t.webkitMatchesSelector) ? i : t.mozMatchesSelector) ? n : t.msMatchesSelector,
							function (t, n) {
								if ((null != t ? t.nodeType : void 0) === Node.ELEMENT_NODE) return e.call(t, n)
							}
					}()
				}.call(this),
				function () {
					var t, n, i;
					t = e.config, i = t.i18n, e.getI18nValue = function (r, o) {
						var a, s;
						return null == r && (r = ""), a = (null != o ? o : {
							locale: t.locale
						}).locale, s = n(i[a], r), null != s ? s : a !== t.defaultLocale ? e.getI18nValue(r, {
							locale: t.defaultLocale
						}) : void 0
					}, e.translate = function (t, n, i) {
						var r, o, a;
						null == n && (n = {}), a = e.getI18nValue(t, i);
						for (r in n) o = n[r], a = a.replace("{" + r + "}", o);
						return a
					}, n = function (t, e) {
						var n, i, r, o, a;
						for (a = t, o = e.split("."), n = 0, r = o.length; n < r; n++) {
							if (i = o[n], null == a[i]) return null;
							a = a[i]
						}
						return a
					}
				}.call(this),
				function () {
					var t, n, i, r, o;
					t = e.getI18nValue, o = e.translate, e.strftime = r = function (e, a) {
						var s, l, u, c, p, d, f;
						return l = e.getDay(), s = e.getDate(), p = e.getMonth(), f = e.getFullYear(), u = e.getHours(), c = e.getMinutes(), d = e.getSeconds(), a.replace(/%(-?)([%aAbBcdeHIlmMpPSwyYZ])/g, function (a, h, m) {
							switch (m) {
								case "%":
									return "%";
								case "a":
									return t("date.abbrDayNames")[l];
								case "A":
									return t("date.dayNames")[l];
								case "b":
									return t("date.abbrMonthNames")[p];
								case "B":
									return t("date.monthNames")[p];
								case "c":
									return e.toString();
								case "d":
									return n(s, h);
								case "e":
									return s;
								case "H":
									return n(u, h);
								case "I":
									return n(r(e, "%l"), h);
								case "l":
									return 0 === u || 12 === u ? 12 : (u + 12) % 12;
								case "m":
									return n(p + 1, h);
								case "M":
									return n(c, h);
								case "p":
									return o("time." + (u > 11 ? "pm" : "am")).toUpperCase();
								case "P":
									return o("time." + (u > 11 ? "pm" : "am"));
								case "S":
									return n(d, h);
								case "w":
									return l;
								case "y":
									return n(f % 100, h);
								case "Y":
									return f;
								case "Z":
									return i(e)
							}
						})
					}, n = function (t, e) {
						switch (e) {
							case "-":
								return t;
							default:
								return ("0" + t).slice(-2)
						}
					}, i = function (t) {
						var e, n, i, r, o;
						return o = t.toString(), (e = null != (n = o.match(/\(([\w\s]+)\)$/)) ? n[1] : void 0) ? /\s/.test(e) ? e.match(/\b(\w)/g).join("") : e : (e = null != (i = o.match(/(\w{3,4})\s\d{4}$/)) ? i[1] : void 0) ? e : (e = null != (r = o.match(/(UTC[\+\-]\d+)/)) ? r[1] : void 0) ? e : ""
					}
				}.call(this),
				function () {
					e.CalendarDate = function () {
						function t(t, e, n) {
							this.date = new Date(Date.UTC(t, e - 1)), this.date.setUTCDate(n), this.year = this.date.getUTCFullYear(), this.month = this.date.getUTCMonth() + 1, this.day = this.date.getUTCDate(), this.value = this.date.getTime()
						}
						return t.fromDate = function (t) {
							return new this(t.getFullYear(), t.getMonth() + 1, t.getDate())
						}, t.today = function () {
							return this.fromDate(new Date)
						}, t.prototype.equals = function (t) {
							return (null != t ? t.value : void 0) === this.value
						}, t.prototype.is = function (t) {
							return this.equals(t)
						}, t.prototype.isToday = function () {
							return this.is(this.constructor.today())
						}, t.prototype.occursOnSameYearAs = function (t) {
							return this.year === (null != t ? t.year : void 0)
						}, t.prototype.occursThisYear = function () {
							return this.occursOnSameYearAs(this.constructor.today())
						}, t.prototype.daysSince = function (t) {
							if (t) return (this.date - t.date) / 864e5
						}, t.prototype.daysPassed = function () {
							return this.constructor.today().daysSince(this)
						}, t
					}()
				}.call(this),
				function () {
					var t, n, i;
					n = e.strftime, i = e.translate, t = e.getI18nValue, e.RelativeTime = function () {
						function r(t) {
							this.date = t, this.calendarDate = e.CalendarDate.fromDate(this.date)
						}
						return r.prototype.toString = function () {
							var t, e;
							return (e = this.toTimeElapsedString()) ? i("time.elapsed", {
								time: e
							}) : (t = this.toWeekdayString()) ? (e = this.toTimeString(), i("datetime.at", {
								date: t,
								time: e
							})) : i("date.on", {
								date: this.toDateString()
							})
						}, r.prototype.toTimeOrDateString = function () {
							return this.calendarDate.isToday() ? this.toTimeString() : this.toDateString()
						}, r.prototype.toTimeElapsedString = function () {
							var t, e, n, r, o;
							return n = (new Date).getTime() - this.date.getTime(), r = Math.round(n / 1e3), e = Math.round(r / 60), t = Math.round(e / 60), n < 0 ? null : r < 10 ? (o = i("time.second"), i("time.singular", {
								time: o
							})) : r < 45 ? r + " " + i("time.seconds") : r < 90 ? (o = i("time.minute"), i("time.singular", {
								time: o
							})) : e < 45 ? e + " " + i("time.minutes") : e < 90 ? (o = i("time.hour"), i("time.singularAn", {
								time: o
							})) : t < 24 ? t + " " + i("time.hours") : ""
						}, r.prototype.toWeekdayString = function () {
							switch (this.calendarDate.daysPassed()) {
								case 0:
									return i("date.today");
								case 1:
									return i("date.yesterday");
								case -1:
									return i("date.tomorrow");
								case 2:
								case 3:
								case 4:
								case 5:
								case 6:
									return n(this.date, "%A");
								default:
									return ""
							}
						}, r.prototype.toDateString = function () {
							var e;
							return e = t(this.calendarDate.occursThisYear() ? "date.formats.thisYear" : "date.formats.default"), n(this.date, e)
						}, r.prototype.toTimeString = function () {
							return n(this.date, t("time.formats.default"))
						}, r
					}()
				}.call(this),
				function () {
					var t, n = function (t, e) {
						return function () {
							return t.apply(e, arguments)
						}
					};
					t = e.elementMatchesSelector, e.PageObserver = function () {
						function e(t, e) {
							this.selector = t, this.callback = e, this.processInsertion = n(this.processInsertion, this), this.processMutations = n(this.processMutations, this)
						}
						return e.prototype.start = function () {
							if (!this.started) return this.observeWithMutationObserver() || this.observeWithMutationEvent(), this.started = !0
						}, e.prototype.observeWithMutationObserver = function () {
							var t;
							if ("undefined" != typeof MutationObserver && null !== MutationObserver) return t = new MutationObserver(this.processMutations), t.observe(document.documentElement, {
								childList: !0,
								subtree: !0
							}), !0
						}, e.prototype.observeWithMutationEvent = function () {
							return addEventListener("DOMNodeInserted", this.processInsertion, !1), !0
						}, e.prototype.findSignificantElements = function (e) {
							var n;
							return n = [], (null != e ? e.nodeType : void 0) === Node.ELEMENT_NODE && (t(e, this.selector) && n.push(e), n.push.apply(n, e.querySelectorAll(this.selector))), n
						}, e.prototype.processMutations = function (t) {
							var e, n, i, r, o, a, s, l;
							for (e = [], n = 0, r = t.length; n < r; n++) switch (a = t[n], a.type) {
								case "childList":
									for (l = a.addedNodes, i = 0, o = l.length; i < o; i++) s = l[i], e.push.apply(e, this.findSignificantElements(s))
							}
							return this.notify(e)
						}, e.prototype.processInsertion = function (t) {
							var e;
							return e = this.findSignificantElements(t.target), this.notify(e)
						}, e.prototype.notify = function (t) {
							if (null != t ? t.length : void 0) return "function" == typeof this.callback ? this.callback(t) : void 0
						}, e
					}()
				}.call(this),
				function () {
					var t, n, i, r, o = function (t, e) {
						return function () {
							return t.apply(e, arguments)
						}
					};
					i = e.parseDate, r = e.strftime, n = e.getI18nValue, t = e.config, e.Controller = function () {
						function a() {
							this.processElements = o(this.processElements, this), this.pageObserver = new e.PageObserver(s, this.processElements)
						}
						var s, l, u;
						return s = "time[data-local]:not([data-localized])", a.prototype.start = function () {
							if (!this.started) return this.processElements(), this.startTimer(), this.pageObserver.start(), this.started = !0
						}, a.prototype.startTimer = function () {
							var e;
							if (e = t.timerInterval) return null != this.timer ? this.timer : this.timer = setInterval(this.processElements, e)
						}, a.prototype.processElements = function (t) {
							var e, n, i;
							for (null == t && (t = document.querySelectorAll(s)), n = 0, i = t.length; n < i; n++) e = t[n], this.processElement(e);
							return t.length
						}, a.prototype.processElement = function (t) {
							var e, o, a, s, c, p;
							if (o = t.getAttribute("datetime"), a = t.getAttribute("data-format"), s = t.getAttribute("data-local"), c = i(o), !isNaN(c)) return t.hasAttribute("title") || (p = r(c, n("datetime.formats.default")), t.setAttribute("title", p)), t.textContent = e = function () {
								switch (s) {
									case "time":
										return l(t), r(c, a);
									case "date":
										return l(t), u(c).toDateString();
									case "time-ago":
										return u(c).toString();
									case "time-or-date":
										return u(c).toTimeOrDateString();
									case "weekday":
										return u(c).toWeekdayString();
									case "weekday-or-date":
										return u(c).toWeekdayString() || u(c).toDateString()
								}
							}(), t.hasAttribute("aria-label") ? void 0 : t.setAttribute("aria-label", e)
						}, l = function (t) {
							return t.setAttribute("data-localized", "")
						}, u = function (t) {
							return new e.RelativeTime(t)
						}, a
					}()
				}.call(this),
				function () {
					var t, n, i, r;
					r = !1, t = function () {
						return document.attachEvent ? "complete" === document.readyState : "loading" !== document.readyState
					}, n = function (t) {
						var e;
						return null != (e = "function" == typeof requestAnimationFrame ? requestAnimationFrame(t) : void 0) ? e : setTimeout(t, 17)
					}, i = function () {
						var t;
						return t = e.getController(), t.start()
					}, e.start = function () {
						if (!r) return r = !0, "undefined" != typeof MutationObserver && null !== MutationObserver || t() ? i() : n(i)
					}, window.LocalTime === e && e.start()
				}.call(this)
		}).call(this), "object" == typeof module && module.exports ? module.exports = e : "function" == typeof define && define.amd && define(e)
	}.call(this),
	function () {}.call(this),
	function () {
		"use strict";
		window.addEventListener("load", function () {
			console.log("load....");
			var t = document.getElementById("needs-validation");
			t && t.addEventListener("submit", function (e) {
				
				!1 === t.checkValidity() && (e.preventDefault(), e.stopPropagation()), t.classList.add("was-validated")
			}, !1)
		}, !1)
	}(), $(function () {
		$(":input").inputmask()
	}), $(document).on("turbolinks:load", function () {
		$("#needs-validation").validate({
		
			rules: {
				"accNo": {
					digits: !0,
					minlength: 14,
					maxlength: 14
				},
				"applicationPrefNo": {
					required: !0,
					regex: /^[a-zA-Z0-9]{2,20}$/,
					minlength: 3,
					maxlength: 20
				},
				"applicationMobileNo": {
					required: !0
				},
				"prefCorp":{
					duplicatePref:"#application_form_application_enterprise_attributes_pref_corp"
				}, 
				"monthlyLimit": {
					greaterThan: "#application_form_application_enterprise_attributes_daily_limit",
					minlength: 3,
					maxlength: 9
				},
				"dailyLimit": {
					lesserThan: "#application_form_application_enterprise_attributes_monthly_limit",
					minlength: 3,
					maxlength: 7
				},
				"applicationTransLimit": {
					required: !0,
					lesserThan: "#application_form_application_enterprise_attributes_daily_limit",
					minlength: 3,
					maxlength: 7
				},
				"applicationAuthSignatory": {
					required: !0
				}
			},
			messages: {
				"accNo": {
					required: "Account No. cannot be blank. Please provide valid 14 digit Account No.",
					minlength: "Please provide valid 14 digit Account No.",
					maxlength: "Please provide valid 14 digit Account No."
				},
				"accName": {
					required: "Please provide a valid Account Name."
				},
				"custNo": {
					required: "Please provide a valid Customer ID."
				},
				"branchCode": {
					required: "Please provide a valid Branch."
				},
				"address": {
					required: "Please provide a valid Preferred Address."
				},
				"constitution": {
					required: "Please provide a valid Constitution."
				},
				"userName": {
					required: "Please provide a valid User Name."
				},
				"applicationPrefNo": {
					required: "Please provide a valid Preferred User ID.",
					regex: "Should only contain alphanumeric charachers.",
					minlength: "Preferred User ID should be between 3 and 20 alphanumeric characters long.",
					maxlength: "Preferred User ID should be between 3 and 20 alphanumeric characters long."
				},
				"applicationCustNo": {
					required: "Please provide a valid  Customer ID."
				},
				"applicationTransLimit": {
					lesserThan: "Transaction limit must be lesser than daily limit."
				},
				"prefCorp": {
					required: "Please provide a valid Preferred Corporate ID.",
					minlength: "Preferred Corporate ID should be between 3 and 20 alphanumeric characters long.",
					duplicatePref:"Corporate Id Already exist",
					maxlength: "Preferred Corporate ID should be between 3 and 20 alphanumeric characters long."
				},
				"authFund": {
					required: "Please provide No of authorizers required for fund transfer"
				},
				"authExt": {
					required: "Please provide No of authorizers required for external user addition"
				},
				"authBen": {
					required: "Please provide No of authorizers required for beneficiary addition"
				},
				"documentfile": {
					required: "Please select a pdf file."
				},
				"dailyLimit": {
					required: "Please provide a valid Daily Limit.",
					lesserThan: "Daily limit must be less than Monthly limit"
				},
				"monthlyLimit": {
					required: "Please provide a valid Monthly Limit.",
					greaterThan: "Monthly limit must be greater than Daily limit"
				},
				"applicationMobileNo": {
					required: "Cannot proceed without mobile no.",
					minlength: "Please check the mobile number",
					maxlength: "Please check the mobile number"
				},
				"documentfile": {
					required: "Please select a pdf file"
				},
				"applicationAuthSignatory": {
					required: "You must select at least 1 Authorized Signatory to proceed."
				}
			},
			errorPlacement: function (t, e) {
				console.log(e.attr("type")), "checkbox" === e.attr("type") ? t.insertAfter(e.parent()) : t.insertAfter(e)
			}
		})
	}), $.validator.addMethod("greaterThan", function (t, e, n) {
		var i = $(n);
		return console.log(parseInt(t, 10)), console.log(parseInt(i.val(), 10)), parseInt(t, 10) >= parseInt(i.val(), 10)
	}), $.validator.addMethod("lesserThan", function (t, e, n) {
		var i = $(n);
		return parseInt(t, 10) <= parseInt(i.val(), 10)
	}), $.validator.addMethod("regex", function (t, e, n) {
		var i = new RegExp(n);
		return this.optional(e) || i.test(t)
	}, $.validator.addMethod("duplicatePref", function (t, e, n) {
		var corp=document.getElementById("application_form_application_enterprise_attributes_pref_corp").value;
		var buttonValue=document.getElementById("submit-button")!=null?document.getElementById("submit-button").value:"Forward";
		 console.log("prefcorp value "+corp+" button "+buttonValue);
		 
		 
		 
		 var buttonValue=null;
			
			
			if(document.getElementById("submit-button").value!=null){
				 buttonValue=document.getElementById("submit-button").value;
			}else{
			       buttonValue="Forward";
			}
			console.log(document.getElementById("submit-button"));
			console.log(document.getElementById("submit-button").value);
			console.log("button---------  2   "+document.getElementById("submit-button").value);
		 
		 
		 var i;
		 if( buttonValue!="Forward"){
			 console.log("doing prefcorp validation ");
		 $.when(
		  $.ajax({
				url : "validatePrefCorp",
				data:{"validatePrefCorp":corp},
	            async:false,
	            error : function() {
	            	alert_box("danger","Error Occured");
	     			
	     			exist= false;
	            },
	            success : function(data) {
	            /*   var val=data;
	              if(val!=0){
		     			 console.log("if block 1: ");
		     			return false
	              }else{
	            	  document.getElementById("prefcorpvalidate").innerHTML='';
	     			 console.log("else block 2: ");
	     			return true
	              } */
	            } 
	})
		  ).done(function(data){
			  i=data;
		  })
	}else{
		i=0;
		  }
		  if(i>0){
			  return false;
		  }
		  else {
			  return true;
		  }
	
	}),"");