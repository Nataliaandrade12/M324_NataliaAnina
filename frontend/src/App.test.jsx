import { render, screen, waitFor } from "@testing-library/react";
import { describe, it, expect, vi, beforeEach, afterEach } from "vitest";
import App from "./App";

beforeEach(() => {
  global.fetch = vi.fn(() => Promise.reject(new Error("Backend Fehler")));
});

afterEach(() => {
  vi.restoreAllMocks();
});

describe("Todo App", () => {
  it("zeigt eine Fehlermeldung wenn das Laden fehlschlägt", async () => {
    render(<App />);

    await waitFor(() => {
      expect(screen.getByText(/fehler/i)).toBeTruthy();
    });
  });
});